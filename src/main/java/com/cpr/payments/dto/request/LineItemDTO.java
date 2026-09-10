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
  private String quantity;
  private String currency;
  private String name;
  private String unitAmount;
}
