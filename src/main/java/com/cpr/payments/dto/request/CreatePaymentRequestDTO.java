package com.cpr.payments.dto.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequestDTO {
  private String txnRef;
  private List<LineItemDTO> lineItems;
  private String successUrl;
  private String cancelUrl;
}
