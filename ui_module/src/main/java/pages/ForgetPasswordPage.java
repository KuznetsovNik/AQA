package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordPage extends LoginPage {

    private static final By PASSPORT_FIELD_RECOVER_PASSWORD = By.xpath("//input[@name='passport']");
    private static final By BUTTON_CONTINUE = By.xpath("//button[contains(text(),'Продолжить')]");
    private static final By BUTTON_BACK = By.xpath("//button[@class='back-w0aMd']");
    private static final By RECOVER_PASSWORD = By.xpath("//*[.='Восстановление пароля']");
    private static final By ERROR_PASSPORT_SHORT = By.xpath("//*[.='Недостаточно символов']");
    private static final By ENTER_SMS_CODE = By.xpath("//input[@name='smsCode']");
    private static final By CREATE_PASSWORD = By.xpath("//input[@placeholder='Придумайте пароль']");
    private static final By CONFIRM_PASSWORD = By.xpath("//input[@placeholder='Подтвердите пароль']");
    private static final By ERROR_MASSAGE_WRONG_PASSWORD = By.xpath("//div[@class='container-_8_FI' and contains(.,'Придумайте пароль')]/div[contains(.,'Пароль должен содержать')]");
    private static final By ERROR_MASSAGE_PASSWORD_NOT_MATCH = By.xpath("//div[@class='container-_8_FI' and contains(.,'Подтвердите пароль')]/div[contains(.,'Пароли не совпадают')]");
    private static final By ERROR_MASSAGE_CODE_2_TIMES = By.xpath("//div[@class='container-Kmz3e' and contains(.,'Неверный код')]");
    private static final By ERROR_MASSAGE_CODE_3_TIMES = By.xpath("//div[@class='container-Kmz3e' and contains(.,'Слишком много неудачных попыток')]");
    private static final By ERROR_MASSAGE_USER = By.xpath("//div[@class='error-n1TVM']");
    private static final By ERROR_MASSAGE_NOT_HAVE_PASSPORT = By.xpath("//*[contains(text(),'Пользователь с таким номером паспорта')]");

    public ForgetPasswordPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickClose() {
        button.btnClick(BUTTON_BACK);
        return new LoginPage(drManager.getDriver());
    }
    public ForgetPasswordPage clickOnPage() {
        button.btnClick(RECOVER_PASSWORD);
        return this;
    }

    public ForgetPasswordPage clickPassport() {
        button.btnClick(PASSPORT_FIELD_RECOVER_PASSWORD);
        return this;
    }

    public ForgetPasswordPage inputFieldPassport(String login) {
        input.inputWithoutWaitClickable(PASSPORT_FIELD_RECOVER_PASSWORD, login);
        return this;
    }

    public boolean isButtonContinueClickable() {
        return button.checkButtonClickable(BUTTON_CONTINUE);
    }


    public ForgetPasswordPage clickBack() {
        button.btnClick(BUTTON_BACK);
        return this;
    }

    public ForgetPasswordPage clickOnRecoverPassword() {
        button.btnClick(RECOVER_PASSWORD);
        return this;
    }

    public ForgetPasswordPage clearPassport(String passport) {
        input.inputWithClear(PASSPORT_FIELD_RECOVER_PASSWORD, passport);
        return this;
    }

    public String getValuePassportField() {
        return elementsAttributes.getAttrValue(PASSPORT_FIELD_RECOVER_PASSWORD);
    }

    public ForgetPasswordPage inputData(String string) {
        input.inputWithoutWaitClickable(PASSPORT_FIELD_RECOVER_PASSWORD, string);
        return this;
    }

    public ForgetPasswordPage clickContinue() {
        button.btnClick(BUTTON_CONTINUE);
        return this;
    }

    public ForgetPasswordPage acceptAlert() {
        alert.waitAndAcceptAlert();
        return this;
    }

    public ForgetPasswordPage clickSmsCode() {
        button.btnClick(ENTER_SMS_CODE);
        return this;
    }

    public LoginPage clearSmsCode(String sms) {
        input.inputWithClear(ENTER_SMS_CODE, sms);
        return this;
    }

    public ForgetPasswordPage inputSmsCode(String smsCode) {
        input.inputWithoutWaitClickable(ENTER_SMS_CODE, smsCode);
        return this;
    }

    public String getValueSmsField() {
        return elementsAttributes.getAttrValue(ENTER_SMS_CODE);
    }

    public ForgetPasswordPage inputNewPassword(String password) {
        input.inputWithoutWaitClickable(CREATE_PASSWORD, password);
        return this;
    }

    public ForgetPasswordPage confirmNewPassword(String password) {
        input.inputWithoutWaitClickable(CONFIRM_PASSWORD, password);
        return this;
    }

    public String getClassErrorMassageText() {
        return elementsAttributes.getAttribute(ERROR_MASSAGE_WRONG_PASSWORD, "class");
    }

    public LoginPage clearNewPassword(String password) {
        input.inputWithClear(CREATE_PASSWORD, password);
        return this;
    }

    public LoginPage clearConfirmPassword(String password) {
        input.inputWithClear(CONFIRM_PASSWORD, password);
        return this;
    }

    public String getValueOfNewPasswordField() {
        return elementsAttributes.getAttrValue(CREATE_PASSWORD);
    }

    public String getValueOfNewConfirmPasswordField() {
        return elementsAttributes.getAttrValue(CONFIRM_PASSWORD);
    }

    public String getClassErrorMassageTextPasswordNotMatch() {
        return elementsAttributes.getAttribute(ERROR_MASSAGE_PASSWORD_NOT_MATCH, "class");
    }

    public String getClassErrorMassageSmsCode() {
        return elementsAttributes.getAttribute(ERROR_MASSAGE_CODE_2_TIMES, "class");
    }

    public String getClassErrorMassageSmsCode1() {
        return elementsAttributes.getAttribute(ERROR_MASSAGE_CODE_3_TIMES, "class");
    }

    public String getClassErrorMassageUser() {
        return elementsAttributes.getAttribute(ERROR_MASSAGE_USER, "class");
    }

    public String getClassErrorPassportShort() {
        return elementsAttributes.getAttribute(ERROR_PASSPORT_SHORT, "class");
    }

    public String getClassErrorNotHavePassport(){
        return elementsAttributes.getAttribute(ERROR_MASSAGE_NOT_HAVE_PASSPORT, "class");
    }
}