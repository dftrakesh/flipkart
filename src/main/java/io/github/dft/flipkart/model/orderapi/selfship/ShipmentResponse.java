package io.github.dft.flipkart.model.orderapi.selfship;

import lombok.Data;

@Data
public class ShipmentResponse {
    private String shipmentId;
    private String processingStatus;
    private String errorCode;
    private String errorMessage;
}