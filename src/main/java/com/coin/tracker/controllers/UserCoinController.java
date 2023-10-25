package com.coin.tracker.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coin.tracker.dtos.TrackCoinDto;
import com.coin.tracker.entities.UserCoin;
import com.coin.tracker.repositories.UserCoinRepository;

// not doing an real error checking
@RestController
@RequestMapping("/api/v1/coins")
public class UserCoinController {

  @Autowired
  UserCoinRepository userCoinRepository; //for demo purpose just getting right from a repository. In practice I would have a service layer

  @GetMapping("/{userId}") //for demo i'll accept userId on the path, but would get this from an auth token
  public List<UserCoin> getAll(@PathVariable Long userId) {
    return userCoinRepository.findByUserId(userId);
  }

  @GetMapping("/{userId}/coin/{coinId}")
  public UserCoin getById(@PathVariable Long userId, @PathVariable Long coinId) {
    return userCoinRepository.findByUserAndCoin(userId, coinId);
  }

  @PostMapping("/{userId}/coin/{coinId}") //would be validating these path variables in reality
  public ResponseEntity<UserCoin> trackCoinById(@PathVariable Long userId, @PathVariable Long coinId, @RequestBody TrackCoinDto trackCoinDto) {
    //ignoreing a bunch of validation
    UserCoin newCoin = UserCoin.builder()
      .address(trackCoinDto.getAddress())
      .coinId(coinId)
      .userId(userId)
      .balance(null)
      .lastTimeSync(null)
      .build();

    UserCoin savedCoin = userCoinRepository.save(newCoin);
    return ResponseEntity.ok(savedCoin);
  }

  @DeleteMapping("/{userId}/coin/{coinId}") //would be validating these path variables in reality
  public ResponseEntity<Void> untrackByCoinId(@PathVariable Long userId, @PathVariable Long coinId) {
    UserCoin coin = userCoinRepository.findByUserAndCoin(userId, coinId);
    userCoinRepository.delete(coin);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{userId}/coin/{coinId}/sync") //would be validating these path variables in reality
  @Async("asyncExecutor")
  public CompletableFuture<Void> syncByCoinId(@PathVariable Long userId, @PathVariable Long coinId) throws InterruptedException {
    //DO a long syncing job with other apis to get balances
    //update database with results of sync
    //ignoreing a bunch of exception handling, errors, logging
    Thread.sleep(1000L);
    return CompletableFuture.completedFuture(null);
  }
}
