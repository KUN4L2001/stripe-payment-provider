package com.cpr.payments.service.impl;

import com.cpr.payments.config.StripeConfigProps;
import com.cpr.payments.dto.request.CreatePaymentRequestDTO;
import com.cpr.payments.dto.response.CreatePaymentResponseDTO;
import com.cpr.payments.dto.response.ExpirePaymentResponseDTO;
import com.cpr.payments.dto.response.RetrievePaymentResponseDTO;
import com.cpr.payments.service.interfaces.PaymentService;
import com.cpr.payments.service.interfaces.RestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

  @Autowired private WebClient webClient;
  @Autowired private ObjectMapper objectMapper;
  @Autowired private StripeConfigProps stripeConfig;
  @Autowired private RestService restService;

  @Override
  public CreatePaymentResponseDTO processPayment(CreatePaymentRequestDTO createPaymentRequestDTO) {
    ResponseEntity<String> response =
        restService.post(stripeConfig.getCreateLinkAPI(), getFormData(createPaymentRequestDTO));
    CreatePaymentResponseDTO requestDTO =
        objectMapper.readValue(response.getBody(), CreatePaymentResponseDTO.class);
    return requestDTO;
  }

  @Override
  public ExpirePaymentResponseDTO expirePayment(String txnId) {
    String stripeExpireUrl = String.format(stripeConfig.getExpireLinkAPI(), txnId);
    ResponseEntity<String> response = restService.post(stripeExpireUrl);
    ExpirePaymentResponseDTO responseDTO =
        objectMapper.readValue(response.getBody(), ExpirePaymentResponseDTO.class);
    return responseDTO;
  }

  @Override
  public RetrievePaymentResponseDTO retrievePayment(String providerRef) {
    String stripeRetrieveUrl = String.format(stripeConfig.getRetrieveLinkApi(), providerRef);
    ResponseEntity<String> response = restService.get(stripeRetrieveUrl);
    RetrievePaymentResponseDTO responseDTO =
        objectMapper.readValue(response.getBody(), RetrievePaymentResponseDTO.class);
    return responseDTO;
  }

  private MultiValueMap<String, String> getFormData(
      CreatePaymentRequestDTO createPaymentRequestDTO) {
    MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();

    formData.add("mode", stripeConfig.getMode());
    formData.add("success_url", stripeConfig.getSuccessUrl());
    formData.add("cancel_url", stripeConfig.getCancelUrl());

    for (int i = 0; i < createPaymentRequestDTO.getLineItems().size(); i++) {
      formData.add(
          "line_items[" + i + "][quantity]",
          String.valueOf(createPaymentRequestDTO.getLineItems().get(i).getQuantity()));
      formData.add(
          "line_items[" + i + "][price_data][currency]",
          createPaymentRequestDTO.getLineItems().get(i).getCurrency());
      formData.add(
          "line_items[" + i + "][price_data][product_data][name]",
          createPaymentRequestDTO.getLineItems().get(i).getProductName());
      formData.add(
          "line_items[" + i + "][price_data][unit_amount]",
          String.valueOf(createPaymentRequestDTO.getLineItems().get(i).getUnitAmount()));
    }
    return formData;
  }
}
