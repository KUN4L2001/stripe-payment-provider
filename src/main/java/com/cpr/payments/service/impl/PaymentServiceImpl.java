package com.cpr.payments.service.impl;

import com.cpr.payments.dto.request.CreatePaymentRequestDTO;
import com.cpr.payments.dto.response.CreatePaymentResponseDTO;
import com.cpr.payments.service.interfaces.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
  @Override
  public CreatePaymentResponseDTO processPayment(CreatePaymentRequestDTO createPaymentRequestDTO) {
    return CreatePaymentResponseDTO.builder().id("2").url("https//stripe:/pay").build();
  }
}
