package io.github.dft.flipkart.model.v3.shipment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.dft.flipkart.model.common.LocalDateTimeDeserializerV3;
import io.github.dft.flipkart.model.common.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Shipment {
    private String shipmentId;
    private String locationId;
    private Boolean hold;
    private Boolean mps;
    private String packagingPolicy;
    private List<SubShipment> subShipments;
    private List<OrderItem> orderItems;
    private List<Forms> forms;
    private String shipmentType;


    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializerV3.class)
    private LocalDateTime dispatchByDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializerV3.class)
    private LocalDateTime dispatchAfterDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializerV3.class)
    private LocalDateTime updatedAt;
}