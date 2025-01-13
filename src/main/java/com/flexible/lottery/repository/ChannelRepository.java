package com.flexible.lottery.repository;

import com.flexible.lottery.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    Optional<Channel> getChannelByName(String name);
}
