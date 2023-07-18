package gor_api.user_registration;

import gor_api.BaseClass;
import model.entity.NewUserRegistrationModel;
import io.qameta.allure.*;
import model.DocType;
import model.Location;
import model.response.JsonResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static model.entity.NewUserRegistrationModel.getExemplarWithRandomData;
import static jdbc.data_base_requests.UserServiceDataBaseRequests.*;

@Epic("EP 5.Регистрация не Клиента в приложении.")
@Owner("Румянцев Е.П.")
@Story("UserRegistration")
public class UserRegistrationWithValidDataTest extends BaseClass {

    @DataProvider(name = "validUserData")
    public Object[][] getUserData() {
        return new Object[][] {
                {getExemplarWithRandomData(Location.BY, DocType.PASSPORT_BY)},
                {getExemplarWithRandomData(Location.BY, DocType.RESIDENT_CARD_BY)},
                {getExemplarWithRandomData(Location.BY, DocType.ANOTHER_DOC)},
                {getExemplarWithRandomData(Location.BY, DocType.PASSPORT_RU)},
                {getExemplarWithRandomData(Location.BY, DocType.RESIDENT_CARD_RU)},
                {getExemplarWithRandomData(Location.RU, DocType.PASSPORT_RU)},
                {getExemplarWithRandomData(Location.RU, DocType.RESIDENT_CARD_RU)},
                {getExemplarWithRandomData(Location.RU, DocType.ANOTHER_DOC)},
                {getExemplarWithRandomData(Location.RU, DocType.PASSPORT_BY)},
                {getExemplarWithRandomData(Location.RU, DocType.RESIDENT_CARD_BY)}
        };
    }

    @Test(groups = {"smoke"}, dataProvider = "validUserData")
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6211491&group_by=cases:section_id&group_id=1065170&group_order=asc&display_deleted_cases=0")
    @Description("Регистрация нового пользователя при заполнении параметров валидными данными (работоспособность эндпоинта, корректные значения).")
    public void userRegistrationWithFillingValidData(NewUserRegistrationModel user) {
        JsonResponse postNewUser = authApiService.postNewUserReg(user);
        Assert.assertEquals(postNewUser.getStatusCode(), HttpStatus.SC_CREATED);
        NewUserRegistrationModel userFromDB = getClientByPhoneNumber(user.getMobilePhone());
        Assert.assertEquals(userFromDB.getMobilePhone(), user.getMobilePhone());
        Assert.assertEquals(userFromDB.getDocumentNumber(), user.getDocumentNumber());
        Assert.assertEquals(userFromDB.getEmail(), user.getEmail());
        deleteUserDataFromDb(user.getMobilePhone(), user.getDocumentNumber());
    }
}