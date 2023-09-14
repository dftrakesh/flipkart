package io.github.dft.flipkart;

import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.model.orderapi.OrderItem;
import io.github.dft.flipkart.model.orderapi.OrderRequest;
import io.github.dft.flipkart.model.orderapi.OrderResponse;

import java.net.URI;
import java.net.http.HttpRequest;

public class OrderApi extends FlipkartSdk {

    String API_BASE_END_POINT = "https://api.flipkart.net/sellers";
    String ORDER_ENDPOINT = "/v2/orders";
    String ORDER_SEARCH = "/search";
    String FORWARD_SLASH = "/";


    public OrderApi(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public OrderResponse searchAllOrder(OrderRequest orderRequest) {
        URI uri = URI.create(API_BASE_END_POINT + ORDER_ENDPOINT + ORDER_SEARCH);

        HttpRequest request = postWithObject(uri, orderRequest);
        return getRequestWrapped(request, OrderResponse.class);
    }

    public OrderItem getOrderByOrderItemId(Long orderItemId){
        URI uri = URI.create(API_BASE_END_POINT +ORDER_ENDPOINT + FORWARD_SLASH + orderItemId);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, OrderItem.class);

    }
}