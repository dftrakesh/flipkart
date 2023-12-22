package io.github.dft.flipkart.model.v2.order;

import lombok.Data;

import java.util.List;

@Data
public class FilterForOrderDate {
    private List<String> states;
    private OrderDate orderDate;
}