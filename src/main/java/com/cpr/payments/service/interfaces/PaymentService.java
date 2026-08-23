package com.cpr.payments.service.interfaces;

import com.cpr.payments.dto.request.CreatePaymentRequestDTO;
import com.cpr.payments.dto.response.CreatePaymentResponseDTO;

public interface PaymentService {
    CreatePaymentResponseDTO processPayment(CreatePaymentRequestDTO createPaymentRequestDTO);
}
