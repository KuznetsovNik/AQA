package gor_api.credit_service;

import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Epic("Credit Service")
@Owner("Бакунин А.В.")
public class SendCreditOrderTest extends BaseClassWithAuthToken {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6046275&group_by=cases:section_id&group_id=1065032&group_order=asc&display_deleted_cases=0")
    @Description("Отправка кредитных заявок")
    void creditCardsInfo() {
        JsonResponse json = authApiWithTokenService.getCreditOrder(authHeaders);
        assertEquals(json.getStatusCode(), (HttpStatus.SC_OK));
        assertNotNull(json.getJsonObject());
    }
}
