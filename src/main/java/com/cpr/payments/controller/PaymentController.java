package com.cpr.payments.controller;

import com.cpr.payments.dto.request.CreatePaymentRequestDTO;
import com.cpr.payments.dto.response.CreatePaymentResponseDTO;
import com.cpr.payments.dto.response.ExpirePaymentResponseDTO;
import com.cpr.payments.service.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

  private final ModelMapper modelMapper;
  private final PaymentService paymentService;

  @PostMapping("/create")
  public ResponseEntity<CreatePaymentResponseDTO> createPayment(
      @RequestBody CreatePaymentRequestDTO request) {
    CreatePaymentResponseDTO response = paymentService.processPayment(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PostMapping("/expire/{txnId}")
  public ResponseEntity<ExpirePaymentResponseDTO> expirePayment(@PathVariable String txnId) {
    log.info("expire called");
    ExpirePaymentResponseDTO responseDTO = paymentService.expirePayment(txnId);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }
}
