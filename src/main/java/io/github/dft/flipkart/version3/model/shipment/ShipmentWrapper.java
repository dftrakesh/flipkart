package io.github.dft.flipkart.version3.model.shipment;

import lombok.Data;

import java.util.List;

@Data
public class ShipmentWrapper {

    private List<Shipment> shipments;
}