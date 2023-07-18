package gor_api;

import dto.authorization_api.response.AuthResponse;
import model.entity.ReqHeaders;
import model.entity.ReqParams;
import service.authorization.AuthApiService;
import service.passport.RandomStringUtils;

/**
 * Базовый тестовый класс
 */
public class BaseClass {
    public static final String KEY_FOR_HEADERS = "Fingerprint";
    protected ReqHeaders<?, ?> headers;
    public AuthApiService authApiService;
    public String accessToken;
    protected AuthResponse response;
    protected ReqParams<?, ?> params;

    public BaseClass() {
        headers = new ReqHeaders<>();
        params = new ReqParams<>();
        headers.add(KEY_FOR_HEADERS, RandomStringUtils.randomLatin(5));
        authApiService = new AuthApiService();
    }

    public void addParams(String key, String value) {
        params.add(key, value);
    }
}