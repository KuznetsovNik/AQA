package gor_api.credit_service;

import dto.authorization_api.response.CreditApplication;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static constant.DataCredit.*;
import static helper.ObjectMapperHelper.mapJsonToObject;
import static jdbc.data_base_requests.CreditServiceDataBaseRequests.deleteCreditOrderById;
import static jdbc.data_base_requests.CreditServiceDataBaseRequests.getCreditPeriodMonthFromCreditOrderById;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;

@Story("CreditService")
@Owner("Верхова А.В.")
public class DifferentDataTest extends BaseCreditApplication {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6213948")
    @Description("Возможность получения заявки на кредит при вводе валидных данных")
    void creditValidData() {
        JsonResponse applicationResponse = authApiWithTokenService.postSpecSymbol(authHeaders, creditBody(PERIOD_MONTH_VALID,
                AMOUNT_VALID, AVERAGE_MONTHLY_INCOME_VALID, AVERAGE_MONTHLY_EXPENDITURE_VALID,
                PRODUCT_ID_VALID, EMPLOYER_IDENTIFICATION_NUMBER_VALID));
        assertEquals(applicationResponse.getStatusCode(), (HttpStatus.SC_CREATED));
        CreditApplication creditApplication = mapJsonToObject(applicationResponse, CreditApplication.class);
        String idApplication = creditApplication.getId();
        String periodMonthDB = getCreditPeriodMonthFromCreditOrderById(idApplication);
        assertEquals(creditApplication.getPeriodMonth(), periodMonthDB);
        assertFalse(deleteCreditOrderById(idApplication));
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6213996")
    @Description("Запрос не проходит при вводе не валидных данных(спецсимволы) при получении заявки на кредит")
    void creditInvalidSymbol() {
        JsonResponse auth = authApiWithTokenService.postSpecSymbol(authHeaders, creditBody(NOT_VALID_DATA, NOT_VALID_DATA,
                NOT_VALID_DATA, NOT_VALID_DATA, NOT_VALID_DATA, NOT_VALID_DATA));
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_BAD_REQUEST));
        Assert.assertNotNull(auth.getJsonObject());
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6213993")
    @Description("Запрос не проходит при вводе не валидных данных(строчные и заглавные буквы) при получении заявки на кредит")
    void creditInvalidLetter() {
        JsonResponse auth = authApiWithTokenService.postSpecSymbol(authHeaders, creditBody(NOT_VALID_DATA_LETTER, NOT_VALID_DATA_LETTER,
                NOT_VALID_DATA_LETTERS, NOT_VALID_DATA_LETTERS, NOT_VALID_DATA_LETTERS, NOT_VALID_DATA_LETTERS));
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_BAD_REQUEST));
        Assert.assertNotNull(auth.getJsonObject());
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6220279")
    @Description("Отправка информации по кредиту, передав невалидный параметр creditId")
    void creditInvalidParam() {
        JsonResponse auth = authApiWithTokenService.getInfoCreditInvalidParams(authHeaders);
        assertEquals(auth.getStatusCode(), (HttpStatus.SC_NOT_FOUND));
    }
}