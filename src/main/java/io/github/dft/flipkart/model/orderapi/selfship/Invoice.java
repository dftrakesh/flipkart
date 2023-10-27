package io.github.dft.flipkart.model.orderapi.selfship;

import lombok.Data;

import java.util.List;

@Data
public class Invoice{
    private String invoiceNumber;
    private String invoiceDate;
    private List<Item> items;
}