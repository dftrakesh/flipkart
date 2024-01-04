package io.github.dft.flipkart.model.v3.shipment;

import lombok.Data;

import java.util.List;

@Data
public class Filter {
    private String type;
    private List<String> states;
    private Date cancellationDate;
}