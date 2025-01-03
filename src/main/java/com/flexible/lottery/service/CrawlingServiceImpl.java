package com.flexible.lottery.service;

import com.flexible.lottery.entity.LotteryResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class CrawlingServiceImpl implements CrawlingService {
    private static final Logger log = LoggerFactory.getLogger(CrawlingServiceImpl.class);

    @Override
    public LotteryResult crawlLotteryResultOnDate(Date drawDate){
       try {
           LotteryResult result = new LotteryResult();
           Document doc = Jsoup.connect("https://xosothienphu.com/xsmn-02-01-2006.html").get();
           log.info(doc.title());
           System.out.println(doc.body().getElementsByClass("table-xoso"));

           return result;
       } catch (Exception e) {
           e.printStackTrace();
       }

       return null;
    }
}
