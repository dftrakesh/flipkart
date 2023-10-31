package io.github.dft.flipkart.model.orderapi.selfship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentResponse {
    private String shipmentId;
    private String processingStatus;
    private String errorCode;
    private String errorMessage;
}