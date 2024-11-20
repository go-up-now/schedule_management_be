package com.poly.schedule_manager_be.service;

import com.poly.schedule_manager_be.dto.request.PaymentRequest;

import java.util.List;

public interface PaymentService {
    String createPaymentLink(List<PaymentRequest> request) throws Exception;
}
