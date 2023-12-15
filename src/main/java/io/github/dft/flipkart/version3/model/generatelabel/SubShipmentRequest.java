package io.github.dft.flipkart.version3.model.generatelabel;

import io.github.dft.flipkart.version3.model.shipment.Dimension;
import lombok.Data;

@Data
public class SubShipmentRequest {

    private String subShipmentId;
    private Dimension dimensions;
}