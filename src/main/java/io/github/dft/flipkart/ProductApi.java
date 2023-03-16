package io.github.dft.flipkart;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.model.productapi.Sku;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.flipkart.constantCodes.ConstantCodes.AUTHORIZATION_HEADER;


public class ProductApi extends FlipkartSdk {
    String API_BASE_END_POINT = "https://api.flipkart.net/sellers";
    String INVENTORY_ENDPOINT = "/listings";
    String PRODUCT_ENDPOINT = "/v3";
    String UPDATE_PRODUCT = "/update";
    String SLASH_CHARACTER = "/";
    String TOKEN_NAME = "Bearer ";
    String CONTENT_TYPE = "Content-Type";
    String AUTHORIZATION_HEADER = "Authorization";
    String CONTENT_TYPE_APPLICATION_JSON = "application/json; charset=utf-8";

    private ObjectMapper objectMapper = new ObjectMapper();

    public ProductApi(AccessCredential accessCredential) {
        super(accessCredential);
    }
    @SneakyThrows
    public HashMap<String, Sku> updateProduct(HashMap<String, Sku> skuHashMap) {
        URI uri = new URI(API_BASE_END_POINT.
                concat(INVENTORY_ENDPOINT).
                concat(PRODUCT_ENDPOINT).
                concat(UPDATE_PRODUCT).concat(SLASH_CHARACTER));
        HttpRequest request = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(skuHashMap)))
                .header(CONTENT_TYPE, CONTENT_TYPE_APPLICATION_JSON)
                .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
                .build();

        return getRequestWrapped(request, HashMap.class);
    }
    @SneakyThrows
    public HashMap<String, Object> getProductById(String skuId) {
        URI uri = new URI(API_BASE_END_POINT
                .concat(INVENTORY_ENDPOINT)
                .concat(PRODUCT_ENDPOINT).concat(SLASH_CHARACTER + skuId));
        System.out.println(uri);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header(CONTENT_TYPE, CONTENT_TYPE_APPLICATION_JSON)
                .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
                .build();

        return getRequestWrapped(request, HashMap.class);
    }

}
