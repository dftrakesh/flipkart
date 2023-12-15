package io.github.dft.flipkart.model.v2.selfship;

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