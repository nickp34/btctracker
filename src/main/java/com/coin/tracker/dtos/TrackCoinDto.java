package com.coin.tracker.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrackCoinDto {
  private String address;
}
