package io.github.dft.flipkart.model.v2.order.shipmentdetails;

import lombok.Data;

import java.util.List;

@Data
public class ShipmentDetails {
    private String orderId;
    private String shipmentId;
    private List<OrderItems> orderItems;
    private Boolean weighingRequired;
    private Address deliveryAddress;
    private Address billingAddress;
    private BuyerDetails buyerDetails;
    private Address sellerAddress;
    private Address returnAddress;
    private Courier courierDetails;
}