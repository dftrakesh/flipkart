package io.github.dft.flipkart.model.v3.shipment;

import lombok.Data;

import java.util.List;

@Data
public class ShipmentResponseOfCancelledOrder {
    private Boolean hasMore;
    private String nextPageUrl;
    private List<Shipment> shipments;
}