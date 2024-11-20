package com.poly.schedule_manager_be.controller;

import com.poly.schedule_manager_be.dto.request.PaymentRequest;
import com.poly.schedule_manager_be.dto.response.ApiResponse;
import com.poly.schedule_manager_be.dto.response.AreaResponse;
import com.poly.schedule_manager_be.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.payos.type.PaymentData;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PaymentController {

    PaymentService paymentService;

    @PostMapping("/create-payment-link")
    ApiResponse<?> createPaymentLink(@RequestBody List<PaymentRequest> request) throws Exception {
        return ApiResponse.<String>builder()
                .message("Tạo link thanh toán thành công")
                .data(paymentService.createPaymentLink(request))
                .build();
    }
}
