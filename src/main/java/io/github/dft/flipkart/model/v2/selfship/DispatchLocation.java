package io.github.dft.flipkart.model.v2.selfship;

import lombok.Data;

@Data
public class DispatchLocation{
    private String locationId;
    private Address address;
}