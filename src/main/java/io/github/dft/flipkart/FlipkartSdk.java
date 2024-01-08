package io.github.dft.flipkart;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.authenticatonapi.AccessTokenResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static io.github.dft.flipkart.constantcodes.ConstantCodes.ACCEPT;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.APPLICATION_PDF;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.AUTHORIZATION_HEADER;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.CONTENT_TYPE;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.CONTENT_TYPE_APPLICATION_JSON;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.TOKEN_NAME;

@AllArgsConstructor
@Builder(builderMethodName = "newBuilder", toBuilder = true)
public class FlipkartSdk {

    int TOO_MANY_REQUEST_EXCEPTION_CODE = 429;
    int MAX_ATTEMPTS = 50;
    int TIME_OUT_DURATION = 3000;
    String GRANT_TYPE = "authorization_code";
    String REFRESH_TOKEN = "refresh_token";
    String CLIENT_SECRET = "client_secret";
    String CLIENT_ID = "client_id";
    String OAUTH_BASE_END_POINT = "https://api.flipkart.net/oauth-service/oauth/token?";

    protected HttpClient client;
    protected AccessCredential accessCredential;
    private ObjectMapper objectMapper;

    @SneakyThrows
    public FlipkartSdk(AccessCredential accessCredential) {

        client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.accessCredential = accessCredential;
    }

    @SneakyThrows
    protected HttpRequest postWithObject(URI uri, Object object) {
        refreshAccessToken();
        return HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(object)))
                .header(CONTENT_TYPE, CONTENT_TYPE_APPLICATION_JSON)
                .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
                .build();
    }

    public HttpRequest postWithEmptyBody(URI uri) {
        refreshAccessToken();
        return HttpRequest.newBuilder(uri)
            .POST(HttpRequest.BodyPublishers.ofString(""))
            .header(ACCEPT, APPLICATION_PDF)
            .header(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
            .build();
    }

    @SneakyThrows
    protected HttpRequest get(URI uri) {
        refreshAccessToken();
        return HttpRequest.newBuilder(uri)
                .GET()
                .header(CONTENT_TYPE, CONTENT_TYPE_APPLICATION_JSON)
                .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
                .build();
    }

    @SneakyThrows
    protected <T> T getRequestWrapped(HttpRequest request, Class<T> tClass) {

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenComposeAsync(response -> tryResend(client, request, HttpResponse.BodyHandlers.ofString(), response, 1))
                .thenApplyAsync(HttpResponse::body)
                .thenApplyAsync(responseBody -> convertBody(responseBody, tClass))
                .get();
    }

    @SneakyThrows
    protected HttpResponse<InputStream> getRequestWrappedToDownloadPdf(HttpRequest request) {
        return client.send(request, HttpResponse.BodyHandlers.ofInputStream());
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {

        return objectMapper.readValue(body, tClass);
    }

    @SneakyThrows
    protected <T> CompletableFuture<HttpResponse<T>> tryResend(HttpClient client,
                                                               HttpRequest request,
                                                               HttpResponse.BodyHandler<T> handler,
                                                               HttpResponse<T> resp, int count) {

        if (resp.statusCode() == TOO_MANY_REQUEST_EXCEPTION_CODE && count < MAX_ATTEMPTS) {
            Thread.sleep(TIME_OUT_DURATION);
            return client.sendAsync(request, handler)
                    .thenComposeAsync(response -> tryResend(client, request, handler, response, count + 1));
        }
        return CompletableFuture.completedFuture(resp);
    }

    protected void refreshAccessToken() {

        if (accessCredential.getAccessToken() == null || accessCredential.getExpiresIn() == null || LocalDateTime.now().isAfter(accessCredential.getExpiresIn())) {
            HashMap<String, String> params = new HashMap<>();
            params.put("grant_type", "client_credentials");
            params.put("scope", "Seller_Api");

            URI uri = URI.create(OAUTH_BASE_END_POINT);
            uri = addParameters(uri, params);

            String auth = accessCredential.getClientId() + ":" + accessCredential.getClientSecret();
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            String authHeader = "Basic " + encodedAuth;

            HttpRequest request = HttpRequest.newBuilder(uri)
                .header(AUTHORIZATION_HEADER, authHeader)
                .GET()
                .build();

            AccessTokenResponse accessTokenResponse = getRequestWrapped(request, AccessTokenResponse.class);
            accessCredential.setAccessToken(accessTokenResponse.getAccessToken());
            accessCredential.setExpiresIn(LocalDateTime.now().plusSeconds(accessTokenResponse.getExpiresIn()));
        }
    }

    @SneakyThrows
    protected URI addParameters(URI uri, HashMap<String, String> params) {

        String query = uri.getQuery();
        StringBuilder builder = new StringBuilder();
        if (query != null)
            builder.append(query);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String keyValueParam = entry.getKey() + "=" + entry.getValue();
            if (!builder.toString().isEmpty())
                builder.append("&");
            builder.append(keyValueParam);
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), builder.toString(), uri.getFragment());
    }

    public ProductApi getProductApi() {

        return new ProductApi(accessCredential);
    }

    public OrderApi getOrderApi(){
        return  new OrderApi(accessCredential);
    }

    public UpdateInventoryApi getUpdateInventoryApi() {

        return new UpdateInventoryApi(accessCredential);
    }
}
