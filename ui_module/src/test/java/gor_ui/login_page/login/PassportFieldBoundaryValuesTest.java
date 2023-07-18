package gor_ui.login_page.login;

import common.config.AppConfigProvider;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("BakuninAV")
@Story("Проверка граничных значений поля ввода паспорта")

public class PassportFieldBoundaryValuesTest extends BaseLoginPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/5994509")
    @Description("Проверка граничных значений для поля ввода паспорта")
    public void passportBoundaryValues() {
        openPassportAndClickOnField();
        loginPage.inputPassword(VALID_PASSPORT_PASSWORD);
        Assert.assertFalse(loginPage.checkButtonGoClickable());
        loginPage.clickFieldPassport();
        loginPage.addOneNumberToPassportField(FIRST_VALUE_PASSPORT);
        Assert.assertFalse(loginPage.checkButtonGoClickable());
        loginPage.addFourNumbersToPassportField(NEXT_FOUR_VALUES_AFTER_FIRST_PASSPORT);
        Assert.assertFalse(loginPage.checkButtonGoClickable());
        loginPage.addFourNumbersToPassportField(NEXT_FOUR_VALUES_AFTER_FIVES_PASSPORT);
        Assert.assertFalse(loginPage.checkButtonGoClickable());
        loginPage.addFourNumbersToPassportField(LAST_VALUE_PASSPORT);
        Assert.assertTrue(loginPage.checkButtonGoClickable());
        loginPage.inputPassportWithCustomClear(TOO_BIG_PASSPORT);
        Assert.assertEquals(loginPage.getValueOfPassportField(), PASSPORT_VALID);
    }
}

