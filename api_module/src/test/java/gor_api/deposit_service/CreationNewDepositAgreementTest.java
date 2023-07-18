package gor_api.deposit_service;

import dto.authorization_api.response.AuthResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import jdbc.data_base_requests.pojo.DepositPojo;
import jdbc.data_base_requests.pojo.Product;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.*;

import static helper.ObjectMapperHelper.mapJsonToObject;
import static jdbc.data_base_requests.DepositServiceDataBaseRequests.*;
import static org.testng.AssertJUnit.assertEquals;

@Owner("Яроцкая Е.И.")
@Story("DepositService ")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6325502")

public class CreationNewDepositAgreementTest extends BaseDepositApplication {

    private int productId;

    public CreationNewDepositAgreementTest(int productId) {
        this.productId = productId;
    }

    @DataProvider(name = "DepositData")
    public Object[][] getDepositData() {
        Product productInfo = getProductInfoById(productId);
        return new Object[][]{
                {productInfo.getId(), productInfo.getMinSum(), "1234567891234567", "true",
                        productInfo.getMinDuration()},
                {productInfo.getId(), productInfo.getMaxSum(), "1234567891234567", "true",
                        (productInfo.getMinDuration() + productInfo.getMaxDuration()) / 2},
                {productInfo.getId(), (productInfo.getMinSum() + productInfo.getMaxSum()) / 2,
                        "1234567891234567", "true", productInfo.getMaxDuration()},
        };
    }

    String agreementID;

    @Test(groups = {"smoke"}, dataProvider = "DepositData")
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6287702")
    @Description("Создание нового депозитного договора")
    void successfulCreationNewDepositAgreement(Integer productId, Float initialAmount, String accountNumber,
                                               String autoRenewal, Integer duration) {
        JsonResponse responseDepositAgreement = authApiWithTokenService.postNewDepositAgreement(authHeaders,
                depositBody(productId.toString(), initialAmount.toString(), accountNumber, autoRenewal, duration.toString()));
        assertEquals(responseDepositAgreement.getStatusCode(), (HttpStatus.SC_CREATED));
        AuthResponse response = mapJsonToObject(responseDepositAgreement, AuthResponse.class);
        agreementID = response.getAgreementID();
        DepositPojo depositDB = getDepositById(agreementID);
        Assert.assertEquals(depositDB.getProductId(), productId);
        Assert.assertEquals(depositDB.getInitialAmount(), initialAmount);
        Assert.assertEquals(depositDB.getIsAutoRenewal().toString(), autoRenewal);
    }

    @AfterMethod
    private void deleteDeposit() {
        deleteDepositById(agreementID);
    }
}