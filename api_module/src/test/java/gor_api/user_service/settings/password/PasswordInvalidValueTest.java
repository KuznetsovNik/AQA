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

import static helper.ObjectMapperHelper.mapJsonToObject;
import static org.testng.Assert.assertEquals;
import static property.BaseProperties.PASSWORD;

@Epic("EP-14 Изменение пароля в личном кабинете")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение пароля")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6434479")
public class PasswordInvalidValueTest extends BasePassword {

    @DataProvider(name = "invalidValue")
    public Object[][] getInvalidValue() {
        return new Object[][] {
                {PASSWORD, "qweokn003"},
                {PASSWORD, "QWEGHB100"},
                {PASSWORD, "Qwertybvf"},
                {PASSWORD, "QWERTYVBM"},
                {PASSWORD, "qwertyncb"},
                {PASSWORD, "йцуиыо137"},
                /*{PASSWORD, "Qwejsk199!"},*/   //БАГ (https://jira.astondevs.ru/browse/GOR-2052)
                {PASSWORD, "Qwemmm 003"},
                {PASSWORD, "Q"},
                {PASSWORD, "Q1"},
                {PASSWORD, "Qw12"},
                {PASSWORD, "Qii12"},
                {PASSWORD, "Qwertyullll1277557890"},
                {PASSWORD, "Qwertyuihhdy1234663390"}
        };
    }

    @Test(suiteName = "user_service", groups = {"regression"}, dataProvider = "invalidValue")
    @Description("Невалидные данные")
    void changePasswordInvalidValue(String password, String newPassword) {
        authorization(password);
        JsonResponse auth = getAuthorizationResponse(password, newPassword);
        assertEquals(HttpStatus.SC_BAD_REQUEST, auth.getStatusCode());
        authResponse = mapJsonToObject(auth, AuthResponse.class);
    }

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Пустое тело")
    void changePasswordWithEmptyBody() {
        authorization(PASSWORD);
        JsonResponse auth = getAuthorizationResponse(null, null);
        assertEquals(HttpStatus.SC_BAD_REQUEST, auth.getStatusCode());
        authResponse = mapJsonToObject(auth, AuthResponse.class);
    }
}