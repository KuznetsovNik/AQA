package gor_api.credit_service;

import dto.authorization_api.response.CreditProducts;
import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.ClassResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static jdbc.data_base_requests.CreditServiceDataBaseRequests.getCreditProductsNameList;
import static org.testng.AssertJUnit.assertEquals;

@Owner("Яроцкая Е.И.")
@Story("CreditService")
public class SuccessfulGetCreditProductsTest extends BaseClassWithAuthToken {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6217052")
    @Description("Отправка активных банковских продуктов (КРЕДИТЫ)")
    void getLoanInformation() {
        ClassResponse<CreditProducts[]> creditProducts = authApiWithTokenService.getCreditProducts(authHeaders);
        assertEquals(creditProducts.getStatusCode(), (HttpStatus.SC_OK));
        List<String> productNameListFromResponse = Arrays.stream(creditProducts.getBody()).map(x -> x.getProductName()).collect(Collectors.toList());
        List<String> productNameListFromDB = getCreditProductsNameList();
        assertEquals(productNameListFromResponse, productNameListFromDB);
    }
}