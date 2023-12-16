package io.github.dft.flipkart.model.v3.generatelabel;

import lombok.Data;

import java.util.List;

@Data
public class GenerateLabelRequest {

    private String shipmentId;
    private String locationId;
    private List<TaxItem> taxItems;
    private List<Invoice> invoices;
    private List<SubShipmentRequest> subShipments;
    private Boolean ignoreWarning;
}