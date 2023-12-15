package io.github.dft.flipkart.model.v3.shipment;

import lombok.Data;

import java.util.List;

@Data
public class ShipmentWrapper {

    private List<Shipment> shipments;
}