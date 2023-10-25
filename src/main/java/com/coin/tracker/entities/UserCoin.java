package com.coin.tracker.entities;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "user_coins")
@Builder
public class UserCoin {
  @Id
  @GeneratedValue
  private Long id;  //would probably use UUID's here, but this makes it easy to demo

  @Column
  private Long userId;

  @Column
  private Long coinId;

  @Column
  private String address;

  @Column
  private BigDecimal balance;

  @Column
  private ZonedDateTime lastTimeSync;
}