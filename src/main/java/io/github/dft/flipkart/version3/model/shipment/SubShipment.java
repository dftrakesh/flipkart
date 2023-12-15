package io.github.dft.flipkart.version3.model.shipment;

import lombok.Data;

import java.util.List;

@Data
public class SubShipment {

    private String subShipmentId;
    private List<Package> packages;
}