package io.github.dft.flipkart.model.productapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NotionalValue {
    private Integer amount;
    private String unit;
}
