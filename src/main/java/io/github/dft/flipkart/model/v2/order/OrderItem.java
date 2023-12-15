package io.github.dft.flipkart.model.v2.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.dft.flipkart.model.common.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItem {

    private String orderItemId;
    private String orderId;
    private String cancellationGroupId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime orderDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime deliverByDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime cancellationDate;
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

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dispatchAfterDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dispatchByDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;
    private Integer sla;
    private String shippingPincode;
    private List<String> stateDocuments;
    private List<Object> subItems;
    private String shipmentId;
    private String shipmentType;
    private List<Object> services;
}