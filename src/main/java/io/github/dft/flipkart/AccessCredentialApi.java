package io.github.dft.flipkart;

import io.github.dft.flipkart.authenticatonapi.AccessCredential;
import io.github.dft.flipkart.authenticatonapi.AccessTokenResponse;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.HashMap;

import static io.github.dft.flipkart.constantcodes.ConstantCodes.AUTHORIZATION_HEADER;
import static io.github.dft.flipkart.constantcodes.ConstantCodes.TOKEN_NAME;

public class AccessCredentialApi extends FlipkartSdk {

    String API_BASE_OAUTH_END_POINT = "https://api.flipkart.net/oauth-service/oauth";
    String TOKEN_ENDPOINT = "/token";

    public AccessCredentialApi(AccessCredential accessCredential) {

        super(accessCredential);
    }

    @SneakyThrows
    public AccessTokenResponse getAccessToken(HashMap<String, String> params) {

        URI uri = new URI(API_BASE_OAUTH_END_POINT
                .concat(TOKEN_ENDPOINT));
        uri = addParameters(uri, params);
        String auth = accessCredential.getClientId() + ":" + accessCredential.getClientSecret();
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
        String authHeader = "Basic " + new String(encodedAuth);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .header(AUTHORIZATION_HEADER, authHeader)
                .GET()
                .build();

        return getRequestWrapped(request, AccessTokenResponse.class);
    }

    protected String getAuthorizationHeader() {

        HashMap<String, String> params = new HashMap<>();
        params.put("grant_type", "client_credentials");
        params.put("scope", "Seller_Api");
        AccessTokenResponse accessTokenResponse = getAccessToken(params);
        accessCredential.setAccessToken(accessTokenResponse.getAccessToken());
        return  TOKEN_NAME + accessTokenResponse.getAccessToken();
    }
}
