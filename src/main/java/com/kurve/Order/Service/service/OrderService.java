package com.kurve.Order.Service.service;

import com.kurve.Order.Service.client.InventoryClient;
import com.kurve.Order.Service.dto.OrderRequest;
import com.kurve.Order.Service.models.Order;
import com.kurve.Order.Service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void addOrder(OrderRequest orderRequest)
    {
        var response = inventoryClient.isInStock(orderRequest.skuCode, orderRequest.quantity);

        if(response){
            Order order = Order.builder()
                    .orderNumber(orderRequest.orderNumber)
                    .skuCode(orderRequest.skuCode)
                    .price(orderRequest.price)
                    .quantity(orderRequest.quantity)
                    .build();

            orderRepository.save(order);
        }
        else{
            throw new RuntimeException("Product with skuCode " + orderRequest.skuCode + " is not in stock.");
        }
//        Order order = Order.builder()
//                .orderNumber(orderRequest.orderNumber)
//                .skuCode(orderRequest.skuCode)
//                .price(orderRequest.price)
//                .quantity(orderRequest.quantity)
//                .build();
//
//        orderRepository.save(order);

    }

}
