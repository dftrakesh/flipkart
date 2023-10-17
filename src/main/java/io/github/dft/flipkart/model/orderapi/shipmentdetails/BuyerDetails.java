package io.github.dft.flipkart.model.orderapi.shipmentdetails;

import lombok.Data;

@Data
public class BuyerDetails {
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String primaryEmail;
}