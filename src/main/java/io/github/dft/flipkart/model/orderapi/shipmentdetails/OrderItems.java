package io.github.dft.flipkart.model.orderapi.shipmentdetails;

import lombok.Data;

@Data
public class OrderItems {
    private String id;
    private Boolean fragile;
    private Boolean large;
    private Boolean dangerous;
}