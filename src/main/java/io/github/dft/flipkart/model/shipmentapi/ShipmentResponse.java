package io.github.dft.flipkart.model.shipmentapi;

import lombok.Data;

@Data
public class ShipmentResponse {

    private String shipmentId;
    private String status;
    private String errorCode;
    private String errorMessage;
}