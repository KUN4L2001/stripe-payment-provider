package com.cpr.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class StripePaymentProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(StripePaymentProviderApplication.class, args);
  }
}
