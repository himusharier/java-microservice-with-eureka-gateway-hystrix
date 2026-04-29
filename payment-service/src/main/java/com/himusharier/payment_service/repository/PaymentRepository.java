package com.himusharier.payment_service.repository;

import com.himusharier.payment_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByOrderId(Integer orderId);
}
