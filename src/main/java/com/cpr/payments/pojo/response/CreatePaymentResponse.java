package com.cpr.payments.pojo.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentResponse {
    private String id;
    private String url;
}
