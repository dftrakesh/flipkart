package io.github.dft.flipkart;

import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.model.productapi.Available;
import io.github.dft.flipkart.model.productapi.Sku;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.flipkart.constantcodes.ConstantCodes.API_BASE_END_POINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.LISTING_ENDPOINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.SLASH_CHARACTER;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.UPDATE_ENDPOINT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.VERSION_V3_ENDPOINT;

public class ProductApi extends FlipkartSdk {

    public ProductApi(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public HashMap<String, Sku> updateProduct(HashMap<String, Sku> skuHashMap) {
        String path = API_BASE_END_POINT + LISTING_ENDPOINT + VERSION_V3_ENDPOINT + UPDATE_ENDPOINT;
        URI uri = URI.create(path);
        HttpRequest request = postWithObject(uri, skuHashMap);
        return getRequestWrapped(request, HashMap.class);
    }

    @SneakyThrows
    public Available getProductById(String skuId) {
        String path = API_BASE_END_POINT + LISTING_ENDPOINT + VERSION_V3_ENDPOINT + SLASH_CHARACTER + skuId;
        URI uri = URI.create(path);
        HttpRequest request = get(uri);
        return getRequestWrapped(request, Available.class);
    }
}
