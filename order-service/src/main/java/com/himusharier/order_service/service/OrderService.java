package com.himusharier.order_service.service;

import com.himusharier.order_service.common.Payment;
import com.himusharier.order_service.common.TransactionRequest;
import com.himusharier.order_service.common.TransactionResponse;
import com.himusharier.order_service.entity.Order;
import com.himusharier.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private RestTemplate template;

    public TransactionResponse saveOrder(TransactionRequest request) {
        String response = "";

        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        Payment paymentResponse = template.postForObject("http://localhost:9191/payment/do-payment", payment, Payment.class);
        response = "success".equals(paymentResponse.getPaymentStatus())
                ? "payment processing successful and order placed"
                : "there is a failure in payment api, order added to cart";

        repository.save(order);

        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
