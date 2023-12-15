package io.github.dft.flipkart.model.v2.order.shipmentdetails;

import lombok.Data;

@Data
public class OrderItems {
    private String id;
    private Boolean fragile;
    private Boolean large;
    private Boolean dangerous;
}