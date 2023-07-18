package gor_api.credit_service;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constant.DataCredit.*;
import static org.testng.AssertJUnit.assertEquals;

@Story("CreditService")
@Owner("Верхова А.В.")
public class NotValidDataTestDataProviderTest extends BaseCreditApplication {

    @DataProvider(name = "notValidDateCreditApplicatio")
    public static Object[][] getNotValidDate() {
        return new Object[][]{
                {null, AMOUNT_VALID, AVERAGE_MONTHLY_INCOME_VALID, AVERAGE_MONTHLY_EXPENDITURE_VALID,
                        PRODUCT_ID_VALID, EMPLOYER_IDENTIFICATION_NUMBER_VALID, HttpStatus.SC_BAD_REQUEST},
                {PERIOD_MONTH_VALID, null, AVERAGE_MONTHLY_INCOME_VALID, AVERAGE_MONTHLY_EXPENDITURE_VALID,
                        PRODUCT_ID_VALID, EMPLOYER_IDENTIFICATION_NUMBER_VALID, HttpStatus.SC_BAD_REQUEST},
                {PERIOD_MONTH_VALID, AMOUNT_VALID, null, AVERAGE_MONTHLY_EXPENDITURE_VALID,
                        PRODUCT_ID_VALID, EMPLOYER_IDENTIFICATION_NUMBER_VALID, HttpStatus.SC_BAD_REQUEST},
                {PERIOD_MONTH_VALID, AMOUNT_VALID, AVERAGE_MONTHLY_INCOME_VALID, AVERAGE_MONTHLY_EXPENDITURE_VALID,
                        PRODUCT_ID_VALID, EMPLOYER_IDENTIFICATION_NUMBER_VALID, HttpStatus.SC_BAD_REQUEST},
                {PERIOD_MONTH_VALID, AMOUNT_VALID, AVERAGE_MONTHLY_INCOME_VALID, null,
                        PRODUCT_ID_VALID, EMPLOYER_IDENTIFICATION_NUMBER_VALID, HttpStatus.SC_BAD_REQUEST},
                {PERIOD_MONTH_VALID, AMOUNT_VALID, AVERAGE_MONTHLY_INCOME_VALID, AVERAGE_MONTHLY_EXPENDITURE_VALID,
                        null, EMPLOYER_IDENTIFICATION_NUMBER_VALID, HttpStatus.SC_BAD_REQUEST},
                {PERIOD_MONTH_VALID, AMOUNT_VALID, AVERAGE_MONTHLY_INCOME_VALID, AVERAGE_MONTHLY_EXPENDITURE_VALID,
                        PRODUCT_ID_VALID, null, HttpStatus.SC_BAD_REQUEST},
                {NOT_VALID_DATA, NOT_VALID_DATA, NOT_VALID_DATA, NOT_VALID_DATA, NOT_VALID_DATA,
                        NOT_VALID_DATA, HttpStatus.SC_BAD_REQUEST},
                {NOT_VALID_DATA_LETTER, NOT_VALID_DATA_LETTER, NOT_VALID_DATA_LETTERS, NOT_VALID_DATA_LETTERS,
                        NOT_VALID_DATA_LETTERS, NOT_VALID_DATA_LETTERS, HttpStatus.SC_BAD_REQUEST},
                {"", "", "", "", "", "", HttpStatus.SC_BAD_REQUEST},
                {null, null, null, null, null, null, HttpStatus.SC_BAD_REQUEST}
        };
    }

    @Test(groups = {"regression"}, dataProvider = "notValidDateCreditApplicatio")
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6213996")
    @Description("Запрос не проходит при вводе не валидных данных при получении заявки на кредит")
    void creditInvalidSymbol(String periodMonth, String amount, String averageMonthlyIncome,
                             String averageMonthlyExpenditure, String productId,
                             String employerIdentificationNumber, int badRequest) {
        JsonResponse auth = authApiWithTokenService.postSpecSymbol(authHeaders, creditBody(periodMonth, amount, averageMonthlyIncome, averageMonthlyExpenditure, employerIdentificationNumber, productId));
        assertEquals(auth.getStatusCode(), badRequest);
        Assert.assertNotNull(auth.getJsonObject());
    }
}