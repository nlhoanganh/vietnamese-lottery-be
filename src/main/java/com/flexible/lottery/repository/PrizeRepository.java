package com.flexible.lottery.repository;

import com.flexible.lottery.entity.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrizeRepository extends JpaRepository<Prize, Integer> {
    Optional<Prize> findPrizeByName(String prizeId);
}
