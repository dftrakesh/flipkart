package io.github.dft.flipkart;

import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.model.v2.order.OrderItem;
import io.github.dft.flipkart.model.v2.order.OrderItemResponse;
import io.github.dft.flipkart.model.v2.order.OrderRequest;
import io.github.dft.flipkart.model.v2.order.OrderResponse;
import io.github.dft.flipkart.model.v2.order.shipmentdetails.ShipmentResponse;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.flipkart.constantcodes.ConstantCodes.API_BASE_END_POINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.SHIPMENT_ENDPOINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.SLASH_CHARACTER;

public class OrderApi extends FlipkartSdk {

    String ORDER_ENDPOINT = "/orders";
    String ORDER_SEARCH = "/search";
    String VERSION_V2_ENDPOINT = "/v2";

    public OrderApi(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public OrderResponse searchAllOrder(OrderRequest orderRequest) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION_V2_ENDPOINT + ORDER_ENDPOINT + ORDER_SEARCH);

        HttpRequest request = postWithObject(uri, orderRequest);
        return getRequestWrapped(request, OrderResponse.class);
    }

    public OrderItem getOrderByOrderItemId(Long orderItemId){
        URI uri = URI.create(API_BASE_END_POINT + VERSION_V2_ENDPOINT + ORDER_ENDPOINT + SLASH_CHARACTER + orderItemId);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, OrderItem.class);

    }

    public OrderResponse searchNextPageOrder(String endPoint) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION_V2_ENDPOINT + endPoint);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, OrderResponse.class);
    }

    public ShipmentResponse getShipmentDetailsByOrderItemId(HashMap<String, String> params) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION_V2_ENDPOINT + ORDER_ENDPOINT + SHIPMENT_ENDPOINT);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShipmentResponse.class);
    }

    public OrderItemResponse getOrderItems(HashMap<String, String> params) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION_V2_ENDPOINT + ORDER_ENDPOINT);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, OrderItemResponse.class);
    }
}