package io.github.dft.flipkart.model.v3.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentResponse {

    private String shipmentId;
    private String status;
    private String errorCode;
    private String errorMessage;
}