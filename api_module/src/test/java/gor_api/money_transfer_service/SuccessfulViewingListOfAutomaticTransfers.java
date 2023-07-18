package gor_api.money_transfer_service;

import dto.authorization_api.response.ListAutotransfer;
import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.Stream;

import static helper.ObjectMapperHelper.mapJsonToObject;
import static org.testng.AssertJUnit.assertEquals;

@Owner("Яроцкая Е.И.")
@Story("MoneyTransferService ")
public class SuccessfulViewingListOfAutomaticTransfers extends BaseClassWithAuthToken {

    @Test(groups = {"smoke"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6287701")
    @Description("Просмотр списка автопереводов у пользователя")
    void getLoanInformation() {
        JsonResponse autoTransfers = authApiWithTokenService.getAutoTransfers(authHeaders);
        assertEquals(autoTransfers.getStatusCode(), (HttpStatus.SC_OK));
        ListAutotransfer autoTransfer = mapJsonToObject(autoTransfers, ListAutotransfer.class);
        Assert.assertTrue(Stream.of(autoTransfer).findAny().isPresent());
    }
}
