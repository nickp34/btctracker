package com.coin.tracker.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

// noted in notion, but would not really be storing users in our database
@Entity
@Table(name = "user")
@Builder
public class User {
  @Id
  @GeneratedValue
  private Long id;  //would probably use UUID's here, but this makes it easy to demo

  @Column
  private String email;
}