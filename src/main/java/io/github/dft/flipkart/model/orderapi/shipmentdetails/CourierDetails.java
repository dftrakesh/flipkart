package io.github.dft.flipkart.model.orderapi.shipmentdetails;

import lombok.Data;

@Data
public class CourierDetails {
    private String trackingId;
    private String vendorName;
}