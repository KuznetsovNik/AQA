package gor_api.credit_service;

import dto.authorization_api.response.LoanInformation;
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
import java.util.List;
import java.util.stream.Collectors;

import static jdbc.data_base_requests.CreditServiceDataBaseRequests.getCreditNameByCreditId;

@Owner("Яроцкая Е.И.")
@Story("CreditService")
public class SuccessfulGetLoanInformationTest extends BaseClassWithAuthToken {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6220281")
    @Description("Успешная отправка информации по кредиту")
    void getLoanInformation() {
        ClassResponse<LoanInformation[]> json = authApiWithTokenService.getLoanInformation(authHeaders);
        Assert.assertEquals((HttpStatus.SC_OK), json.getStatusCode());
        List<LoanInformation> response = Arrays.stream(json.getBody()).collect(Collectors.toList());
        String productNameListFromDB = getCreditNameByCreditId(response.get(0).getId());
        String productNameFromResponse = response.get(0).getName();
        Assert.assertEquals(productNameFromResponse, productNameListFromDB);
    }
}