package io.github.dft.flipkart.version3.model.shipment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.dft.flipkart.model.common.LocalDateTimeDeserializer;
import io.github.dft.flipkart.model.orderapi.OrderItem;
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

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dispatchByDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dispatchAfterDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;
}