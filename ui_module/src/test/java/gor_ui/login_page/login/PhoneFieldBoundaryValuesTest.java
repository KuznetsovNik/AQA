package gor_ui.login_page.login;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static common.consts.DataTest.*;

@Epic("Регистрация/Авторизация/Безопасность (WEB)")
@Owner("BakuninAV")
@Story("Проверка граничных значений поля ввода телефона")
public class PhoneFieldBoundaryValuesTest extends BaseLoginPage {

    @Test(groups = {"regression"})
    @TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/5994510")
    @Description("Проверка граничных значений для поля ввода номера телефона")
    public void phoneBoundaryValues() {
        openPhoneAndClickOnField();
        loginPage.inputPassword(VALID_PASSPORT_PASSWORD);
        loginPage.clickFieldLogin();
        Assert.assertFalse(loginPage.checkButtonGoClickable());
        loginPage.addOneNumberToPhoneField(ONE_NUMBER);
        Assert.assertFalse(loginPage.checkButtonGoClickable());
        loginPage.addFourNumbersToPhoneField(FOUR_NUMBERS);
        Assert.assertFalse(loginPage.checkButtonGoClickable());
        loginPage.addFourNumbersToPhoneField(FOUR_NUMBERS);
        Assert.assertFalse(loginPage.checkButtonGoClickable());
        loginPage.addOneNumberToPhoneField(ONE_NUMBER);
        Assert.assertTrue(loginPage.checkButtonGoClickable());
        loginPage.inputLoginWithCustomClear(BIG_NUMBER_PHONE);
        Assert.assertEquals(loginPage.getValueOfPhoneField(), VALID_PHONE_NUMBER_VALUE);
    }
}