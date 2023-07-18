package gor_api.authorization_one_time.AuthValidDocument;

import gor_api.authorization_one_time.BaseAuthorization;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static model.DocType.RESIDENT_CARD_BY;
import static constant.DataConstants.LOGIN_VALID_RESIDENT_CARD_BY;
import static property.BaseProperties.PASSWORD;
import static constant.DataConstants.TYPE_DOCUMENT;
import static org.testng.AssertJUnit.assertEquals;

@Epic("EP-6 Авторизация пользователя (разовая)")
@Owner("Чесноков Д.А.")
@Story("User-Service. Авторизация по документу")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6386156")
public class AuthValidResidentCardByTest extends BaseAuthorization {

    @Test(enabled = false, suiteName = "user_service", groups = {"smoke", "regression"})
    @Description("ВНЖ РБ. Валидные данные")
    void authWithResidentCardBy() {
        JsonResponse auth = authApiService.postPassport(headers,
                body(RESIDENT_CARD_BY.getCode(), LOGIN_VALID_RESIDENT_CARD_BY, PASSWORD, TYPE_DOCUMENT));
        assertEquals(HttpStatus.SC_OK, auth.getStatusCode());
    }
}