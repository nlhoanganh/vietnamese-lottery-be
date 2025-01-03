package com.flexible.lottery.service;

import com.flexible.lottery.entity.LotteryResult;

import java.io.IOException;
import java.util.Date;

public interface CrawlingService {
    LotteryResult crawlLotteryResultOnDate(Date drawDate);
}
