package io.github.dft.flipkart.model.v3.generatelabel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerateLabelResponse {

    private String shipmentId;
    private String status;
    private String errorCode;
    private String errorMessage;
}