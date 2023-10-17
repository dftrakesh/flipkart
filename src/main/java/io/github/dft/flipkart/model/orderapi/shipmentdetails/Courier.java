package io.github.dft.flipkart.model.orderapi.shipmentdetails;

import lombok.Data;

@Data
public class Courier {
    private CourierDetails pickupDetails;
    private CourierDetails deliveryDetails;
}