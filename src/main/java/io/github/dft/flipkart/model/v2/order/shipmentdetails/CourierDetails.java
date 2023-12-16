package io.github.dft.flipkart.model.v2.order.shipmentdetails;

import lombok.Data;

@Data
public class CourierDetails {
    private String trackingId;
    private String vendorName;
}