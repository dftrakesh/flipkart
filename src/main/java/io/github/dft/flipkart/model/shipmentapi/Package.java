package io.github.dft.flipkart.model.shipmentapi;

import lombok.Data;

@Data
public class Package {

    private String packageId;
    private String packageSku;
    private Dimension dimensions;
}