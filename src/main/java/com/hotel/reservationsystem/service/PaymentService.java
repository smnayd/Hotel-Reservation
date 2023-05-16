package com.hotel.reservationsystem.service;

import com.hotel.reservationsystem.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment updatePayment(Payment payment);
    void deletePayment(int id);
    Payment getPaymentById(int id);
    List<Payment> getAllPayments();
}
