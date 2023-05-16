package com.hotel.reservationsystem.service;

import com.hotel.reservationsystem.entity.Payment;
import com.hotel.reservationsystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
    private PaymentRepository paymentRepository;
    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    @Override
    public Payment createPayment(Payment payment){
        return paymentRepository.save(payment);
    }
    @Override
    public Payment updatePayment(Payment payment){
        return paymentRepository.save(payment);
    }
    @Override
    public void deletePayment(int id){
        paymentRepository.deleteById(id);
    }
    @Override
    public Payment getPaymentById(int id){
        return paymentRepository.findById(id).orElse(null);
    }
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
