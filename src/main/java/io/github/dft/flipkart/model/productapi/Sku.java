package io.github.dft.flipkart.model.productapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Sku {

    private String skuId;
    private String status;
    private List<Error> errors;
    private String listingId;
    private String productId;
    private Price price;
    private Tax tax;
    private String listingStatus;
    private ShippingFees shippingFees;
    private String marketplace;
    private String fulfillmentProfile;
    private Fulfillment fulfillment;
    private List<Package> packages;
    private List<Location> locations;
    private AddressLabel addressLabel;
    private DatingLabel datingLabel;
    private String archivedStatus;
}
