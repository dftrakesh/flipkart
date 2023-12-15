package io.github.dft.flipkart.version3.model.generatelabel;

import lombok.Data;

import java.util.List;

@Data
public class GenerateLabelResponseWrapper {

    private List<GenerateLabelResponse> shipments;
}