package io.github.dft.flipkart.model.v3.generatelabel;

import io.github.dft.flipkart.model.v3.shipment.Dimension;
import lombok.Data;

@Data
public class SubShipmentRequest {

    private String subShipmentId;
    private Dimension dimensions;
}