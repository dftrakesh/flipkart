package io.github.dft.flipkart;

import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.model.v3.generatelabel.GenerateLabelRequestWrapper;
import io.github.dft.flipkart.model.v3.generatelabel.GenerateLabelResponseWrapper;
import io.github.dft.flipkart.model.v3.shipment.ShipmentWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.flipkart.constantcodes.ConstantCodes.API_BASE_END_POINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.LABELS_ENDPOINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.SHIPMENT_ENDPOINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.VERSION_V3_ENDPOINT;

public class ShipmentApi extends FlipkartSdk {

    public ShipmentApi(AccessCredential accessCredential) {
        super(accessCredential);
    }

    public ShipmentWrapper getShipmentDetailsByOrderId(HashMap<String, String> params) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION_V3_ENDPOINT + SHIPMENT_ENDPOINT);
        uri = addParameters(uri, params);

        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShipmentWrapper.class);
    }

    public GenerateLabelResponseWrapper generateLabel(GenerateLabelRequestWrapper generateLabelRequestWrapper) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION_V3_ENDPOINT + SHIPMENT_ENDPOINT + LABELS_ENDPOINT);

        HttpRequest request = postWithObject(uri, generateLabelRequestWrapper);
        return getRequestWrapped(request, GenerateLabelResponseWrapper.class);
    }
}