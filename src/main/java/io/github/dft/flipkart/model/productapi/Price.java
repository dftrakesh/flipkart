package io.github.dft.flipkart.model.productapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Price {

    private Integer mrp;
    private Integer flipkartSellingPrice;
    private String currency;
    private Integer sellingPrice;
    private Integer nlc;
    private Integer dealerPrice;
    private Integer mop;
}
