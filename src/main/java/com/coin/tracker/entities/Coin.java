package com.coin.tracker.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "coin")
@Builder
public class Coin {
  @Id
  @GeneratedValue
  private Long id;  //would probably use UUID's here, but this makes it easy to demo

  @Column
  private String name;

  @Column
  private String ticker;
}