package com.cpr.payments.service.impl;

import com.cpr.payments.config.StripeConfigProps;
import com.cpr.payments.service.interfaces.RestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
@Component
public class RestServiceImpl implements RestService {

  @Autowired private WebClient webClient;
  @Autowired private StripeConfigProps stripeConfig;

  @Override
  public ResponseEntity<String> post(String requestUrl, MultiValueMap<String, String> formData) {

    ResponseEntity<String> response;
    try {
      response =
          webClient
              .method(HttpMethod.POST)
              .uri("https://api.stripe.com/v1/checkout/sessions")
              .header(HttpHeaders.AUTHORIZATION, "Bearer " + stripeConfig.getSecretKey())
              .contentType(MediaType.APPLICATION_FORM_URLENCODED)
              .body(BodyInserters.fromFormData(formData))
              .retrieve()
              .toEntity(String.class)
              .block();
    } catch (WebClientResponseException e) {
      log.error("Stripe status: {}", e.getStatusCode());
      log.error("Stripe response body: {}", e.getResponseBodyAsString());
      throw e;
    }

    return response;
  }
}
