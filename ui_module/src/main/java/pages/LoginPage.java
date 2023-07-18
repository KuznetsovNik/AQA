package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.awt.event.KeyEvent;

public class LoginPage extends BasePage {

    public static final By PHONE_TOGGLE = By.xpath("//*[.='По телефону']");
    public static final By PASSPORT_TOGGLE = By.xpath("//*[.='По документу']");
    public static final By BUTTON_GO = By.xpath("//button[@data-testid='continue-button']");
    public static final By BUTTON_ENTER = By.xpath("//button[contains(@class,'button-s7wr8')]");
    private static final By PHONE_FIELD_NON_ACTIVE = By.xpath("//input[@placeholder='Телефон']");
    private static final By PASSPORT_FIELD = By.xpath("//input[@type='passport']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@placeholder='Пароль']");
    private static final By ALERT_CAPS_LOCK_ON = By.xpath("//*[contains(text(), 'Включен CapsLock')]/parent::div");
    private static final By INVALID_LOGIN_OR_PASSWORD = By.xpath("//*[contains(text(), 'Неверный логин или пароль')]/parent::div");
    private static final By PASSPORT_SHORT_ALERT = By.xpath("//div[@class='document-form-white-TGY_R']/child::div[@class='error-d3B0f']");
    private static final By BUTTON_REGISTER = By.xpath("//*[.='Зарегистрироваться']");
    private static final By FORGET_PASSWORD = By.xpath("//a[text()='Забыли пароль?']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ForgetPasswordPage clickForgetPassword() {
        button.btnClick(FORGET_PASSWORD);
        return new ForgetPasswordPage(drManager.getDriver());
    }

    public MainPage clickButtonGo() {
        button.btnClick(BUTTON_GO);
        return new MainPage(drManager.getDriver());
    }

    public RegistrationPage clickButtonRegister() {
        button.btnClick(BUTTON_REGISTER);
        return new RegistrationPage(drManager.getDriver());
    }

    public MainPage mainPageInit() {
        return new MainPage(drManager.getDriver());
    }

    public LoginPage clickFieldLogin() {
        button.btnClick(PHONE_FIELD_NON_ACTIVE);
        return this;
    }

    public LoginPage inputLogin(String login) {
        input.inputWithoutWaitClickable(PHONE_FIELD_NON_ACTIVE, login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        input.inputWithoutWaitClickable(PASSWORD_FIELD, password);
        return this;
    }

    public LoginPage openPhone() {
        button.btnClick(PHONE_TOGGLE);
        return this;
    }

    public LoginPage inputPasswordWithCustomClear(String password) {
        input.inputWithClear(PASSWORD_FIELD, password);
        return this;
    }

    public LoginPage clickFieldPassword() {
        button.btnClick(PASSWORD_FIELD);
        return this;
    }

    public String addSymbolPassword(String password) {
        input.inputWithoutWaitClickable(PASSWORD_FIELD, password);
        return password;
    }

    public boolean checkButtonGoClickable() {
        try {
            return button.checkButtonClickable(BUTTON_GO);
        } catch (ElementNotInteractableException exception) {
            return false;
        }
    }

    public boolean isButtonEnterClickable() {
        try {
            return button.checkButtonClickable(BUTTON_ENTER);
        } catch (ElementNotInteractableException exception) {
            return false;
        }
    }

    public LoginPage addOneNumberToPhoneField(String oneNumber) {
        input.inputWithoutWaitClickable(PHONE_FIELD_NON_ACTIVE, oneNumber);
        return this;
    }

    public LoginPage addFourNumbersToPhoneField(String fourNumbers) {
        input.inputWithoutWaitClickable(PHONE_FIELD_NON_ACTIVE, fourNumbers);
        return this;
    }

    public String getValueOfPhoneField() {
        return elementsAttributes.getAttrValue(PHONE_FIELD_NON_ACTIVE);
    }

    public Boolean haveAlertCapsLockOn() {
        return elementsAttributes.isDisplayed(ALERT_CAPS_LOCK_ON);
    }

    public LoginPage inputLoginWithCustomClear(String login) {
        input.inputWithClear(PHONE_FIELD_NON_ACTIVE, login);
        return this;
    }

    public LoginPage clickPassportToggle() {
        button.btnClick(PASSPORT_TOGGLE);
        return this;
    }

    public LoginPage addOneNumberToPassportField(String oneNumber) {
        input.inputWithoutWaitClickable(PASSPORT_FIELD, oneNumber);
        return this;
    }

    public LoginPage addFourNumbersToPassportField(String fourNumbers) {
        input.inputWithoutWaitClickable(PASSPORT_FIELD, fourNumbers);
        return this;
    }

    public LoginPage inputPassportWithCustomClear(String passport) {
        input.inputWithClear(PASSPORT_FIELD, passport);
        return this;
    }

    public String getValueOfPasswordField() {
        return elementsAttributes.getAttrValue(PASSWORD_FIELD);
    }

    public String getClassOfPasswordField() {
        return elementsAttributes.getAttribute(INVALID_LOGIN_OR_PASSWORD, "class");
    }

    public LoginPage passwordFieldFastClick() {
        button.clickWithoutWaitingClickable(PASSWORD_FIELD);
        return this;
    }

    public LoginPage capsIsOn() {
        boolean isOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
        if (isOn == false) {
            Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
        } else {
            Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
            Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
        }
        return this;
    }

    public LoginPage inputSpecialSymbol(String specialSymbol) {
        input.inputWithoutWaitClickable(PASSWORD_FIELD, specialSymbol);
        return this;
    }

    public LoginPage openPassport() {
        button.btnClick(PASSPORT_TOGGLE);
        return this;
    }

    public LoginPage clickFieldPassport() {
        button.btnClick(PASSPORT_FIELD);
        return this;
    }

    public LoginPage inputPassport(String login) {
        input.inputWithoutWaitClickable(PASSPORT_FIELD, login);
        return this;
    }

    public String getValueOfPassportField() {
        return elementsAttributes.getAttrValue(PASSPORT_FIELD);
    }

    public String getNotEnoughCharactersAlert() {
        return elementsAttributes.getAttrInnerText(PASSPORT_SHORT_ALERT);
    }
}