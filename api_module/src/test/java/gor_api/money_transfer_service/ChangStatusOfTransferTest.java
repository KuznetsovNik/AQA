package gor_api.money_transfer_service;

import dto.authorization_api.response.AuthResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constant.SpecificApiEndpoints.TRANSFERS_NUMBER_VALID;
import static helper.ObjectMapperHelper.mapJsonToObject;
import static org.testng.AssertJUnit.assertEquals;

@Owner("Яроцкая Е.И.")
@Story("MoneyTransferService")
public class ChangStatusOfTransferTest extends BaseMoneyTransferApplication {

    @DataProvider(name = "transferStatus")
    public static Object[][] getTransferStatus() {
        return new Object[][]{
                {"in_progress"},
                {"done"},
                {"canceled"},
                {"draft"}
        };
    }

    @Test(groups = {"smoke"}, dataProvider = "transferStatus")
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6287702")
    @Description("Просмотр деталей перевода")
    void successfulViewTranslationDetails(String status) {
        JsonResponse auth = authApiWithTokenService.patchChangStatusOfTransfer(TRANSFERS_NUMBER_VALID, authHeaders, statusBody(status));
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_OK));
        AuthResponse response = mapJsonToObject(auth, AuthResponse.class);
        Assert.assertEquals(response.getStatus(), status);
    }
}