package com.cpr.payments.controller;

import com.cpr.payments.dto.request.CreatePaymentRequestDTO;
import com.cpr.payments.dto.response.CreatePaymentResponseDTO;
import com.cpr.payments.pojo.request.CreatePaymentRequest;
import com.cpr.payments.pojo.response.CreatePaymentResponse;
import com.cpr.payments.service.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final ModelMapper modelMapper;
    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<CreatePaymentResponse> createPayment(@RequestBody CreatePaymentRequest request){
        CreatePaymentRequestDTO requestDTO = modelMapper.map(request, CreatePaymentRequestDTO.class);
        CreatePaymentResponseDTO responseDTO = paymentService.processPayment(requestDTO);
        CreatePaymentResponse response = modelMapper.map(responseDTO, CreatePaymentResponse.class);
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(response);
    }
}
