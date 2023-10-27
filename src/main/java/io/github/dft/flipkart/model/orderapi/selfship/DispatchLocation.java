package io.github.dft.flipkart.model.orderapi.selfship;

import lombok.Data;

@Data
public class DispatchLocation{
    private String locationId;
    private Address address;
}