package io.github.dft.flipkart.model.productapi;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressLabel {

    private List<String> manufacturerDetails;
    private List<String> importerDetails;
    private List<String> packerDetails;
    private List<String> countriesOfOrigin;
}
