package io.github.dft.flipkart.model.productapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Fulfillment {
    private Integer dispatchSla;
    private String shippingProvider;
    private String forbidShipping;
    private String procurementType;

}
