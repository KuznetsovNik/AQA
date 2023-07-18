package gor_api.user_service.settings.notification.push;

import gor_api.user_service.settings.notification.BaseNotification;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Epic("EP-10 Изменение PUSH-уведомлений")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение статуса PUSH")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6421429")
public class StatusTrueAndFalsePositiveTest extends BaseNotification {

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Изменение статуса PUSH на true")
    void changePUSHNotificationStatusTrueTest() {
        assertEquals(HttpStatus.SC_OK, getAuthorizationResponsePUSH(true).getStatusCode());
        assertTrue(getUser().isPushNotification());
    }

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Изменение статуса PUSH на false")
    void changePUSHNotificationStatusFalseTest() {
        assertEquals(HttpStatus.SC_OK, getAuthorizationResponsePUSH(false).getStatusCode());
        assertFalse(getUser().isPushNotification());
    }
}