package io.github.dft.flipkart.model.v3.generatelabel;

import lombok.Data;

import java.util.List;

@Data
public class GenerateLabelRequestWrapper {

    private List<GenerateLabelRequest> shipments;
}