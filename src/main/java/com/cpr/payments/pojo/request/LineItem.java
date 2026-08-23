package com.cpr.payments.pojo.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LineItem {
    private String quantity;
    private String currency;
    private String name;
    private String unitAmount;
}
