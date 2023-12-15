package io.github.dft.flipkart.model.v3.generatelabel;

import lombok.Data;

@Data
public class TaxItem {

    private String orderItemId;
    private Double taxRate;
    private Integer quantity;
}