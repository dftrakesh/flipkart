package io.github.dft.flipkart.model.shipmentapi;

import lombok.Data;

import java.util.List;

@Data
public class SubShipment {

    private String subShipmentId;
    private List<Package> packages;
}