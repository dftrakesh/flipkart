package io.github.dft.flipkart;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.model.productapi.Available;
import io.github.dft.flipkart.model.productapi.Sku;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.flipkart.constantcodes.ConstantCodes.API_BASE_END_POINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.AUTHORIZATION_HEADER;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.CONTENT_TYPE;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.CONTENT_TYPE_APPLICATION_JSON;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.INVENTORY_ENDPOINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.SLASH_CHARACTER;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.UPDATE_PRODUCT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.VERSION_V3_ENDPOINT;

public class ProductApi extends FlipkartSdk {

    private ObjectMapper objectMapper = new ObjectMapper();

    public ProductApi(AccessCredential accessCredential) {

        super(accessCredential);
    }

    AccessCredentialApi accessCredentialApi = new AccessCredentialApi(accessCredential);

    @SneakyThrows
    public HashMap<String, Sku> updateProduct(HashMap<String, Sku> skuHashMap) {
        URI uri = new URI(API_BASE_END_POINT.
                concat(INVENTORY_ENDPOINT).
                concat(VERSION_V3_ENDPOINT).
                concat(UPDATE_PRODUCT).concat(SLASH_CHARACTER));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(skuHashMap)))
                .header(CONTENT_TYPE, CONTENT_TYPE_APPLICATION_JSON)
                .headers(AUTHORIZATION_HEADER, accessCredentialApi.getAuthorizationHeader())
                .build();

        return getRequestWrapped(request, HashMap.class);
    }

    @SneakyThrows
    public Available getProductById(String skuId) {
        URI uri = new URI(API_BASE_END_POINT
                .concat(INVENTORY_ENDPOINT)
                .concat(VERSION_V3_ENDPOINT).concat(SLASH_CHARACTER + skuId));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .headers(AUTHORIZATION_HEADER, accessCredentialApi.getAuthorizationHeader())
                .build();

        return getRequestWrapped(request, Available.class);
    }
}
