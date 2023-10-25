package io.github.dft.flipkart;

import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.model.orderapi.OrderItem;
import io.github.dft.flipkart.model.orderapi.OrderItemResponse;
import io.github.dft.flipkart.model.orderapi.OrderRequest;
import io.github.dft.flipkart.model.orderapi.OrderResponse;
import io.github.dft.flipkart.model.orderapi.shipmentdetails.ShipmentResponse;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class OrderApi extends FlipkartSdk {

    String API_BASE_END_POINT = "https://api.flipkart.net/sellers";
    String ORDER_ENDPOINT = "/orders";
    String ORDER_SEARCH = "/search";
    String FORWARD_SLASH = "/";
    String VERSION = "/v2";
    String SHIPMENT_ENDPOINT = "/shipments";


    public OrderApi(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public OrderResponse searchAllOrder(OrderRequest orderRequest) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION + ORDER_ENDPOINT + ORDER_SEARCH);

        HttpRequest request = postWithObject(uri, orderRequest);
        return getRequestWrapped(request, OrderResponse.class);
    }

    public OrderItem getOrderByOrderItemId(Long orderItemId){
        URI uri = URI.create(API_BASE_END_POINT + VERSION + ORDER_ENDPOINT + FORWARD_SLASH + orderItemId);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, OrderItem.class);

    }

    public OrderResponse searchNextPageOrder(String endPoint) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION + endPoint);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, OrderResponse.class);
    }

    public ShipmentResponse getShipmentDetailsByOrderItemId(HashMap<String, String> params) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION + ORDER_ENDPOINT + SHIPMENT_ENDPOINT);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShipmentResponse.class);
    }

    public OrderItemResponse getOrderItems(HashMap<String, String> params) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION + ORDER_ENDPOINT);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, OrderItemResponse.class);
    }
}