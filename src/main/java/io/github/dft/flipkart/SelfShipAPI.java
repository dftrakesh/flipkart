package io.github.dft.flipkart;

import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.model.orderapi.selfship.ShipmentRequest;
import io.github.dft.flipkart.model.orderapi.selfship.ShipmentResponseWrapper;

import java.net.URI;
import java.net.http.HttpRequest;

import static io.github.dft.flipkart.constantcodes.ConstantCodes.*;

public class SelfShipAPI extends FlipkartSdk {

    String SELF_SHIP_DISPATCH_ENDPOINT = "/selfship/dispatch";

    public SelfShipAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShipmentResponseWrapper createSelfShip(ShipmentRequest shipmentRequest) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION_V3_ENDPOINT + SHIPMENT_ENDPOINT + SELF_SHIP_DISPATCH_ENDPOINT);
        HttpRequest request = postWithObject(uri, shipmentRequest);
        return getRequestWrapped(request, ShipmentResponseWrapper.class);
    }
}