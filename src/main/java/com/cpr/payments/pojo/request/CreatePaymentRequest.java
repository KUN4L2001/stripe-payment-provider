package com.cpr.payments.pojo.request;

import java.util.List;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {
    private String txnRef;
    private List<LineItem> lineItems;
    private String successUrl;
    private String cancelUrl;
}
