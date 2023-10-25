package io.github.dft.flipkart.model.orderapi;

import lombok.Data;

import java.util.List;

@Data
public class OrderItemResponse {
    private List<OrderItem> orderItems;
}