package io.github.dft.flipkart.model.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializerV3 extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    @Override
    @SneakyThrows
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        String dateAsString = jsonParser.getText();
        return LocalDateTime.parse(dateAsString, formatter);
    }
}
