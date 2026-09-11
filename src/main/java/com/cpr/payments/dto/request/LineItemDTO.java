package com.cpr.payments.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LineItemDTO {
  private int quantity;
  private String currency;
  private String productName;
  private long unitAmount;
}
