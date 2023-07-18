package executor;

import exception.DeserializationException;
import exception.RequestException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import model.entity.ReqHeaders;
import model.entity.ReqParams;
import model.entity.ReqPathParams;
import model.entity.Request;
import model.response.ClassResponse;
import model.response.JsonResponse;
import org.json.JSONObject;

import static property.BaseProperties.BASE_URL;

/**
 * Клиент, содержащий методы для выполнения запросов различных HTTP-методов, возвращающих 3 типа значений:
 *
 * @see JsonResponse
 * @see Response
 * @see ClassResponse
 */
@Slf4j
public class BaseApiClient extends AbstractApiClient {

    private static final String ERROR_MESSAGE = "This HTTP method is not supported";
    private String baseUri;
    private ContentType type;

    public BaseApiClient() {
        if (getBaseURL() == null)
            setBaseUrl();

        if (getContentType() == null)
            setContentType(ContentType.JSON);
    }

    /**
     * @param baseUri это первая часть URL, домен
     */
    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    /**
     * @param type это заголовок для указания исходного типа ресурса
     */
    public void setContentType(ContentType type) {
        this.type = type;
    }

    @Override
    protected String getBaseURL() {
        return baseUri;
    }

    @Override
    protected ContentType getContentType() {
        return type;
    }

    public JsonResponse get(String endpoint) {
        return getResponseAnswer(performGetCall(endpoint));
    }

    public String getResponseAsString(String endpoint) {
        return getResponse(performGetCall(endpoint));
    }

    public Response getResponse(String endpoint) {
        return performGetCall(endpoint);
    }

    public <T> ClassResponse<T> get(String endpoint, Class<T> clazz) {
        return getResponseAnswer(performGetCall(endpoint), clazz);
    }

    public JsonResponse get(String endpoint, ReqHeaders<?, ?> reqHeaders, Object body) {
        return getResponseAnswer(performGetCallHeaders(endpoint, reqHeaders.getHeaders(), body));
    }

    public JsonResponse get(String endpoint, Object body) {
        return getResponseAnswer(performGetCall(endpoint, body));
    }

    public JsonResponse get(String endpoint, ReqPathParams<?, ?> reqPathParams) {
        return getResponseAnswer(performGetCallPathParams(endpoint, reqPathParams.getParams()));
    }

    public Response getResponse(String endpoint, ReqPathParams<?, ?> reqPathParams) {
        return performGetCallPathParams(endpoint, reqPathParams.getParams());
    }

    public <T> ClassResponse<T> get(String endpoint, ReqPathParams<?, ?> reqPathParams, Class<T> clazz) {
        return getResponseAnswer(performGetCallPathParams(endpoint, reqPathParams.getParams()), clazz);
    }

    public JsonResponse get(String endpoint, ReqParams<?, ?> reqParams) {
        return getResponseAnswer(performGetCallParams(endpoint, reqParams.getParams()));
    }

    public Response getResponse(String endpoint, ReqParams<?, ?> reqParams) {
        return performGetCallParams(endpoint, reqParams.getParams());
    }

    public <T> ClassResponse<T> get(String endpoint, ReqParams<?, ?> reqParams, Class<T> clazz) {
        return getResponseAnswer(performGetCallParams(endpoint, reqParams.getParams()), clazz);
    }

    public JsonResponse get(String endpoint, ReqHeaders<?, ?> reqHeaders) {
        Response response = performGetCallHeaders(endpoint, reqHeaders.getHeaders());
        return getResponseAnswer(response);
    }

    public Response getResponse(String endpoint, ReqHeaders<?, ?> reqHeaders) {
        return performGetCallHeaders(endpoint, reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> get(String endpoint, ReqHeaders<?, ?> reqHeaders, Class<T> clazz) {
        Response response = performGetCallHeaders(endpoint, reqHeaders.getHeaders());
        return getResponseAnswer(response, clazz);
    }

    public JsonResponse get(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams) {
        return getResponseAnswer(performGetCallPathParamsAndParams(endpoint, reqPathParams.getParams(),
                reqParams.getParams()));
    }

    public Response getResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams) {
        return performGetCallPathParamsAndParams(endpoint, reqPathParams.getParams(), reqParams.getParams());
    }

    public <T> ClassResponse<T> get(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                    Class<T> clazz) {
        return getResponseAnswer(performGetCallPathParamsAndParams(endpoint, reqPathParams.getParams(),
                reqParams.getParams()), clazz);
    }

    public JsonResponse get(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performGetCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders()));
    }

    public Response getResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders) {
        return performGetCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(), reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> get(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders,
                                    Class<T> clazz) {
        return getResponseAnswer(performGetCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse get(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performGetCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders()));
    }

    public Response getResponse(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders) {
        return performGetCallParamsAndHeaders(endpoint, reqParams.getParams(), reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> get(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders,
                                    Class<T> clazz) {
        return getResponseAnswer(performGetCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse get(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                            ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performGetCall(endpoint, reqPathParams.getParams(), reqParams.getParams(),
                reqHeaders.getHeaders()));
    }

    public Response getResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                ReqHeaders<?, ?> reqHeaders) {
        return performGetCall(endpoint, reqPathParams.getParams(), reqParams.getParams(), reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> get(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                    ReqHeaders<?, ?> reqHeaders, Class<T> clazz) {
        return getResponseAnswer(performGetCall(endpoint, reqPathParams.getParams(), reqParams.getParams(),
                reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse post(String endpoint) {
        return getResponseAnswer(performPostCall(endpoint));
    }

    public Response postResponse(String endpoint) {
        return performPostCall(endpoint);
    }

    public <T> ClassResponse<T> post(String endpoint, Class<T> clazz) {
        return getResponseAnswer(performPostCall(endpoint), clazz);
    }

    public JsonResponse post(String endpoint, ReqPathParams<?, ?> reqPathParams) {
        return getResponseAnswer(performPostCallPathParams(endpoint, reqPathParams.getParams()));
    }

    public Response postResponse(String endpoint, ReqPathParams<?, ?> reqPathParams) {
        return performPostCallPathParams(endpoint, reqPathParams.getParams());
    }

    public <T> ClassResponse<T> post(String endpoint, ReqPathParams<?, ?> reqPathParams, Class<T> clazz) {
        return getResponseAnswer(performPostCallPathParams(endpoint, reqPathParams.getParams()), clazz);
    }

    public JsonResponse post(String endpoint, ReqParams<?, ?> reqParams) {
        return getResponseAnswer(performPostCallParams(endpoint, reqParams.getParams()));
    }

    public Response postResponse(String endpoint, ReqParams<?, ?> reqParams) {
        return performPostCallParams(endpoint, reqParams.getParams());
    }

    public <T> ClassResponse<T> post(String endpoint, ReqParams<?, ?> reqParams, Class<T> clazz) {
        return getResponseAnswer(performPostCallParams(endpoint, reqParams.getParams()), clazz);
    }

    public JsonResponse post(String endpoint, ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performPostCallHeaders(endpoint, reqHeaders.getHeaders()));
    }

    public Response postResponse(String endpoint, ReqHeaders<?, ?> reqHeaders) {
        return performPostCallHeaders(endpoint, reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> post(String endpoint, ReqHeaders<?, ?> reqHeaders, Class<T> clazz) {
        return getResponseAnswer(performPostCallHeaders(endpoint, reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse post(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams) {
        return getResponseAnswer(performPostCallPathParamsAndParams(endpoint, reqPathParams.getParams(),
                reqParams.getParams()));
    }

    public Response postResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams) {
        return performPostCallPathParamsAndParams(endpoint, reqPathParams.getParams(), reqParams.getParams());
    }

    public <T> ClassResponse<T> post(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                     Class<T> clazz) {
        return getResponseAnswer(performPostCallPathParamsAndParams(endpoint, reqPathParams.getParams(),
                reqParams.getParams()), clazz);
    }

    public JsonResponse post(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performPostCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders()));
    }

    public Response postResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders) {
        return performPostCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(), reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> post(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders,
                                     Class<T> clazz) {
        return getResponseAnswer(performPostCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse post(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performPostCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders()));
    }

    public Response postResponse(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders) {
        return performPostCallParamsAndHeaders(endpoint, reqParams.getParams(), reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> post(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders,
                                     Class<T> clazz) {
        return getResponseAnswer(performPostCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse post(String endpoint, Object body) {
        return getResponseAnswer(performPostCall(endpoint, body));
    }

    public Response postResponse(String endpoint, Object body) {
        return performPostCall(endpoint, body);
    }

    public <T> ClassResponse<T> post(String endpoint, Object body, Class<T> clazz) {
        return getResponseAnswer(performPostCall(endpoint, body), clazz);
    }

    public JsonResponse post(String endpoint, ReqPathParams<?, ?> reqPathParams, Object body) {
        return getResponseAnswer(performPostCallPathParams(endpoint, reqPathParams.getParams(), body));
    }

    public Response postResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, Object body) {
        return performPostCallPathParams(endpoint, reqPathParams.getParams(), body);
    }

    public <T> ClassResponse<T> post(String endpoint, ReqPathParams<?, ?> reqPathParams, Object body, Class<T> clazz) {
        return getResponseAnswer(performPostCallPathParams(endpoint, reqPathParams.getParams(), body), clazz);
    }

    public JsonResponse post(String endpoint, ReqParams<?, ?> reqParams, Object body) {
        return getResponseAnswer(performPostCallParams(endpoint, reqParams.getParams(), body));
    }

    public Response postResponse(String endpoint, ReqParams<?, ?> reqParams, Object body) {
        return performPostCallParams(endpoint, reqParams.getParams(), body);
    }

    public <T> ClassResponse<T> post(String endpoint, ReqParams<?, ?> reqParams, Object body, Class<T> clazz) {
        return getResponseAnswer(performPostCallParams(endpoint, reqParams.getParams(), body), clazz);
    }

    public JsonResponse post(String endpoint, ReqHeaders<?, ?> reqHeaders, Object body) {
        return getResponseAnswer(performPostCallHeaders(endpoint, reqHeaders.getHeaders(), body));
    }

    public Response postResponse(String endpoint, ReqHeaders<?, ?> reqHeaders, Object body) {
        return performPostCallHeaders(endpoint, reqHeaders.getHeaders(), body);
    }

    public <T> ClassResponse<T> post(String endpoint, ReqHeaders<?, ?> reqHeaders, Object body, Class<T> clazz) {
        return getResponseAnswer(performPostCallHeaders(endpoint, reqHeaders.getHeaders(), body), clazz);
    }

    public JsonResponse post(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                             Object body) {
        return getResponseAnswer(performPostCallPathParamsAndParams(endpoint, reqPathParams.getParams(),
                reqParams.getParams(), body));
    }

    public Response postResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                 Object body) {
        return performPostCallPathParamsAndParams(endpoint, reqPathParams.getParams(), reqParams.getParams(), body);
    }

    public <T> ClassResponse<T> post(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                     Object body, Class<T> clazz) {
        return getResponseAnswer(performPostCallPathParamsAndParams(endpoint, reqPathParams.getParams(),
                reqParams.getParams(), body), clazz);
    }

    public JsonResponse post(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders,
                             Object body) {
        return getResponseAnswer(performPostCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders(), body));
    }

    public Response postResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders,
                                 Object body) {
        return performPostCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(), reqHeaders.getHeaders(), body);
    }


    public <T> ClassResponse<T> post(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders,
                                     Object body, Class<T> clazz) {
        return getResponseAnswer(performPostCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders(), body), clazz);
    }

    public JsonResponse post(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders, Object body) {
        return getResponseAnswer(performPostCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders(), body));
    }

    public Response postResponse(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders, Object body) {
        return performPostCallParamsAndHeaders(endpoint, reqParams.getParams(), reqHeaders.getHeaders(), body);
    }

    public <T> ClassResponse<T> post(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders,
                                     Object body, Class<T> clazz) {
        return getResponseAnswer(performPostCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders(), body), clazz);
    }

    public JsonResponse post(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                             ReqHeaders<?, ?> reqHeaders, Object body) {
        return getResponseAnswer(performPostCall(endpoint, reqPathParams.getParams(), reqParams.getParams(),
                reqHeaders.getHeaders(), body));
    }

    public Response postResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                 ReqHeaders<?, ?> reqHeaders, Object body) {
        return performPostCall(endpoint, reqPathParams.getParams(), reqParams.getParams(), reqHeaders.getHeaders(),
                body);
    }

    public <T> ClassResponse<T> post(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                     ReqHeaders<?, ?> reqHeaders, Object body, Class<T> clazz) {
        return getResponseAnswer(performPostCall(endpoint, reqPathParams.getParams(), reqParams.getParams(),
                reqHeaders.getHeaders(), body), clazz);
    }

    public JsonResponse put(String endpoint) {
        return getResponseAnswer(performPutCall(endpoint));
    }

    public Response putResponse(String endpoint) {
        return performPutCall(endpoint);
    }

    public <T> ClassResponse<T> put(String endpoint, Class<T> clazz) {
        return getResponseAnswer(performPutCall(endpoint), clazz);
    }

    public JsonResponse put(String endpoint, Object body) {
        return getResponseAnswer(performPutCall(endpoint, body));
    }

    public Response putResponse(String endpoint, Object body) {
        return performPutCall(endpoint, body);
    }

    public <T> ClassResponse<T> put(String endpoint, Object body, Class<T> clazz) {
        return getResponseAnswer(performPutCall(endpoint, body), clazz);
    }

    public JsonResponse put(String endpoint, ReqPathParams<?, ?> reqPathParams) {
        return getResponseAnswer(performPutCallPathParams(endpoint, reqPathParams.getParams()));
    }

    public Response putResponse(String endpoint, ReqPathParams<?, ?> reqPathParams) {
        return performPutCallPathParams(endpoint, reqPathParams.getParams());
    }

    public <T> ClassResponse<T> put(String endpoint, ReqPathParams<?, ?> reqPathParams, Class<T> clazz) {
        return getResponseAnswer(performPutCallPathParams(endpoint, reqPathParams.getParams()), clazz);
    }

    public JsonResponse put(String endpoint, ReqParams<?, ?> reqParams) {
        return getResponseAnswer(performPutCallParams(endpoint, reqParams.getParams()));
    }

    public Response putResponse(String endpoint, ReqParams<?, ?> reqParams) {
        return performPutCallParams(endpoint, reqParams.getParams());
    }

    public <T> ClassResponse<T> put(String endpoint, ReqParams<?, ?> reqParams, Class<T> clazz) {
        return getResponseAnswer(performPutCallParams(endpoint, reqParams.getParams()), clazz);
    }

    public JsonResponse put(String endpoint, ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performPutCallHeaders(endpoint, reqHeaders.getHeaders()));
    }

    public Response putResponse(String endpoint, ReqHeaders<?, ?> reqHeaders) {
        return performPutCallHeaders(endpoint, reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> put(String endpoint, ReqHeaders<?, ?> reqHeaders, Class<T> clazz) {
        return getResponseAnswer(performPutCallHeaders(endpoint, reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse put(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams) {
        return getResponseAnswer(performPutCallPathParamsAndParams(endpoint, reqPathParams.getParams(),
                reqParams.getParams()));
    }

    public Response putResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams) {
        return performPutCallPathParamsAndParams(endpoint, reqPathParams.getParams(), reqParams.getParams());
    }

    public <T> ClassResponse<T> put(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                    Class<T> clazz) {
        return getResponseAnswer(performPutCallPathParamsAndParams(endpoint, reqPathParams.getParams(),
                reqParams.getParams()), clazz);
    }

    public JsonResponse put(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performPutCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders()));
    }

    public Response putResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders) {
        return performPutCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(), reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> put(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders,
                                    Class<T> clazz) {
        return getResponseAnswer(performPutCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse put(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performPutCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders()));
    }

    public Response putResponse(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders) {
        return performPutCallParamsAndHeaders(endpoint, reqParams.getParams(), reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> put(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders,
                                    Class<T> clazz) {
        return getResponseAnswer(performPutCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse put(String endpoint, ReqPathParams<?, ?> reqPathParams, Object body) {
        return getResponseAnswer(performPutCallPathParams(endpoint, reqPathParams.getParams(), body));
    }

    public Response putResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, Object body) {
        return performPutCallPathParams(endpoint, reqPathParams.getParams(), body);
    }

    public <T> ClassResponse<T> put(String endpoint, ReqPathParams<?, ?> reqPathParams, Object body, Class<T> clazz) {
        return getResponseAnswer(performPutCallPathParams(endpoint, reqPathParams.getParams(), body), clazz);
    }

    public JsonResponse put(String endpoint, ReqParams<?, ?> reqParams, Object body) {
        return getResponseAnswer(performPutCallParams(endpoint, reqParams.getParams(), body));
    }

    public Response putResponse(String endpoint, ReqParams<?, ?> reqParams, Object body) {
        return performPutCallParams(endpoint, reqParams.getParams(), body);
    }

    public <T> ClassResponse<T> put(String endpoint, ReqParams<?, ?> reqParams, Object body, Class<T> clazz) {
        return getResponseAnswer(performPutCallParams(endpoint, reqParams.getParams(), body), clazz);
    }

    public JsonResponse put(String endpoint, ReqHeaders<?, ?> reqHeaders, Object body) {
        return getResponseAnswer(performPutCallHeaders(endpoint, reqHeaders.getHeaders(), body));
    }

    public Response putResponse(String endpoint, ReqHeaders<?, ?> reqHeaders, Object body) {
        return performPutCallHeaders(endpoint, reqHeaders.getHeaders(), body);
    }

    public <T> ClassResponse<T> put(String endpoint, ReqHeaders<?, ?> reqHeaders, Object body, Class<T> clazz) {
        return getResponseAnswer(performPutCallHeaders(endpoint, reqHeaders.getHeaders(), body), clazz);
    }

    public JsonResponse put(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                            Object body) {
        return getResponseAnswer(performPutCallPathParamsAndParams(endpoint, reqPathParams.getParams(),
                reqParams.getParams(), body));
    }

    public Response putResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                Object body) {
        return performPutCallPathParamsAndParams(endpoint, reqPathParams.getParams(), reqParams.getParams(), body);
    }

    public <T> ClassResponse<T> put(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                    Object body,
                                    Class<T> clazz) {
        return getResponseAnswer(performPutCallPathParamsAndParams(endpoint, reqParams.getParams(),
                reqParams.getParams(), body), clazz);
    }

    public JsonResponse put(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders,
                            Object body) {
        return getResponseAnswer(performPutCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders(), body));
    }

    public Response putResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders,
                                Object body) {
        return performPutCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(), reqHeaders.getHeaders(), body);
    }

    public <T> ClassResponse<T> put(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders,
                                    Object body, Class<T> clazz) {
        return getResponseAnswer(performPutCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders(), body), clazz);
    }

    public JsonResponse put(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders, Object body) {
        return getResponseAnswer(performPutCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders(), body));
    }

    public Response putResponse(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders, Object body) {
        return performPutCallParamsAndHeaders(endpoint, reqParams.getParams(), reqHeaders.getHeaders(), body);
    }

    public <T> ClassResponse<T> put(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders,
                                    Object body,
                                    Class<T> clazz) {
        return getResponseAnswer(performPutCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders(), body), clazz);
    }

    public JsonResponse put(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                            ReqHeaders<?, ?> reqHeaders, Object body) {
        return getResponseAnswer(performPutCall(endpoint, reqPathParams.getParams(), reqParams.getParams(),
                reqHeaders.getHeaders(), body));
    }

    public Response putResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                ReqHeaders<?, ?> reqHeaders, Object body) {
        return performPutCall(endpoint, reqPathParams.getParams(), reqParams.getParams(), reqHeaders.getHeaders(),
                body);
    }

    public <T> ClassResponse<T> put(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                    ReqHeaders<?, ?> reqHeaders, Object body, Class<T> clazz) {
        return getResponseAnswer(performPutCall(endpoint, reqPathParams.getParams(), reqParams.getParams(),
                reqHeaders.getHeaders(), body), clazz);
    }

    public JsonResponse patch(String endpoint, Object body) {
        return getResponseAnswer(performPatchCall(endpoint, body));
    }

    public JsonResponse patch(String endpoint, ReqHeaders<?, ?> reqHeaders, Object body) {
        return getResponseAnswer(performPutCall(endpoint, reqHeaders.getHeaders(), body));
    }

    public Response patchResponse(String endpoint, Object body) {
        return performPatchCall(endpoint, body);
    }

    public <T> ClassResponse<T> patch(String endpoint, Object body, Class<T> clazz) {
        return getResponseAnswer(performPatchCall(endpoint, body), clazz);
    }

    public JsonResponse patch(String endpoint, ReqPathParams<?, ?> reqPathParams, Object body) {
        return getResponseAnswer(performPatchCall(endpoint, reqPathParams.getParams(), body));
    }

    public Response patchResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, Object body) {
        return performPatchCall(endpoint, reqPathParams.getParams(), body);
    }

    public <T> ClassResponse<T> patch(String endpoint, ReqPathParams<?, ?> reqPathParams, Object body, Class<T> clazz) {
        return getResponseAnswer(performPatchCall(endpoint, reqPathParams.getParams(), body), clazz);
    }

    public Response deleteResponse(String endpoint) {
        return performDeleteCall(endpoint);
    }

    public <T> ClassResponse<T> delete(String endpoint, Class<T> clazz) {
        return getResponseAnswer(performDeleteCall(endpoint), clazz);
    }

    public JsonResponse delete(String endpoint, ReqPathParams<?, ?> reqPathParams) {
        return getResponseAnswer(performDeleteCallPathParams(endpoint, reqPathParams.getParams()));
    }

    public JsonResponse delete(String endpoint) {
        return getResponseAnswer(performDeleteCall(endpoint));
    }

    public Response deleteResponse(String endpoint, ReqPathParams<?, ?> reqPathParams) {
        return performDeleteCallPathParams(endpoint, reqPathParams.getParams());
    }

    public <T> ClassResponse<T> delete(String endpoint, ReqPathParams<?, ?> reqPathParams, Class<T> clazz) {
        return getResponseAnswer(performDeleteCallPathParams(endpoint, reqPathParams.getParams()), clazz);
    }

    public JsonResponse delete(String endpoint, ReqParams<?, ?> reqParams) {
        return getResponseAnswer(performDeleteCallParams(endpoint, reqParams.getParams()));
    }

    public Response deleteResponse(String endpoint, ReqParams<?, ?> reqParams) {
        return performDeleteCallParams(endpoint, reqParams.getParams());
    }

    public <T> ClassResponse<T> delete(String endpoint, ReqParams<?, ?> reqParams, Class<T> clazz) {
        return getResponseAnswer(performDeleteCallParams(endpoint, reqParams.getParams()), clazz);
    }

    public JsonResponse delete(String endpoint, ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performDeleteCallHeaders(endpoint, reqHeaders.getHeaders()));
    }

    public Response deleteResponse(String endpoint, ReqHeaders<?, ?> reqHeaders) {
        return performDeleteCallHeaders(endpoint, reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> delete(String endpoint, ReqHeaders<?, ?> reqHeaders, Class<T> clazz) {
        return getResponseAnswer(performDeleteCallHeaders(endpoint, reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse delete(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams) {
        return getResponseAnswer(performDeleteCallPathParamsAndParams(endpoint, reqPathParams.getParams(),
                reqParams.getParams()));
    }

    public Response deleteResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams) {
        return performDeleteCallPathParamsAndParams(endpoint, reqPathParams.getParams(), reqParams.getParams());
    }

    public <T> ClassResponse<T> delete(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                       Class<T> clazz) {
        return getResponseAnswer(performDeleteCallPathParamsAndParams(endpoint, reqPathParams.getParams(),
                reqParams.getParams()), clazz);
    }

    public JsonResponse delete(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performDeleteCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders()));
    }

    public Response deleteResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders) {
        return performDeleteCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(), reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> delete(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqHeaders<?, ?> reqHeaders,
                                       Class<T> clazz) {
        return getResponseAnswer(performDeleteCallPathParamsAndHeaders(endpoint, reqPathParams.getParams(),
                reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse delete(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performDeleteCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders()));
    }

    public Response deleteResponse(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders) {
        return performDeleteCallParamsAndHeaders(endpoint, reqParams.getParams(), reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> delete(String endpoint, ReqParams<?, ?> reqParams, ReqHeaders<?, ?> reqHeaders,
                                       Class<T> clazz) {
        return getResponseAnswer(performDeleteCallParamsAndHeaders(endpoint, reqParams.getParams(),
                reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse delete(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                               ReqHeaders<?, ?> reqHeaders) {
        return getResponseAnswer(performDeleteCall(endpoint, reqPathParams.getParams(), reqParams.getParams(),
                reqHeaders.getHeaders()));
    }

    public Response deleteResponse(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                   ReqHeaders<?, ?> reqHeaders) {
        return performDeleteCall(endpoint, reqPathParams.getParams(), reqParams.getParams(), reqHeaders.getHeaders());
    }

    public <T> ClassResponse<T> delete(String endpoint, ReqPathParams<?, ?> reqPathParams, ReqParams<?, ?> reqParams,
                                       ReqHeaders<?, ?> reqHeaders, Class<T> clazz) {
        return getResponseAnswer(performDeleteCall(endpoint, reqPathParams.getParams(), reqParams.getParams(),
                reqHeaders.getHeaders()), clazz);
    }

    public JsonResponse performCall(Request r) {
        switch (r.getMethod()) {
            case GET:
                return get(r.getEndpoint(), r.getParams(), r.getHeaders());
            case POST:
                return post(r.getEndpoint(), r.getParams(), r.getHeaders(), r.getBody());
            case PUT:
                return put(r.getEndpoint(), r.getParams(), r.getHeaders(), r.getBody());
            case DELETE:
                return delete(r.getEndpoint(), r.getParams(), r.getHeaders());
            case PATCH:
                return patch(r.getEndpoint(), r.getBody());
            default:
                throw new RequestException(ERROR_MESSAGE);
        }
    }

    public <T> ClassResponse<T> performCall(Request r, Class<T> clazz) {
        switch (r.getMethod()) {
            case GET:
                return get(r.getEndpoint(), r.getParams(), r.getHeaders(), clazz);
            case POST:
                return post(r.getEndpoint(), r.getParams(), r.getHeaders(), r.getBody(), clazz);
            case PUT:
                return put(r.getEndpoint(), r.getParams(), r.getHeaders(), r.getBody(), clazz);
            case DELETE:
                return delete(r.getEndpoint(), r.getParams(), r.getHeaders(), clazz);
            case PATCH:
                return patch(r.getEndpoint(), r.getBody(), clazz);
            default:
                throw new RequestException(ERROR_MESSAGE);
        }
    }

    private <T> ClassResponse<T> getResponseAnswer(Response r, Class<T> clazz) {
        T returnObject;
        try {
            returnObject = r.then().extract().as(clazz);
        } catch (Exception e) {
            throw new DeserializationException("Cannot map params response to class " + clazz.getName() +
                    "\n Cause: " + e.getMessage());
        }
        return new ClassResponse<T>(returnObject, r.getHeaders(), r.getStatusCode());
    }

    private JsonResponse getResponseAnswer(Response r) {
        String body = r.getBody().asPrettyString();
        if (body.length() == 0 || body.charAt(0) != '{') {
            return new JsonResponse(new JSONObject().put("answer", body), r.getHeaders(), r.getStatusCode());
        } else {
            JSONObject json = new JSONObject(body);
            return new JsonResponse(json, r.getHeaders(), r.getStatusCode());
        }
    }

    private String getResponse(Response r){
      return  r.getBody().asPrettyString();
    }

    private void setBaseUrl() {
        setBaseUri(BASE_URL);
        logBaseUri(BASE_URL);
    }

    private void logBaseUri(String configuration) {
        log.info("Базовый URI выбран для конфигурации " + configuration);
    }
}