package io.github.dft.flipkart.model.v2.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceComponents {

    private Double sellingPrice;
    private Double totalPrice;
    private Double shippingCharge;
    private Double customerPrice;
    private Double flipkartDiscount;
    private Double subsidy;
}