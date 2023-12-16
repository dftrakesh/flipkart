package io.github.dft.flipkart.model.v3.shipment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.dft.flipkart.model.common.LocalDateTimeDeserializerV3;
import io.github.dft.flipkart.model.common.LocalDateTimeSerializer;
import io.github.dft.flipkart.model.v2.order.PriceComponents;
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

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializerV3.class)
    private LocalDateTime orderDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializerV3.class)
    private LocalDateTime deliverByDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializerV3.class)
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

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializerV3.class)
    private LocalDateTime dispatchAfterDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializerV3.class)
    private LocalDateTime dispatchByDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializerV3.class)
    private LocalDateTime updatedAt;
    private Integer sla;
    private String shippingPincode;
    private List<String> stateDocuments;
    private List<Object> subItems;
    private String shipmentId;
    private String shipmentType;
    private List<Object> services;
}