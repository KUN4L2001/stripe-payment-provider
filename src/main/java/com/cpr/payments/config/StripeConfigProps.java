package com.cpr.payments.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("stripe.config")
public class StripeConfigProps {
  private String secretKey;
  private String successUrl;
  private String cancelUrl;
  private String createLinkAPI;
  private String expireLinkAPI;
  private String mode;
}
