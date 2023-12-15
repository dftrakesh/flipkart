package io.github.dft.flipkart.version3.model.generatelabel;

import lombok.Data;

@Data
public class GenerateLabelResponse {

    private String shipmentId;
    private String status;
    private String errorCode;
    private String errorMessage;
}