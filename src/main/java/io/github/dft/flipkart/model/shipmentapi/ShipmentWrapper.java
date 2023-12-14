package io.github.dft.flipkart.model.shipmentapi;

import lombok.Data;

import java.util.List;

@Data
public class ShipmentWrapper {

    private List<Shipment> shipments;
}