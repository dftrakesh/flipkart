package io.github.dft.flipkart;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.flipkart.authenticatonapi.AccessCredential;
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

public class UpdateInventoryApi extends FlipkartSdk {

    String UPDATE_INVENTORY = "/inventory";

    private ObjectMapper objectMapper = new ObjectMapper();
    AccessCredentialApi accessCredentialApi = new AccessCredentialApi(accessCredential);

    public UpdateInventoryApi(AccessCredential accessCredential) {

        super(accessCredential);
    }

    @SneakyThrows
    public HashMap<String, Sku> updateInventory(HashMap<String, Sku> skuHashMap) {

        URI uri = new URI(API_BASE_END_POINT
                .concat(INVENTORY_ENDPOINT)
                .concat(VERSION_V3_ENDPOINT)
                .concat(UPDATE_PRODUCT)
                .concat(UPDATE_INVENTORY)
                .concat(SLASH_CHARACTER));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(skuHashMap)))
                .header(CONTENT_TYPE, CONTENT_TYPE_APPLICATION_JSON)
                .headers(AUTHORIZATION_HEADER, accessCredentialApi.getAuthorizationHeader())
                .build();

        return getRequestWrapped(request, HashMap.class);
    }
}