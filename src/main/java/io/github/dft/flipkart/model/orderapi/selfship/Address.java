package io.github.dft.flipkart.model.orderapi.selfship;

import lombok.Data;

@Data
public class Address{
    private String address1;
    private String address2;
    private String landmark;
    private String city;
    private String state;
    private String pincode;
}