package com.coin.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coin.tracker.entities.Coin;

public interface CoinRepository extends JpaRepository<Coin, Long>{

}
