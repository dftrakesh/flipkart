package io.github.dft.flipkart.model.v2.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {

    private Boolean hasMore;
    private List<OrderItem> orderItems;
    private String url;
    private String nextPageUrl;
    private String previousPageUrl;
}