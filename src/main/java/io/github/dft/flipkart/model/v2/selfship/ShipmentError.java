package io.github.dft.flipkart.model.v2.selfship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentError {
    private String type;
    private String code;
    private String message;
}