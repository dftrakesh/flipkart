package io.github.dft.flipkart.model.v2.order.shipmentdetails;

import lombok.Data;

@Data
public class Courier {
    private CourierDetails pickupDetails;
    private CourierDetails deliveryDetails;
}