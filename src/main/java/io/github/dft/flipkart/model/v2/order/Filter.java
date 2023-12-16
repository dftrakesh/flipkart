package io.github.dft.flipkart.model.v2.order;

import lombok.Data;

import java.util.List;

@Data
public class Filter {
    private List<String> states;
    private OrderDate orderDate;
    private OrderDate modifiedDate;
}