package io.github.dft.flipkart.model.productapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Price {

    private Double mrp;
    private Double flipkartSellingPrice;
    private String currency;
    private Double sellingPrice;
    private Integer nlc;
    private Double dealerPrice;
    private Integer mop;
}
