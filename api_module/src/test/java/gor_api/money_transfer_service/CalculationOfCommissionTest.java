package gor_api.money_transfer_service;

import dto.authorization_api.response.AuthResponse;
import dto.authorization_api.response.CommissionAmounts;
import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static constant.BaseHeaders.Authorization.BEARER;
import static constant.BaseHeaders.RequestHeaders.AUTHORIZATION;
import static constant.ParamsList.OLD_TOKEN;
import static constant.SpecificApiEndpoints.*;
import static helper.ObjectMapperHelper.mapJsonToObject;
import static org.testng.AssertJUnit.assertEquals;

@Owner("Яроцкая Е.И.")
@Story("MoneyTransferService ")
public class CalculationOfCommissionTest extends BaseClassWithAuthToken {

    @AfterMethod(alwaysRun = true)
    public void after() {
        authHeaders.add(AUTHORIZATION, BEARER + accessToken);
    }

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6279455")
    @Description("Расчет суммы комиссии с корректными данными")
    void successfulCalculationOfCommissionWithCorrectiveData() {
        JsonResponse auth = authApiWithTokenService
                .getCommissionAmounts(TRANSFER_TYPE_VALID, CURRENCY_CODE_VALID, authHeaders);
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_OK));
        CommissionAmounts commissionAmounts = mapJsonToObject(auth, CommissionAmounts.class);
        Assert.assertNotNull(commissionAmounts.getCommissionPercent());
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6279455")
    @Description("Расчет суммы комиссии с некорректным типом перевода")
    void unSuccessfulCalculationWithNotValidTransferTyp() {
        JsonResponse auth = authApiWithTokenService
                .getCommissionAmounts(TRANSFER_TYPE_NOT_VALID, CURRENCY_CODE_VALID, authHeaders);
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_NOT_FOUND));
        AuthResponse response = mapJsonToObject(auth, AuthResponse.class);
        Assert.assertNotNull(response.getDetail());
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6279455")
    @Description("Расчет суммы комиссии с некорректным типом валютыи")
    void unSuccessfulCalculationOfCommissionWithNotValidCurrencyCode() {
        JsonResponse auth = authApiWithTokenService
                .getCommissionAmounts(TRANSFER_TYPE_VALID, CURRENCY_CODE_NOT_VALID, authHeaders);
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_INTERNAL_SERVER_ERROR));
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6297103")
    @Description("Расчет суммы комиссии с корректными данными (неавторизованный пользователь)")
    void unSuccessfulCalculationOfCommissionWithAuthorizationUser() {
        JsonResponse auth = authApiWithTokenService.getCommissionAmounts(TRANSFER_TYPE_VALID, CURRENCY_CODE_VALID, authHeaders.add(AUTHORIZATION, ""));
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_BAD_REQUEST));
        AuthResponse response = mapJsonToObject(auth, AuthResponse.class);
        Assert.assertNotNull(response.getMessage());
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6297171")
    @Description("Расчет суммы комиссии с корректными данными (истекший токен)")
    void UnSuccessfulCalculationOfCommissionWithOldToken() {
        JsonResponse auth = authApiWithTokenService.getCommissionAmounts(TRANSFER_TYPE_VALID, CURRENCY_CODE_VALID, authHeaders.add(AUTHORIZATION, OLD_TOKEN));
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_UNAUTHORIZED));
        AuthResponse response = mapJsonToObject(auth, AuthResponse.class);
        Assert.assertNotNull(response.getMessage());
    }
}