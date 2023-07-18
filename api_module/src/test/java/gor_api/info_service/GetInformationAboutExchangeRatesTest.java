package gor_api.info_service;

import dto.authorization_api.response.ExchangeRate;
import gor_api.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.ClassResponse;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static jdbc.data_base_requests.InfoServiceDataBaseRequests.getCurrencyList;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Яроцкая Е.И.")
@Story("InfoService")
public class GetInformationAboutExchangeRatesTest extends BaseClass {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6217070")
    @Description("Получение информации о курсах валют")
    void authWithPassport() {
        ClassResponse<ExchangeRate[]> json = authApiService.getListOfExchangeRateResponse();
        List<String> currencyListBD = getCurrencyList();
        assertThat(Arrays.stream(json.getBody()).count()).isEqualTo(currencyListBD.stream().count());
    }
}