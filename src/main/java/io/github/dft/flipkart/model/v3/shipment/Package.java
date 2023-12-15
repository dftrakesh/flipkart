package io.github.dft.flipkart.model.v3.shipment;

import lombok.Data;

@Data
public class Package {

    private String packageId;
    private String packageSku;
    private Dimension dimensions;
}