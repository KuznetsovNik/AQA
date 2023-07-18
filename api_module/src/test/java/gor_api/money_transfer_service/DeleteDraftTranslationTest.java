package gor_api.money_transfer_service;

import dto.authorization_api.response.AuthResponse;
import dto.authorization_api.response.CreditApplication;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constant.BaseHeaders.Authorization.BEARER;
import static constant.BaseHeaders.RequestHeaders.AUTHORIZATION;
import static constant.DataMoneyTransfer.*;
import static constant.ErrorMessages.*;
import static constant.ParamsList.OLD_TOKEN;
import static helper.ObjectMapperHelper.mapJsonToObject;
import static jdbc.data_base_requests.MoneyTransferServiceDataBaseRequests.getTranslationSenderId;
import static org.testng.Assert.assertEquals;

@Owner("Яроцкая Е.И.")
@Story("MoneyTransferService")
public class DeleteDraftTranslationTest extends BaseMoneyTransferApplication {

    String id;

    @DataProvider(name = "incorrectId")
    public static Object[][] getIncorrectId() {
        return new Object[][]{
                {"507"},
                {"ssk"},
                {"ккн"},
                {"+*-"}
        };
    }

    @BeforeMethod
    public void before() {
        JsonResponse applicationResponse = authApiWithTokenService.postForMoneyTransfer(authHeaders, transferBody(SENDER_CARD_NUMBER_V,
                TRANSFER_TYPE_V, TRANSFER_SUM, RUB_CURRENCY, RUB_CURRENCY, PAYEE_ACCOUNT_NUMBER, COMMISSION, PURPOSE,
                TRANSFER_SYSTEM, CURRENCY_EXCHANGE, AUTHORIZATION_CODE, EXCH_SUM, EXCH_RATE, MOBILE_PHONE_V));
        assertEquals(applicationResponse.getStatusCode(), (HttpStatus.SC_CREATED));
        CreditApplication creditApplication = mapJsonToObject(applicationResponse, CreditApplication.class);
        id = creditApplication.getId();
        JsonResponse jsonResponse = authApiWithTokenService.patchAutoTransactionStatus(id, authHeaders,
                autoTransactionStatusBody(PERIODICITY, START_DATE, EXPIRATION_DATE));
        assertEquals(jsonResponse.getStatusCode(), (HttpStatus.SC_OK));
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        authApiWithTokenService.deleteAutoTransaction(id, authHeaders.add(AUTHORIZATION, BEARER + accessToken));
    }

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6275398")
    @Description("Удаление созданного черновика перевода авторизованным пользователем")
    void successfulDeleteDraftTranslation() {
        JsonResponse jsonResponse = authApiWithTokenService.deleteAutoTransaction(id, authHeaders);
        assertEquals(jsonResponse.getStatusCode(), (HttpStatus.SC_NO_CONTENT));
        Assert.assertNull(getTranslationSenderId(id));
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6275398")
    @Description("Удаление созданного черновика перевода авторизованным пользователем")
    void unSuccessfulDeleteDraftTranslationWithStatusInProgress() {
        authApiWithTokenService.patchChangStatusOfTransfer(id, authHeaders, statusBody("in_progress"));
        JsonResponse jsonResponse = authApiWithTokenService.deleteAutoTransaction(id, authHeaders);
        assertEquals(jsonResponse.getStatusCode(), (HttpStatus.SC_FORBIDDEN));
        authApiWithTokenService.patchChangStatusOfTransfer(id, authHeaders, statusBody("draft"));
    }

    @Test(groups = {"regression"}, dataProvider = "incorrectId")
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6278139")
    @Description(" Удаление созданного черновика перевода при некорректном ID (буквы, символы)")
    void successfulDeleteDraftTranslationAndCreateWithUnCorrectId(String testId) {
        JsonResponse jsonResponse = authApiWithTokenService.deleteAutoTransaction(testId, authHeaders);
        assertEquals(jsonResponse.getStatusCode(), (HttpStatus.SC_NOT_FOUND));
        AuthResponse response = mapJsonToObject(jsonResponse, AuthResponse.class);
        Assert.assertEquals(response.getDetail(), NOT_FOUND_MESSAGE);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6278245" +
            "https://vmmreg32.testrail.net/index.php?/cases/view/6278245")
    @Description("Удаление уже удаленного черновика перевода")
    void unSuccessfulDeleteDeletedDraftTranslation() {
        JsonResponse jsonResponse = authApiWithTokenService.deleteAutoTransaction(id, authHeaders);
        assertEquals(jsonResponse.getStatusCode(), (HttpStatus.SC_NO_CONTENT));
        Assert.assertNull(getTranslationSenderId(id));
        JsonResponse json = authApiWithTokenService.deleteAutoTransaction(id, authHeaders);
        assertEquals(json.getStatusCode(), (HttpStatus.SC_NOT_FOUND));
        AuthResponse response = mapJsonToObject(json, AuthResponse.class);
        Assert.assertEquals(response.getDetail(), NOT_FOUND_MESSAGE);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6284490")
    @Description("Удаление созданного черновика перевода авторизованным пользователем с истекшим токеном")
    void unSuccessfulDeleteDraftTranslationExpired() {
        JsonResponse jsonResponse = authApiWithTokenService.deleteAutoTransaction(id, authHeaders.add(AUTHORIZATION, OLD_TOKEN));
        assertEquals(jsonResponse.getStatusCode(), (HttpStatus.SC_UNAUTHORIZED));
        AuthResponse response = mapJsonToObject(jsonResponse, AuthResponse.class);
        Assert.assertEquals(response.getMessage(), OLD_TOKEN_MESSAGE);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6278138")
    @Description("Удаление созданного черновика перевода неавторизованным пользователем")
    void unSuccessfulDeleteDraftTranslationUnAuthorization() {
        JsonResponse jsonResponse = authApiWithTokenService.deleteAutoTransaction(id, authHeaders.add(AUTHORIZATION, ""));
        assertEquals(jsonResponse.getStatusCode(), (HttpStatus.SC_BAD_REQUEST));
        AuthResponse response = mapJsonToObject(jsonResponse, AuthResponse.class);
        Assert.assertEquals(response.getMessage(), NO_TOKEN_PROVIDED_MESSAGE);
    }
}