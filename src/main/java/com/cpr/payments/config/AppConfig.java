package com.cpr.payments.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

  @Bean
  public ModelMapper getModelMapper() {
    return new ModelMapper();
  }

  @Bean
  public WebClient getWebClient() {
    return WebClient.builder().build();
  }

  @Bean
  public ObjectMapper getObjectMapper() {
    return new ObjectMapper();
  }
}
