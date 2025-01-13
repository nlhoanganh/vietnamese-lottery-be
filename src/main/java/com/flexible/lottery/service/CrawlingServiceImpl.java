package com.flexible.lottery.service;

import com.flexible.lottery.entity.Channel;
import com.flexible.lottery.entity.LotteryNumber;
import com.flexible.lottery.entity.LotteryResult;
import com.flexible.lottery.entity.Prize;
import com.flexible.lottery.repository.ChannelRepository;
import com.flexible.lottery.repository.LotteryResultRepository;
import com.flexible.lottery.repository.PrizeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CrawlingServiceImpl implements CrawlingService {
    private static final Logger log = LoggerFactory.getLogger(CrawlingServiceImpl.class);

    @Autowired
    private PrizeRepository prizeRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private LotteryResultRepository lotteryResultRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public LotteryResult crawlLotteryResultOnDate(Date drawDate){
       try {
           List<LotteryResult> lotteryResults = new LinkedList<>();
           LotteryResult result = new LotteryResult();
           Document doc = Jsoup.connect("https://xosothienphu.com/xsmn-06-01-2025.html").get();
           Element lotteryResultElement = doc.body().getElementsByClass("table-xoso").get(0);
           Elements channelElements = lotteryResultElement.getElementsByClass("link-city");

           for (Element channelElement : channelElements) {
               String channelName = channelElement.attr("title");

               Optional<Channel> channelOpt = channelRepository.getChannelByName(channelName);
               Channel channel = channelOpt.get();
               if (channelOpt.isPresent()) {
                   LotteryResult lotteryResult = new LotteryResult();
                   lotteryResult.setChannel(channel);
                   lotteryResults.add(lotteryResult);
               } else {
                   log.info("Channel: " + channelName + " not found");
               }
           }


           Elements prizes = lotteryResultElement.getElementsByTag("tbody").first().getElementsByTag("tr");
           for (Element prizeElement : prizes) {
               String prizeName = prizeElement.getElementsByTag("td").first().text();
               Optional<Prize> prize = this.prizeRepository.findPrizeByName(prizeName);
               if (prize.isPresent()) {
                   Elements results = prizeElement.getElementsByTag("span");
                   for (int i = 0; i < lotteryResults.size(); i++) {
                       LotteryNumber lotteryNumber = new LotteryNumber();
                       lotteryNumber.setResult(results.get(i).text());
                       lotteryNumber.setPrize(prize.get());
                       lotteryResults.get(i).getLotteryNumbers().add(lotteryNumber);
                   }
               } else {
                   log.info("Prize " + prizeName + " not found");
               }
           }
           lotteryResultRepository.saveAll(lotteryResults);
           return result;
       } catch (Exception e) {
           e.printStackTrace();
       }

       return null;
    }

    @PostConstruct
    @Transactional
    public void test() {
        log.info("Spring Start");
        this.crawlLotteryResultOnDate(null);
    }
}
