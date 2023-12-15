package io.github.dft.flipkart.version3.model.generatelabel;

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