package com.flexible.lottery.repository;

import com.flexible.lottery.entity.LotteryResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryResultRepository extends JpaRepository<LotteryResult, Integer> {

}
