package io.github.dft.flipkart.model.orderapi.selfship;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.dft.flipkart.model.common.LocalDateTimeDeserializer;
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
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime tentativeDeliveryDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dispatchDate;
}