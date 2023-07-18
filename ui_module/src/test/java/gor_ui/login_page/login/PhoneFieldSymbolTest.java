package gor_ui.login_page.login;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.NUMBER_PHONE_EMPTY;
import static common.consts.DataTest.SPECIAL_SYMBOL;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("VerhovaA")
@Story("Авторизация (вход в приложение)")
public class PhoneFieldSymbolTest extends BaseLoginPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6153411")
    @Description("Введенные в поле ввода телефона специальные символы не отображаются.")
    public void checkSymbolPhone() {
        openPhoneAndClickOnField();
        loginPage.inputLogin(SPECIAL_SYMBOL);
        Assert.assertEquals(loginPage.getValueOfPhoneField(), NUMBER_PHONE_EMPTY);
    }
}