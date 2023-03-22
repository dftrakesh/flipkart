package io.github.dft.flipkart.model.productapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AttributeValues {

    private String listingStatus;
    private String procurementSla;
    private String zonalShippingCharge;
    private String nationalShippingCharge;
    private String sellingPrice;
    private String mrp;
    private String stockCount;
    private String localShippingCharge;
}
