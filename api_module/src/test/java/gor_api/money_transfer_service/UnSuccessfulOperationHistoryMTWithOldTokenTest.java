package gor_api.money_transfer_service;

import dto.authorization_api.response.AuthResponse;
import gor_api.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static constant.ErrorMessages.OLD_TOKEN_MESSAGE;
import static constant.ParamsList.OLD_TOKEN;
import static constant.ParamsList.TOKEN;
import static helper.ObjectMapperHelper.mapJsonToObject;
import static org.testng.AssertJUnit.assertEquals;

@Owner("Яроцкая Е.И.")
@Story("MoneyTransferService ")
public class UnSuccessfulOperationHistoryMTWithOldTokenTest extends BaseClass {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6297171")
    @Description("Расчет суммы комиссии с корректными данными (истекший токен)")
    void getCalculationOfCommission() {
        headers.add(TOKEN, OLD_TOKEN);
        JsonResponse auth = authApiService.getHistoryDisplay(headers);
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_UNAUTHORIZED));
        response = mapJsonToObject(auth, AuthResponse.class);
        Assert.assertEquals(response.getMessage(), OLD_TOKEN_MESSAGE);
    }
}