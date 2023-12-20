package io.github.dft.flipkart.model.v3.common;

import lombok.Data;

import java.util.List;

@Data
public class ShipmentResponseWrapper {

    private List<ShipmentResponse> shipments;
}