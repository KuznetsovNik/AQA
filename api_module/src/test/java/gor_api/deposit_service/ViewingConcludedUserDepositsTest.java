package gor_api.deposit_service;

import dto.authorization_api.response.Deposits;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.ClassResponse;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static constant.BaseHeaders.RequestHeaders.AUTHORIZATION;
import static constant.ErrorMessages.*;
import static constant.ParamsList.*;
import static jdbc.data_base_requests.DepositServiceDataBaseRequests.getDepositsAccountNumberList;

@Owner("Румянцев Е.П.")
@Story("DepositService")
public class ViewingConcludedUserDepositsTest extends BaseDepositApplication {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6322894&group_by=cases:section_id&group_id=1084613&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр заключенных депозитов у пользователя (Пользователь авторизован, имеет депозиты)")
    void getDepositsFromAnAuthUserWithDeposits() {
        ClassResponse<Deposits[]> deposits = authApiWithTokenService.getDeposits(authHeaders);
        Assert.assertEquals(deposits.getStatusCode(), (HttpStatus.SC_OK));
        List<String> depositsListFromResponse = Arrays.stream(deposits.getBody()).map(Deposits::getAccountNumber).collect(Collectors.toList());
        List<String> depositsListFromDB = getDepositsAccountNumberList(AUTH_USER_ID_WITH_DEPOSITS);
        Assert.assertEquals(depositsListFromResponse, depositsListFromDB);
    }

    @Test(enabled = false, groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6323033&group_by=cases:section_id&group_id=1084613&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр заключенных депозитов у пользователя (Пользователь авторизован, не имеет депозиты)")
    void getDepositsFromAnAuthUserWithoutDeposits() {
        ClassResponse<Deposits[]> deposits = authApiWithTokenService.getDeposits(authHeaders);
        Assert.assertEquals(deposits.getStatusCode(), (HttpStatus.SC_OK));
        List<String> depositsFromResponse = Arrays.stream(deposits.getBody()).map(Deposits::getAccountNumber).collect(Collectors.toList());
        List<String> depositsFromDB = getDepositsAccountNumberList(USER_ID_WITHOUT_DEPOSITS);
        Assert.assertEquals(depositsFromResponse, depositsFromDB);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6323185&group_by=cases:section_id&group_id=1084613&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр заключенных депозитов пользователя (Пользователь не авторизован)")
    void getDepositsFromAnUnauthorizedUser() {
        JsonResponse deposits = authApiWithTokenService.getJsonDeposits(authHeaders.delete());
        Assert.assertEquals(deposits.getStatusCode(), (HttpStatus.SC_UNAUTHORIZED));
        Assert.assertEquals(deposits.getJsonObject().getString("detail"), UNAUTHORIZED_MESSAGE);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6323298&group_by=cases:section_id&group_id=1084613&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр заключенных депозитов пользователя (Пользователь авторизован, но срок действия токена истек)")
    void getDepositsFromAnAuthUserWithInvalidToken() {
        JsonResponse deposits = authApiWithTokenService.getJsonDeposits(authHeaders.add(AUTHORIZATION, OLD_TOKEN));
        Assert.assertEquals(deposits.getStatusCode(), (HttpStatus.SC_UNAUTHORIZED));
        Assert.assertEquals(deposits.getJsonObject().getString("detail"), OLD_TOKEN_MESSAGE);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6323331&group_by=cases:section_id&group_id=1084613&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр заключенных депозитов пользователя (Неверный метод запроса)")
    void viewDepositsFromAnAuthUserWithAnInvalidRequestsMethods() {
        JsonResponse sendPostDeposits = authApiWithTokenService.postDeposits(authHeaders);
        Assert.assertEquals(sendPostDeposits.getStatusCode(), HttpStatus.SC_TEMPORARY_REDIRECT);
        JsonResponse sendPutDeposits = authApiWithTokenService.putDeposits(authHeaders);
        Assert.assertEquals(sendPutDeposits.getStatusCode(), HttpStatus.SC_TEMPORARY_REDIRECT);
        JsonResponse sendPatchDeposits = authApiWithTokenService.patchDeposits(authHeaders);
        Assert.assertEquals(sendPatchDeposits.getStatusCode(), HttpStatus.SC_TEMPORARY_REDIRECT);
        JsonResponse sendDeleteDeposits = authApiWithTokenService.deleteDeposits(authHeaders);
        Assert.assertEquals(sendDeleteDeposits.getStatusCode(), (HttpStatus.SC_TEMPORARY_REDIRECT));
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6323381&group_by=cases:section_id&group_id=1084613&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр заключенных депозитов пользователя (Неверный URL запроса)")
    void getDepositsFromAnAuthUserWithAnInvalidURL() {
        JsonResponse deposits = authApiWithTokenService.getDepositsWithBadUrl(authHeaders.add(AUTHORIZATION, OLD_TOKEN));
        Assert.assertEquals(deposits.getStatusCode(), (HttpStatus.SC_NOT_FOUND));
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6326929&group_by=cases:section_id&group_id=1084613&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр заключенных депозитов пользователя (Ошибка 500 Internal Server Error, негативный)")
    void getDepositsFromAnAuthUserWithTextBody() {
        JsonResponse depositsWithTextBody = authApiWithTokenService.getDepositsWithBody(authHeaders, depositsBody("Это тестирование"));
        Assert.assertEquals(depositsWithTextBody.getStatusCode(), (HttpStatus.SC_OK));
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6326948&group_by=cases:section_id&group_id=1084613&group_order=asc&display_deleted_cases=0")
    @Description("Просмотр заключенных депозитов пользователя (С телом запроса)")
    void getDepositsFromAnAuthUserWithJSONBody() {
        JsonResponse depositsWithTextBody = authApiWithTokenService.getDepositsWithBody(authHeaders, depositsBody("test"));
        Assert.assertEquals(depositsWithTextBody.getStatusCode(), (HttpStatus.SC_OK));
    }
}