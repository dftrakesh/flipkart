package io.github.dft.flipkart.model.v2.order.shipmentdetails;

import lombok.Data;

import java.util.List;

@Data
public class ShipmentResponse {
    private List<ShipmentDetails> shipments;
}