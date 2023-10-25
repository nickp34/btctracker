package com.coin.tracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coin.tracker.entities.UserCoin;

public interface UserCoinRepository extends JpaRepository<UserCoin, Long>{
  @Query("SELECT c FROM UserCoin c WHERE c.userId = :userId")
  List<UserCoin> findByUserId(@Param("userId") Long userId);

  @Query("SELECT c FROM UserCoin c WHERE c.userId = :userId AND c.coinId = :coinId")
  UserCoin findByUserAndCoin(@Param("userId") Long userId, @Param("coinId") Long coinId);
}
