package gor_api.user_service.settings.notification.push;

import gor_api.user_service.settings.notification.BaseNotification;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static constant.BaseHeaders.RequestHeaders.AUTHORIZATION;
import static org.testng.Assert.assertEquals;

@Epic("EP-10 Изменение PUSH-уведомлений")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение статуса PUSH")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6421483")
public class StatusTrueAuthWithoutTokenNegativeTest extends BaseNotification {

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Изменение статуса PUSH при авторизации без токена")
    void changePUSHNotificationAuthWithoutTokenTest() {
        JsonResponse auth = authApiWithTokenService.getSettingsPUSHNotification(authHeaders.removeKey(AUTHORIZATION),
                changePUSHNotificationStatus(true));
        assertEquals(HttpStatus.SC_UNAUTHORIZED, auth.getStatusCode());
    }
}