package io.github.dft.flipkart.model.orderapi.shipmentdetails;

import lombok.Data;

@Data
public class Address {
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;
    private String stateCode;
    private String stateName;
    private String landmark;
    private String contactNumber;
}