package io.github.dft.flipkart;

import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.model.v3.generatelabel.GenerateLabelRequestWrapper;
import io.github.dft.flipkart.model.v3.common.ShipmentResponseWrapper;
import io.github.dft.flipkart.model.v3.readytodispatch.ReadyToDispatchRequest;
import io.github.dft.flipkart.model.v3.shipment.ShipmentWrapper;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static io.github.dft.flipkart.constantcodes.ConstantCodes.API_BASE_END_POINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.DISPATCH_ENDPOINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.LABELS_ENDPOINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.SHIPMENT_ENDPOINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.SLASH_CHARACTER;
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

    public ShipmentResponseWrapper generateLabel(GenerateLabelRequestWrapper generateLabelRequestWrapper) {
        URI uri = URI.create(API_BASE_END_POINT + VERSION_V3_ENDPOINT + SHIPMENT_ENDPOINT + LABELS_ENDPOINT);

        HttpRequest request = postWithObject(uri, generateLabelRequestWrapper);
        return getRequestWrapped(request, ShipmentResponseWrapper.class);
    }

    public HttpResponse<InputStream> downloadLabel(String shipmentId) {
        String path = API_BASE_END_POINT + VERSION_V3_ENDPOINT + SHIPMENT_ENDPOINT + SLASH_CHARACTER + shipmentId + "/labelOnly/pdf";
        URI uri = URI.create(path);

        HttpRequest request = postWithEmptyBody(uri);
        return getRequestWrappedToDownloadPdf(request);
    }

    public ShipmentResponseWrapper markShipmentsReadyForDispatch(ReadyToDispatchRequest readyToDispatchRequest) {
        String path = API_BASE_END_POINT + VERSION_V3_ENDPOINT + SHIPMENT_ENDPOINT + DISPATCH_ENDPOINT;
        URI uri = URI.create(path);
        HttpRequest request = postWithObject(uri, readyToDispatchRequest);
        return getRequestWrapped(request, ShipmentResponseWrapper.class);
    }
}