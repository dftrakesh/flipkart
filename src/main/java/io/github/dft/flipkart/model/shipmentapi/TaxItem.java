package io.github.dft.flipkart.model.shipmentapi;

import lombok.Data;

@Data
public class TaxItem {

    private String orderItemId;
    private Double taxRate;
    private Integer quantity;
}