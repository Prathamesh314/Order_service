package com.kurve.Order.Service.service;

import com.kurve.Order.Service.dto.OrderRequest;
import com.kurve.Order.Service.models.Order;
import com.kurve.Order.Service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void addOrder(OrderRequest orderRequest)
    {
        Order order = Order.builder()
                .orderNumber(orderRequest.orderNumber)
                .skuCode(orderRequest.skuCode)
                .price(orderRequest.price)
                .quantity(orderRequest.quantity)
                .build();

        orderRepository.save(order);
    }

}
