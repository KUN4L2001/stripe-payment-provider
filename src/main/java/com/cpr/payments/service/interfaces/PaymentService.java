package com.cpr.payments.service.interfaces;

import com.cpr.payments.dto.request.CreatePaymentRequestDTO;
import com.cpr.payments.dto.response.CreatePaymentResponseDTO;
import com.cpr.payments.dto.response.ExpirePaymentResponseDTO;
import com.cpr.payments.dto.response.RetrievePaymentResponseDTO;

public interface PaymentService {
  CreatePaymentResponseDTO processPayment(CreatePaymentRequestDTO createPaymentRequestDTO);

  ExpirePaymentResponseDTO expirePayment(String txnId);

  RetrievePaymentResponseDTO retrievePayment(String providerRef);
}
