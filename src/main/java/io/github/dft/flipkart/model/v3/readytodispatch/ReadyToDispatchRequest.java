package io.github.dft.flipkart.model.v3.readytodispatch;

import lombok.Data;

import java.util.List;

@Data
public class ReadyToDispatchRequest {
    private List<String> shipmentIds;
    private String locationId;
}