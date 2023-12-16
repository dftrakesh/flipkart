package io.github.dft.flipkart.model.v3.generatelabel;

import lombok.Data;

@Data
public class Invoice {

    private String orderId;
    private String invoiceDate;
    private String invoiceNumber;
}