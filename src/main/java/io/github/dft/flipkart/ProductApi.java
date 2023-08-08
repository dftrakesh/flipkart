package io.github.dft.flipkart;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.model.productapi.Available;
import io.github.dft.flipkart.model.productapi.Sku;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

public class ProductApi extends FlipkartSdk {

    String API_BASE_END_POINT = "https://api.flipkart.net/sellers";
    String INVENTORY_ENDPOINT = "/listings";
    String VERSION_ENDPOINT = "/v3";
    String UPDATE_PRODUCT = "/update";
    String SLASH_CHARACTER = "/";
    String CONTENT_TYPE = "Content-Type";
    String AUTHORIZATION_HEADER = "Authorization";
    String CONTENT_TYPE_APPLICATION_JSON = "application/json; charset=utf-8";

    private ObjectMapper objectMapper = new ObjectMapper();

    public ProductApi(AccessCredential accessCredential) {

        super(accessCredential);
    }

    AccessCredentialApi accessCredentialApi = new AccessCredentialApi(accessCredential);

    @SneakyThrows
    public HashMap<String, Sku> updateProduct(HashMap<String, Sku> skuHashMap) {
        URI uri = new URI(API_BASE_END_POINT.
                concat(INVENTORY_ENDPOINT).
                concat(VERSION_ENDPOINT).
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
                .concat(VERSION_ENDPOINT).concat(SLASH_CHARACTER + skuId));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .headers(AUTHORIZATION_HEADER, accessCredentialApi.getAuthorizationHeader())
                .build();

        return getRequestWrapped(request, Available.class);
    }
}
