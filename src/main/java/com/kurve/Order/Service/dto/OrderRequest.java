package com.kurve.Order.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    public String orderNumber;
    public String skuCode;
    public BigDecimal price;
    public Integer quantity;
}
