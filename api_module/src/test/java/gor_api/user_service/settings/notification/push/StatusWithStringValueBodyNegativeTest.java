package gor_api.user_service.settings.notification.push;

import gor_api.user_service.settings.notification.BaseNotification;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static constant.DataConstants.NOTIFICATION_STATUS;
import static org.testng.Assert.assertEquals;

@Epic("EP-10 Изменение PUSH-уведомлений")
@Owner("Чесноков Д.А.")
@Story("User-Service. Изменение статуса PUSH")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6421492")
public class StatusWithStringValueBodyNegativeTest extends BaseNotification {

    @Test(suiteName = "user_service", groups = {"regression"})
    @Description("Отправка строкового значения в теле")
    void changePUSHNotificationWithStringValueBodyTest() {
        assertEquals(HttpStatus.SC_BAD_REQUEST, getAuthorizationResponsePUSH(NOTIFICATION_STATUS).getStatusCode());
    }
}