package gor_api.user_service.settings.password;

import dto.authorization_api.response.AuthResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constant.SuccessfulMessage.PASSWORD_CHANGED;
import static helper.ObjectMapperHelper.mapJsonToObject;
import static property.BaseProperties.PASSWORD;
import static org.testng.Assert.assertEquals;

@Epic("EP-14 Изменение пароля в личном кабинете")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение пароля")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6434475")
public class PasswordValidValueTest extends BasePassword {

    @DataProvider(name = "validValue")
    public Object[][] getValidValue() {
        return new Object[][] {
                {PASSWORD, "Qweewq121"},
                {PASSWORD, "Ewa113"},
                {PASSWORD, "Aerw113"},
                {PASSWORD, "Qwertyunht123765789"},
                {PASSWORD, "Qwertyulkj0123000089"}
        };
    }

    @Test(suiteName = "user_service", groups = {"regression"}, dataProvider = "validValue")
    @Description("Валидные данные")
    void changePasswordValidValueTest(String password, String newPassword) {
        authorization(password);
        JsonResponse auth = getAuthorizationResponse(password, newPassword);
        assertEquals(HttpStatus.SC_OK, auth.getStatusCode());
        authResponse = mapJsonToObject(auth, AuthResponse.class);
        assertEquals(PASSWORD_CHANGED, authResponse.getDetail());
        authorization(newPassword);
        assertEquals(HttpStatus.SC_OK, returnPassword(password, newPassword).getStatusCode());
    }

    @Description("Возвращаем исходные данные")
    public JsonResponse returnPassword(String password, String newPassword) {
        return getAuthorizationResponse(newPassword, password);
    }
}