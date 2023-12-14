package io.github.dft.flipkart.model.shipmentapi;

import lombok.Data;

import java.util.List;

@Data
public class ShipmentRequest {

    private String shipmentId;
    private String locationId;
    private List<TaxItem> taxItems;
    private List<Invoice> invoices;
    private List<SubShipmentRequest> subShipments;
    private Boolean ignoreWarning;
}