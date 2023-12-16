package io.github.dft.flipkart.model.v2.order;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.dft.flipkart.model.common.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDate {

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime fromDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime toDate;
}