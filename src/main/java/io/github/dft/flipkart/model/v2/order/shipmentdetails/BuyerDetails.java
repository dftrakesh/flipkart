package io.github.dft.flipkart.model.v2.order.shipmentdetails;

import lombok.Data;

@Data
public class BuyerDetails {
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String primaryEmail;
}