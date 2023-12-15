package io.github.dft.flipkart.model.v2.selfship;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.dft.flipkart.model.common.LocalDateTimeDeserializer;
import io.github.dft.flipkart.model.common.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Invoice{
    private String invoiceNumber;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime invoiceDate;

    private List<Item> items;
}