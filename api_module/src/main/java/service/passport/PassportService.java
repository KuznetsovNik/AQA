package service.passport;

import io.restassured.http.ContentType;
import model.entity.ReqHeaders;
import service.BaseApiService;

import static property.BaseProperties.BASE_URL;
import static service.passport.RandomStringUtils.randomLatin;

/**
 * Сервис аутентификации
 */
public class PassportService extends BaseApiService {

    public ReqHeaders<?, ?> headers = new ReqHeaders<>();
    public static final String VALUE_FOR_HEADERS = randomLatin(5);

    public PassportService() {
        configApiClient();
    }

    private void configApiClient() {
        apiClient.setContentType(ContentType.JSON);
        apiClient.setBaseUri(BASE_URL);
    }
}