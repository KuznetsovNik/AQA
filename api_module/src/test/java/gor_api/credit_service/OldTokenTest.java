package gor_api.credit_service;

import dto.authorization_api.response.AuthResponse;
import gor_api.authorization_one_time.BaseAuthorization;
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

@Story("CreditService")
@Owner("Верхова А.В.")
public class OldTokenTest extends BaseAuthorization {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6220283")
    @Description("Отправка графика платежей по кредиту при истёкшем токене авторизации.")
    void oldToken() {
        headers.add(TOKEN, OLD_TOKEN);
        JsonResponse auth = authApiService.getOldToken(headers);
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_UNAUTHORIZED));
        response = mapJsonToObject(auth, AuthResponse.class);
        Assert.assertEquals(response.getMessage(), OLD_TOKEN_MESSAGE);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6220280")
    @Description(" Отправка информации по кредиту при истёкшем токене авторизации.")
    void infoCreditOldToken() {
        headers.add(TOKEN, OLD_TOKEN);
        JsonResponse auth = authApiService.getInfoCreditOldToken(headers);
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_UNAUTHORIZED));
        response = mapJsonToObject(auth, AuthResponse.class);
        Assert.assertEquals(response.getMessage(), OLD_TOKEN_MESSAGE);
    }
}