package io.github.dft.flipkart.model.orderapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItem {

    private Long orderItemId;
    private String orderId;
    private String cancellationGroupId;
    private String orderDate;
    private String deliverByDate;
    private String cancellationDate;
    private String paymentType;
    private String status;
    private String cancellationReason;
    private String cancellationSubReason;
    private Boolean courierReturn;
    private Integer quantity;
    private String fsn;
    private String sku;
    private String listingId;
    private String hsn;
    private String title;
    private List<String> packageIds;
    private PriceComponents priceComponents;
    private String serviceProfile;
    private Boolean isReplacement;
    private String dispatchServiceTier;
    private Boolean hold;
    private String dispatchAfterDate;
    private String dispatchByDate;
    private String updatedAt;
    private Integer sla;
    private String shippingPincode;
    private List<String> stateDocuments;
    private List<Object> subItems;
    private String shipmentId;
    private String shipmentType;
    private List<Object> services;
}