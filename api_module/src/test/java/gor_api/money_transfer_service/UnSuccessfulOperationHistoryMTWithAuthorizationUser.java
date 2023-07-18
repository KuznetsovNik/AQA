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

import static constant.ErrorMessages.NO_TOKEN_PROVIDED_MESSAGE;
import static helper.ObjectMapperHelper.mapJsonToObject;
import static org.testng.AssertJUnit.assertEquals;

@Owner("Яроцкая Е.И.")
@Story("MoneyTransferService ")
public class UnSuccessfulOperationHistoryMTWithAuthorizationUser extends BaseClass {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6287805")
    @Description("Отображение истории операций (пользователь не авторизован)")
    void unSuccessfulOperationHistoryTest() {
        JsonResponse auth = authApiService.getHistoryDisplay(headers);
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_BAD_REQUEST));
        response = mapJsonToObject(auth, AuthResponse.class);
        Assert.assertEquals(response.getMessage(), NO_TOKEN_PROVIDED_MESSAGE);
    }
}