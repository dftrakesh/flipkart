package io.github.dft.flipkart.model.orderapi.shipmentdetails;

import lombok.Data;

import java.util.List;

@Data
public class ShipmentResponse {
    private List<ShipmentDetails> shipments;
}