package io.github.dft.flipkart.model.v3.selfship;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.dft.flipkart.model.common.LocalDateTimeDeserializerV3;
import io.github.dft.flipkart.model.common.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Shipment{
    private String shipmentId;
    private String deliveryPartner;
    private String trackingId;
    private String locationId;
    private Invoice invoice;
    private DispatchLocation dispatchLocation;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializerV3.class)
    private LocalDateTime tentativeDeliveryDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializerV3.class)
    private LocalDateTime dispatchDate;
}