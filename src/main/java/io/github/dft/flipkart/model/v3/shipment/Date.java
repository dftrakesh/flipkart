package io.github.dft.flipkart.model.v3.shipment;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.dft.flipkart.model.common.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Date {

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime from;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime to;
}