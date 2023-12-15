package io.github.dft.flipkart.model.v2.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderItemResponse {
    private List<OrderItem> orderItems;
}