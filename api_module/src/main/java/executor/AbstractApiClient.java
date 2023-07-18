package executor;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.config.HttpClientConfig.httpClientConfig;
import static property.BaseProperties.SOCKET_TIMEOUT_CONNECTION;

/**
 * Клиент, содержащий методы для выполнения запросов различных HTTP-методов
 *
 * @see RestAssured
 */
public abstract class AbstractApiClient {

    protected abstract String getBaseURL();

    protected abstract ContentType getContentType();

    protected Response performGetCall(String endpointPart) {
        return request().get(endpointPart);
    }

    protected Response performGetCallPathParams(String endpointPart, Map<String, ?> pathParams) {
        return request().get(endpointPart, pathParams);
    }

    protected Response performGetCallParams(String endpointPart, Map<String, ?> params) {
        return requestParams(params).get(endpointPart);
    }

    protected Response performGetCallHeaders(String endpointPart, Map<String, ?> headers) {
        return request(headers).get(endpointPart);
    }

    protected Response performGetCallPathParamsAndParams(String endpointPart, Map<String, ?> pathParams,
                                                         Map<String, ?> params) {
        return requestParams(params).get(endpointPart, pathParams);
    }

    protected Response performGetCallPathParamsAndHeaders(String endpointPart, Map<String, ?> pathParams,
                                                          Map<String, ?> headers) {
        return request(headers).get(endpointPart, pathParams);
    }

    protected Response performGetCallParamsAndHeaders(String endpointPart, Map<String, ?> params,
                                                      Map<String, ?> headers) {
        return request(params, headers).get(endpointPart);
    }

    protected Response performGetCall(String endpointPart, Map<String, ?> pathParams, Map<String, ?> params,
                                      Map<String, ?> headers) {
        return request(params, headers).get(endpointPart, pathParams);
    }

    protected Response performGetCallHeaders(String endpointPart, Map<String, ?> headers, Object body) {
        return request(headers, body).get(endpointPart);
    }

    protected Response performPostCall(String endpointPart) {
        return request().post(endpointPart);
    }

    protected Response performPostCall(String endpointPart, Object body) {
        return request(body).post(endpointPart);
    }

    protected Response performPostCallPathParams(String endpointPart, Map<String, ?> pathParams) {
        return request().post(endpointPart, pathParams);
    }

    protected Response performPostCallParams(String endpointPart, Map<String, ?> params) {
        return requestParams(params).post(endpointPart);
    }

    protected Response performPostCallHeaders(String endpointPart, Map<String, ?> headers) {
        return request(headers).post(endpointPart);
    }

    protected Response performPostCallPathParamsAndParams(String endpointPart, Map<String, ?> pathParams,
                                                          Map<String, ?> params) {
        return requestParams(params).post(endpointPart, pathParams);
    }

    protected Response performPostCallPathParamsAndHeaders(String endpointPart, Map<String, ?> pathParams,
                                                           Map<String, ?> headers) {
        return request(headers).post(endpointPart, pathParams);
    }

    protected Response performPostCallParamsAndHeaders(String endpointPart, Map<String, ?> params,
                                                       Map<String, ?> headers) {
        return request(params, headers).post(endpointPart);
    }

    protected Response performPostCallPathParams(String endpointPart, Map<String, ?> pathParams, Object body) {
        return request(body).post(endpointPart, pathParams);
    }

    protected Response performPostCallParams(String endpointPart, Map<String, ?> params, Object body) {
        return request(params, body).post(endpointPart);
    }

    protected Response performPostCallHeaders(String endpointPart, Map<String, ?> headers, Object body) {
        return request(headers, body).post(endpointPart);
    }

    protected Response performPostCallPathParamsAndParams(String endpointPart, Map<String, ?> pathParams,
                                                          Map<String, ?> params, Object body) {
        return requestParams(params, body).post(endpointPart, pathParams);
    }

    protected Response performPostCallPathParamsAndHeaders(String endpointPart, Map<String, ?> pathParams,
                                                           Map<String, ?> headers, Object body) {
        return request(headers, body).post(endpointPart, pathParams);
    }

    protected Response performPostCallParamsAndHeaders(String endpointPart, Map<String, ?> params,
                                                       Map<String, ?> headers, Object body) {
        return request(params, headers, body).post(endpointPart);
    }

    protected Response performPostCall(String endpointPart, Map<String, ?> pathParams, Map<String, ?> params,
                                       Map<String, ?> headers, Object body) {
        return request(params, headers, body).post(endpointPart, pathParams);
    }

    protected Response performPutCall(String endpointPart) {
        return request().put(endpointPart);
    }

    protected Response performPutCall(String endpointPart, Object body) {
        return request(body).put(endpointPart);
    }

    protected Response performGetCall(String endpointPart, Object body) {
        return request(body).get(endpointPart);
    }

    protected Response performPutCallPathParams(String endpointPart, Map<String, ?> pathParams) {
        return request().put(endpointPart, pathParams);
    }

    protected Response performPutCallParams(String endpointPart, Map<String, ?> params) {
        return requestParams(params).put(endpointPart);
    }

    protected Response performPutCallHeaders(String endpointPart, Map<String, ?> headers) {
        return request(headers).put(endpointPart);
    }

    protected Response performPutCallPathParamsAndParams(String endpointPart, Map<String, ?> pathParams, Map<String,
            ?> params) {
        return request(params).put(endpointPart, pathParams);
    }

    protected Response performPutCallPathParamsAndHeaders(String endpointPart, Map<String, ?> pathParams, Map<String,
            ?> headers) {
        return request(headers).put(endpointPart, pathParams);
    }

    protected Response performPutCallParamsAndHeaders(String endpointPart, Map<String, ?> params,
                                                      Map<String, ?> headers) {
        return request(params, headers).put(endpointPart);
    }

    protected Response performPutCallPathParams(String endpointPart, Map<String, ?> pathParams, Object body) {
        return request(body).put(endpointPart, pathParams);
    }

    protected Response performPutCallParams(String endpointPart, Map<String, ?> params, Object body) {
        return requestParams(params, body).put(endpointPart);
    }

    protected Response performPutCallHeaders(String endpointPart, Map<String, ?> headers, Object body) {
        return request(headers, body).put(endpointPart);
    }

    protected Response performPutCallPathParamsAndParams(String endpointPart, Map<String, ?> pathParams,
                                                         Map<String, ?> params, Object body) {
        return request(params, body).put(endpointPart, pathParams);
    }

    protected Response performPutCallPathParamsAndHeaders(String endpointPart, Map<String, ?> pathParams,
                                                          Map<String, ?> headers, Object body) {
        return request(headers, body).put(endpointPart, pathParams);
    }

    protected Response performPutCallParamsAndHeaders(String endpointPart, Map<String, ?> params,
                                                      Map<String, ?> headers, Object body) {
        return request(params, headers, body).put(endpointPart);
    }

    protected Response performPutCall(String endpointPart, Map<String, ?> pathParams, Map<String, ?> params,
                                      Map<String, ?> headers, Object body) {
        return request(params, headers, body).put(endpointPart, pathParams);
    }

    protected Response performPutCall(String endpointPart, Map<String, ?> headers, Object body) {
        return request(headers, body).patch(endpointPart);
    }

    protected Response performPatchCall(String endpointPart, Object body) {
        return request(body).patch(endpointPart);
    }

    protected Response performPatchCall(String endpointPart, Map<String, ?> pathParams, Object body) {
        return request(body).patch(endpointPart, pathParams);
    }

    protected Response performDeleteCall(String endpointPart) {
        return request().delete(endpointPart);
    }

    protected Response performDeleteCallPathParams(String endpointPart, Map<String, ?> pathParams) {
        return request().delete(endpointPart, pathParams);
    }

    protected Response performDeleteCallParams(String endpointPart, Map<String, ?> params) {
        return requestParams(params).delete(endpointPart);
    }

    protected Response performDeleteCallHeaders(String endpointPart, Map<String, ?> headers) {
        return request(headers).delete(endpointPart);
    }

    protected Response performDeleteCallPathParamsAndParams(String endpointPart, Map<String, ?> pathParams,
                                                            Map<String, ?> params) {
        return request(params).delete(endpointPart, pathParams);
    }

    protected Response performDeleteCallPathParamsAndHeaders(String endpointPart, Map<String, ?> pathParams,
                                                             Map<String, ?> headers) {
        return request(headers).delete(endpointPart, pathParams);
    }

    protected Response performDeleteCallParamsAndHeaders(String endpointPart, Map<String, ?> params,
                                                         Map<String, ?> headers) {
        return request(params, headers).delete(endpointPart);
    }

    protected Response performDeleteCall(String endpointPart, Map<String, ?> pathParams, Map<String, ?> params,
                                         Map<String, ?> headers) {
        return request(params, headers).delete(endpointPart, pathParams);
    }

    private RequestSpecification requestParams(Map<String, ?> params) {
        return request().params(params);
    }

    private RequestSpecification request(Map<String, ?> headers) {
        return request().headers(headers);
    }

    private RequestSpecification request(Map<String, ?> params, Map<String, ?> headers) {
        return requestParams(params).headers(headers);
    }

    private RequestSpecification request(Object body) {
        return request().body(body);
    }

    private RequestSpecification request(Map<String, ?> headers, Object body) {
        return request(headers).body(body);
    }

    private RequestSpecification requestParams(Map<String, ?> params, Object body) {
        return requestParams(params).body(body);
    }

    private RequestSpecification request(Map<String, ?> params, Map<String, ?> headers, Object body) {
        return request(params, headers).body(body);
    }

    private RestAssuredConfig config() {
        return RestAssured.config()
                .httpClient(httpClientConfig().setParam("http.socket.timeout", SOCKET_TIMEOUT_CONNECTION))
                .sslConfig(new SSLConfig().relaxedHTTPSValidation());
    }

    private RequestSpecification request() {
        return RestAssured.given(new RequestSpecBuilder()
                .setContentType(getContentType())
                .setConfig(config())
                .setBaseUri(getBaseURL())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build());
    }
}