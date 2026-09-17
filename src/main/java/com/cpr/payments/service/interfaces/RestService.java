package com.cpr.payments.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public interface RestService {
  ResponseEntity<String> post(String requestUrl, MultiValueMap<String, String> formData);

  ResponseEntity<String> post(String requestUrl);
}
