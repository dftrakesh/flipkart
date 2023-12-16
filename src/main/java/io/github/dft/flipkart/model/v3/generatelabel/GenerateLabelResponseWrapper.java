package io.github.dft.flipkart.model.v3.generatelabel;

import lombok.Data;

import java.util.List;

@Data
public class GenerateLabelResponseWrapper {

    private List<GenerateLabelResponse> shipments;
}