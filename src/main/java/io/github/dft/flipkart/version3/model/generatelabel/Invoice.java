package io.github.dft.flipkart.version3.model.generatelabel;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Invoice {

    private String orderId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;

    private String orderNumber;
}