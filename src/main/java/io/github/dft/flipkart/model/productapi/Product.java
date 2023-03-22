package io.github.dft.flipkart.model.productapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Product {
    public Sku sku;
    public Available available;
    public List<String> unavailable;
    public List<String> invalid;
    public String listingId;
    public String skuId;
    public AttributeValues attributeValues;
    public String status;
}
