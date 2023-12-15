package io.github.dft.flipkart.version3.model.shipment;

import lombok.Data;

@Data
public class Package {

    private String packageId;
    private String packageSku;
    private Dimension dimensions;
}