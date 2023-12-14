package io.github.dft.flipkart.model.shipmentapi;

import lombok.Data;

@Data
public class SubShipmentRequest {

    private String subShipmentId;
    private Dimension dimensions;
}