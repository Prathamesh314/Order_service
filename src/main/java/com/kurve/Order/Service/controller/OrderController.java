package com.kurve.Order.Service.controller;

import com.kurve.Order.Service.dto.OrderRequest;
import com.kurve.Order.Service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest)
    {
        orderService.addOrder(orderRequest);
        return "Order placed successfully";
    }

}
