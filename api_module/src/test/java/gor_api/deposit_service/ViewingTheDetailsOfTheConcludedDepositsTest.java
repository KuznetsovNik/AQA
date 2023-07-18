package gor_api.deposit_service;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static constant.BaseHeaders.RequestHeaders.AUTHORIZATION;
import static constant.ErrorMessages.*;
import static constant.ParamsList.*;
import static jdbc.data_base_requests.DepositServiceDataBaseRequests.getDepositAccountNumber;

@Owner("Румянцев Е.П.")
@Story("DepositService")
public class ViewingTheDetailsOfTheConcludedDepositsTest extends BaseDepositApplication {

    @Test(enabled = false, groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6324814&group_by=cases:section_id&group_id=1084614&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр подробностей заключенного депозита (пользовательн авторизован, имеет депозиты)")
    void getDepositsFromAnAuthUserWithDeposits() {
        JsonResponse deposit = authApiWithTokenService.getDeposit(DEPOSIT_AGREEMENT_ID, authHeaders);
        Assert.assertEquals(deposit.getStatusCode(), (HttpStatus.SC_OK));
        String depositsListFromResponse = deposit.getJsonObject().getString("accountNumber");
        String depositsListFromDB = getDepositAccountNumber(AUTH_USER_ID_WITH_DEPOSITS, DEPOSIT_AGREEMENT_ID);
        Assert.assertEquals(depositsListFromResponse, depositsListFromDB);
    }

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6325415&group_by=cases:section_id&group_id=1084614&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр подробностей заключенных депозитов (Пользователь не авторизован)")
    void getDepositFromAnUnauthorizedUser() {
        JsonResponse deposit = authApiWithTokenService.getDeposit(DEPOSIT_AGREEMENT_ID, authHeaders.delete());
        Assert.assertEquals(deposit.getStatusCode(), (HttpStatus.SC_UNAUTHORIZED));
        Assert.assertEquals(deposit.getJsonObject().getString("detail"), UNAUTHORIZED_MESSAGE);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6325448&group_by=cases:section_id&group_id=1084614&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр подробностей заключенных депозитов (Пользователь авторизован но срок действия токена истек)")
    void getDepositFromAnAuthUserWithInvalidToken() {
        JsonResponse deposits = authApiWithTokenService.getDeposit(DEPOSIT_AGREEMENT_ID, authHeaders.add(AUTHORIZATION, OLD_TOKEN));
        Assert.assertEquals(deposits.getStatusCode(), (HttpStatus.SC_UNAUTHORIZED));
        Assert.assertEquals(deposits.getJsonObject().getString("detail"), OLD_TOKEN_MESSAGE);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6325414&group_by=cases:section_id&group_id=1084614&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр подробностей заключенного депозита другого пользователя")
    void getDepositFromAnotherUnauthorizedUser() {
        JsonResponse deposit = authApiWithTokenService.getDeposit(DEPOSIT_AGREEMENT_ID_FROM_ANOTHER_USER, authHeaders);
        Assert.assertEquals(deposit.getStatusCode(), (HttpStatus.SC_NOT_FOUND));
        Assert.assertEquals(deposit.getJsonObject().getString("detail"), NOT_FOUND_MESSAGE);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6325464&group_by=cases:section_id&group_id=1084614&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр подробностей заключенных депозитов (Неверный метод запроса)")
    void viewTheDepositDetailsFromAnAuthUserWithAnInvalidRequestsMethods() {
        JsonResponse sendPostDeposit = authApiWithTokenService.postDeposit(DEPOSIT_AGREEMENT_ID, authHeaders);
        Assert.assertEquals(sendPostDeposit.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);
        JsonResponse sendPutDeposit = authApiWithTokenService.putDeposit(DEPOSIT_AGREEMENT_ID, authHeaders);
        Assert.assertEquals(sendPutDeposit.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);
        JsonResponse sendPatchDeposit = authApiWithTokenService.patchDeposit(DEPOSIT_AGREEMENT_ID, authHeaders);
        Assert.assertEquals(sendPatchDeposit.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);
        JsonResponse sendDeleteDeposit = authApiWithTokenService.deleteDeposit(DEPOSIT_AGREEMENT_ID, authHeaders);
        Assert.assertEquals(sendDeleteDeposit.getStatusCode(), (HttpStatus.SC_METHOD_NOT_ALLOWED));
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6325465&group_by=cases:section_id&group_id=1084614&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр подробностей заключенного депозита (Неверный URL запроса)")
    void getDepositsFromAnAuthUserWithAnInvalidURL() {
        JsonResponse deposit = authApiWithTokenService.getDepositWithBadUrl(DEPOSIT_AGREEMENT_ID, authHeaders);
        Assert.assertEquals(deposit.getStatusCode(), (HttpStatus.SC_NOT_FOUND));
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6327016&group_by=cases:section_id&group_id=1084614&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр подробностей заключенного депозита (С телом запроса)")
    void getDepositsFromAnAuthUserWithTEXTBody() {
        JsonResponse depositsWithTextBody = authApiWithTokenService.getDepositWithBody(DEPOSIT_AGREEMENT_ID ,authHeaders, depositsBody("Это тестирование"));
        Assert.assertEquals(depositsWithTextBody.getStatusCode(), (HttpStatus.SC_BAD_REQUEST));
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6327017&group_by=cases:section_id&group_id=1084614&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр подробностей заключенного депозита (С телом запроса)")
    void getDepositsFromAnAuthUserWithJSONBody() {
        JsonResponse depositsWithTextBody = authApiWithTokenService.getDepositWithBody(DEPOSIT_AGREEMENT_ID ,authHeaders, depositsBody("test"));
        Assert.assertEquals(depositsWithTextBody.getStatusCode(), (HttpStatus.SC_BAD_REQUEST));
    }
}