package gor_api.money_transfer_service;

import dto.authorization_api.response.HistoryMT;
import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.ClassResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

@Owner("Яроцкая Е.И.")
@Story("MoneyTransferService ")
public class OperationHistoryMTDisplayTest extends BaseClassWithAuthToken {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/C6276187")
    @Description("Отображение истории операций авторизованного пользователя")
    void successfulOperationHistoryDisplay() {
        ClassResponse<HistoryMT[]> json = authApiWithTokenService.getHistoryDisplay(authHeaders);
        assertEquals(json.getStatusCode(), (HttpStatus.SC_OK));
        Assert.assertTrue(Arrays.stream(json.getBody()).findAny().isPresent());
    }
}