package gor_ui.login_page.registration.personal_data;

import gor_ui.login_page.registration.BaseRegistrationPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationField;
import static common.consts.DataTest.ERROR_MASSAGE_EMPTY_FIELD;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Регистрация нового клиента")
public class SliderTest extends BaseRegistrationPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6173153" +
            "https://vmmreg32.testrail.net/index.php?/cases/view/6173154")
    @Description("Проверка на то что поле Отчество можно отключать и включать")
    public void checkPasswordSymbol() {
        openRegistrationAddDateNotPatronymic();
        Assert.assertEquals(registrationPage.getClassOfErrorTextEmptyField(RegistrationField.PATRONYMIC), ERROR_MASSAGE_EMPTY_FIELD);
        registrationPage.clickSliderOn();
        Assert.assertFalse(registrationPage.isButtonPatronymic());
        registrationPage.clickSliderOff();
        Assert.assertEquals(registrationPage.getClassOfErrorTextEmptyField(RegistrationField.PATRONYMIC), ERROR_MASSAGE_EMPTY_FIELD);
    }
}