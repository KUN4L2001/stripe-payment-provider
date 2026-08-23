package com.cpr.payments.dto.request;

import com.cpr.payments.pojo.request.LineItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
