package io.github.dft.flipkart.model.v2.selfship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentResponseWrapper {
    private List<ShipmentResponse> shipments;
    private List<ShipmentError> errors;
}