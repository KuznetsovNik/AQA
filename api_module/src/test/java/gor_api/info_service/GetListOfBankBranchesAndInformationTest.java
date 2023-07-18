package gor_api.info_service;

import dto.authorization_api.response.BankInformation;
import gor_api.BaseClass;
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

import static jdbc.data_base_requests.InfoServiceDataBaseRequests.getBranchNumbersList;
import static org.testng.AssertJUnit.assertEquals;

@Owner("Яроцкая Е.И.")
@Story("InfoService")
public class GetListOfBankBranchesAndInformationTest extends BaseClass {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6217063")
    @Description("Получение списка отделений банка и информации о них")
    void getBankInformation() {
        ClassResponse<BankInformation[]> json = authApiService.getListOfBankInformation();
        Assert.assertEquals((HttpStatus.SC_OK), json.getStatusCode());
        List<String> branchListFromResponse = Arrays.stream(json.getBody()).map(x -> x.getBranch_number()).collect(Collectors.toList());
        List<String> branchListFromDB = getBranchNumbersList();
        assertEquals(branchListFromResponse, branchListFromDB);
    }
}