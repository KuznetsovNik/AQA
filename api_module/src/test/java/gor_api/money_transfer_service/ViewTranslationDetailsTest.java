package gor_api.money_transfer_service;

import dto.authorization_api.response.AuthResponse;
import dto.authorization_api.response.TranslationDetails;
import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static constant.SpecificApiEndpoints.TRANSFERS_NUMBER_NOT_VALID;
import static constant.SpecificApiEndpoints.TRANSFERS_NUMBER_VALID;
import static helper.ObjectMapperHelper.mapJsonToObject;
import static org.testng.AssertJUnit.assertEquals;

@Owner("Яроцкая Е.И.")
@Story("MoneyTransferService ")
public class ViewTranslationDetailsTest extends BaseClassWithAuthToken {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6287702")
    @Description("Просмотр деталей перевода")
    void successfulViewTranslationDetails() {
        JsonResponse auth = authApiWithTokenService.getTranslationDetails(TRANSFERS_NUMBER_VALID, authHeaders);
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_OK));
        TranslationDetails details = mapJsonToObject(auth, TranslationDetails.class);
        Assert.assertNotNull(details.getTransferSum());
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6303167")
    @Description("Просмотр деталей перевода (Несуществующий или удалённый перевод)")
    void unSuccessfulViewTranslationDetails() {
        JsonResponse auth = authApiWithTokenService.getTranslationDetails(TRANSFERS_NUMBER_NOT_VALID, authHeaders);
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_NOT_FOUND));
        AuthResponse response = mapJsonToObject(auth, AuthResponse.class);
        Assert.assertNotNull(response.getDetail());
    }
}