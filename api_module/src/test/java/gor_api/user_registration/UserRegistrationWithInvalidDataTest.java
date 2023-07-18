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

import java.util.Locale;

import static constant.DataConstants.NON_EXISTENT_DOC_TYPE;
import static constant.ErrorMessages.*;
import static constant.ParamsList.DETAIL;
import static constant.UserDataRowsConstants.*;
import static model.entity.NewUserRegistrationModel.*;

@Epic("EP 5.Регистрация не Клиента в приложении.")
@Owner("Румянцев Е.П.")
@Story("UserRegistration")
public class UserRegistrationWithInvalidDataTest extends BaseClass {

    NewUserRegistrationModel belUser = getExemplarWithRandomData(Location.BY, DocType.PASSPORT_BY);

    @DataProvider(name = "invalidCountryCode")
    public Object[][] getUserWithInvalidCountryCode() {
        return new Object[][] {
                {belUser, "123"}, {belUser, "авп"}, {belUser, "avp"}, {belUser, "#$%"}, {belUser, "ф в "}, {belUser, ""}
        };
    }

    @DataProvider(name = "invalidDocType")
    public Object[][] getUserWithInvalidDocType() {
        return new Object[][] {
                {belUser, "авп", INCORRECT_TYPE}, {belUser, "avp", INCORRECT_TYPE}, {belUser, "#$%", INCORRECT_TYPE},
                {belUser, "ф в ", INCORRECT_TYPE}, {belUser, "", NULL_VALUE_ERROR},
                {belUser, NON_EXISTENT_DOC_TYPE, "[\"Invalid pk \\\"" + NON_EXISTENT_DOC_TYPE + "\\\" - object does not exist.\"]"},
        };
    }

    @DataProvider(name = "invalidNationality")
    public Object[][] getUserWithInvalidNationality() {
        return new Object[][] {
                {belUser, "Aqaland"}, {belUser,"Кирилица"}, {belUser, "1234567890"}, {belUser, "%#$@*"}, {belUser, "Bela rus"},
                {belUser, ""}
        };
    }

    @Test(groups = {"regression"}, dataProvider = "invalidCountryCode")
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6379074&group_by=cases:section_id&group_id=1065170&group_order=asc&display_deleted_cases=0&group_by=cases:section_id&group_id=1065170&group_order=asc&display_deleted_cases=0&group_by=cases:section_id&group_id=1065170&group_order=asc&display_deleted_cases=0")
    @Description("Регистрация нового пользователя. Негативные проверки данных (код страны) в теле запроса.")
    public void regUserWithInvalidCountryCode(NewUserRegistrationModel user, String changingValue) {
        user.setCountryCode(changingValue);
        JsonResponse postNewUser = authApiService.postNewUserReg(user);
        Assert.assertEquals(postNewUser.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(postNewUser.getJsonObject().get(COUNTRY_CODE).toString(),
                "[\"\\\"" + user.getCountryCode() + "\\\" is not a valid choice.\"]");
    }

    @Test(groups = {"regression"}, dataProvider = "invalidDocType")
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6379233&group_by=cases:section_id&group_id=1065170&group_order=asc&display_deleted_cases=0&group_by=cases:section_id&group_id=1065170&group_order=asc&display_deleted_cases=0")
    @Description("Регистрация нового пользователя. Негативные проверки данных (тип документа) в теле запроса.")
    public void regUserWithInvalidDocType(NewUserRegistrationModel user, String changingValue, String errorMessage) {
        user.setDocType(changingValue);
        JsonResponse postNewUserWithInvalidDocType = authApiService.postNewUserReg(user);
        Assert.assertEquals(postNewUserWithInvalidDocType.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(postNewUserWithInvalidDocType.getJsonObject().get(DOC_TYPE).toString(), errorMessage);
    }

    @Test(groups = {"regression"}, dataProvider = "invalidNationality")
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6384012&group_by=cases:section_id&group_id=1065170&group_order=asc&display_deleted_cases=0")
    @Description("Регистрация нового пользователя. Негативные проверки данных (национальность) в теле запроса.")
    public void regUserWithInvalidNationality(NewUserRegistrationModel user, String changingValue) {
        user.setNationality(changingValue);
        JsonResponse postNewUser = authApiService.postNewUserReg(user);
        Assert.assertEquals(postNewUser.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(postNewUser.getJsonObject().get(NATIONALITY).toString(),
                "[\"\\\"" + user.getNationality().toLowerCase(Locale.ROOT) + "\\\" is not a valid choice.\"]");
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6386122&group_by=cases:section_id&group_id=1065170&group_order=asc&display_deleted_cases=0")
    @Description("Регистрация нового пользователя. Негативные проверки данных (пустые значения) в теле запроса.")
    public void regUserWithEmptyRows() {
        JsonResponse postNewUser = authApiService.postNewUserReg(getExemplarWithEmptyFields(DocType.PASSPORT_BY));
        Assert.assertEquals(postNewUser.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(postNewUser.getJsonObject().get(FIRST_NAME).toString(), NULL_VALUE_ERROR);
        Assert.assertEquals(postNewUser.getJsonObject().get(LAST_NAME).toString(), NULL_VALUE_ERROR);
        Assert.assertEquals(postNewUser.getJsonObject().get(PATRONYMIC).toString(), NULL_VALUE_ERROR);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6386511&group_by=cases:section_id&group_id=1065170&group_order=asc&display_deleted_cases=0")
    @Description("Попытка отправить запрос на регистрацию пользователя без тела запроса.")
    public void regUserWithoutBody() {
        JsonResponse postNewUser = authApiService.postNewUserRegWithoutBody();
        Assert.assertEquals(postNewUser.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6386189&group_by=cases:section_id&group_id=1065170&group_order=asc&display_deleted_cases=0")
    @Description("Попытка отправить запрос на регистрацию пользователя невалидными методами.")
    public void regUserWithInvalidRequestMethod() {
        NewUserRegistrationModel user = getExemplarWithRandomData(Location.RU, DocType.PASSPORT_RU);
        JsonResponse getNewUser = authApiService.getNewUserReg(user);
        Assert.assertEquals(getNewUser.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);
        Assert.assertEquals(getNewUser.getJsonObject().get(DETAIL), METHOD_NOT_ALLOWED);
        JsonResponse putNewUser = authApiService.putNewUserReg(user);
        Assert.assertEquals(putNewUser.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);
        Assert.assertEquals(putNewUser.getJsonObject().get(DETAIL), METHOD_NOT_ALLOWED);
        JsonResponse patchNewUser = authApiService.patchNewUserReg(user);
        Assert.assertEquals(patchNewUser.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);
        Assert.assertEquals(patchNewUser.getJsonObject().get(DETAIL), METHOD_NOT_ALLOWED);
        JsonResponse deleteNewUser = authApiService.deleteNewUserReg();
        Assert.assertEquals(deleteNewUser.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);
        Assert.assertEquals(deleteNewUser.getJsonObject().get(DETAIL), METHOD_NOT_ALLOWED);
    }
}