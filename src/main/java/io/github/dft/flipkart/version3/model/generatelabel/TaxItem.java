package io.github.dft.flipkart.version3.model.generatelabel;

import lombok.Data;

@Data
public class TaxItem {

    private String orderItemId;
    private Double taxRate;
    private Integer quantity;
}