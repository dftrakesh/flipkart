package io.github.dft.flipkart.model.v3.selfship;

import lombok.Data;

import java.util.List;

@Data
public class ShipmentRequest {
    private List<Shipment> shipments;
}