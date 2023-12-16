package io.github.dft.flipkart.model.v3.selfship;

import lombok.Data;

import java.util.List;

@Data
public class Item{
    private String orderItemId;
    private Integer quantity;
    private List<List<String>> serialNumbers;
}