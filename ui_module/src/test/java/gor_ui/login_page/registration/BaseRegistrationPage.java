package gor_ui.login_page.registration;

import gor_ui.login_page.login.BaseLoginPage;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import pages.RegistrationField;
import static common.consts.DataTest.*;

public class BaseRegistrationPage extends BaseLoginPage {

    @Step("Открытие страницы регистрации и установка курсора в поле номер телефона")
    public void openRegistrationAndClickOnField() {
        brManager.reloadPage();
        loginPage.clickButtonRegister();
        registrationPage.clickField(RegistrationField.PHONE);
    }

    @Step("Ввожу валидные данные, нажимаю кнопку продолжить")
    public void openRegistrationAddPhoneClickContinue() {
        openRegistrationAndClickOnField();
        registrationPage.inputPersonalData(RegistrationField.PHONE, PHONE_NUMBER_VALUE_NEW);
        registrationPage.buttonContinueRegistrationClick();
        registrationPage.acceptAlert();
    }

    @Step("Ставлю курсор в поле 'Укажите код'")
    public void openRegistrationAndClickCodeField() {
        openRegistrationAddPhoneClickContinue();
        registrationPage.clickField(RegistrationField.CODE);
    }

    @Step("Ввожу валидный СМС код, нажимаю кнопку продолжить")
    public void openRegistrationAddCodeAndClickContinue() {
        openRegistrationAndClickCodeField();
        registrationPage.inputPersonalData(RegistrationField.CODE, VALID_SMS_CODE);
        registrationPage.buttonContinueRegistrationClick();
    }

    @Step("Ввожу все личные данные в поля для формы регистрации, нажимаю кнопку продолжить")
    public void openRegistrationAddAllDateAndClickContinue() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.SURNAME, VALID_SURNAME);
        registrationPage.inputPersonalData(RegistrationField.NAME, VALID_NAME);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, VALID_PATRONYMIC);
        registrationPage.inputPersonalData(RegistrationField.EMAIL, VALID_EMAIL);
        registrationPage.inputPersonalData(RegistrationField.BIRTHDAY, VALID_BIRTHDAY);
        registrationPage.clickField(RegistrationField.PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.PASSPORT, VALID_PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.DATE_PASSPORT_ISSUER, VALID_DATE_PASSPORT_ISSUER);
        registrationPage.buttonContinueRegistrationClick();
    }

    @Step("Ставлю курсор в поле Фамилии, но его не заполняю.Ввожу данные для остольных полей")
    public void openRegistrationAddDateNotSurname() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.clickField(RegistrationField.SURNAME);
        registrationPage.inputPersonalData(RegistrationField.NAME, VALID_NAME);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, VALID_PATRONYMIC);
        registrationPage.inputPersonalData(RegistrationField.EMAIL, VALID_EMAIL);
        registrationPage.inputPersonalData(RegistrationField.BIRTHDAY, VALID_BIRTHDAY);
        registrationPage.clickField(RegistrationField.PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.PASSPORT, VALID_PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.DATE_PASSPORT_ISSUER, VALID_DATE_PASSPORT_ISSUER);
    }

    @Step("Ставлю курсор в поле Имени, но его не заполняю.Ввожу данные для остольных полей")
    public void openRegistrationAddDateNotName() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.SURNAME, VALID_SURNAME);
        registrationPage.clickField(RegistrationField.NAME);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, VALID_PATRONYMIC);
        registrationPage.inputPersonalData(RegistrationField.EMAIL, VALID_EMAIL);
        registrationPage.inputPersonalData(RegistrationField.BIRTHDAY, VALID_BIRTHDAY);
        registrationPage.clickField(RegistrationField.PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.PASSPORT, VALID_PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.DATE_PASSPORT_ISSUER, VALID_DATE_PASSPORT_ISSUER);
    }

    @Step("Ставлю курсор в поле Отчества, но его не заполняю.Ввожу данные для остольных полей")
    public void openRegistrationAddDateNotPatronymic() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.clickField(RegistrationField.PATRONYMIC);
        registrationPage.inputPersonalData(RegistrationField.SURNAME, VALID_SURNAME);
        registrationPage.inputPersonalData(RegistrationField.NAME, VALID_NAME);
        registrationPage.inputPersonalData(RegistrationField.EMAIL, VALID_EMAIL);
        registrationPage.inputPersonalData(RegistrationField.BIRTHDAY, VALID_BIRTHDAY);
        registrationPage.clickField(RegistrationField.PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.PASSPORT, VALID_PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.DATE_PASSPORT_ISSUER, VALID_DATE_PASSPORT_ISSUER);
    }

    @Step("Ставлю курсор в поле паспорт, но его не заполняю.Ввожу данные для остольных полей")
    public void openRegistrationAddDateNotPassport() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.clickField(RegistrationField.PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.SURNAME, VALID_SURNAME);
        registrationPage.inputPersonalData(RegistrationField.NAME, VALID_NAME);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, VALID_PATRONYMIC);
        registrationPage.inputPersonalData(RegistrationField.EMAIL, VALID_EMAIL);
        registrationPage.inputPersonalData(RegistrationField.BIRTHDAY, VALID_BIRTHDAY);
        registrationPage.inputPersonalData(RegistrationField.DATE_PASSPORT_ISSUER, VALID_DATE_PASSPORT_ISSUER);
    }

    @Step("Ввели все личные данные в поля для формы регистрации,ввели новый пароль, нажали кнопку продолжить,")
    public void openRegistrationAddAllDateAndAddPasswordAndClickContinue() {
        openRegistrationAddAllDateAndClickContinue();
        registrationPage.inputPersonalData(RegistrationField.PASSWORD, NEW_PASSWORD);
        registrationPage.inputPersonalData(RegistrationField.CONFIRM_PASSWORD, NEW_CONFIRM_PASSWORD);
        registrationPage.clickButtonContinue();
    }

    @Step("Ставлю курсор в поле дата рождения, но его не заполняю.Ввожу данные для остольных полей")
    public void openRegistrationAddDateNotBirth() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.clickField(RegistrationField.BIRTHDAY);
        registrationPage.inputPersonalData(RegistrationField.SURNAME, VALID_SURNAME);
        registrationPage.inputPersonalData(RegistrationField.NAME, VALID_NAME);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, VALID_PATRONYMIC);
        registrationPage.inputPersonalData(RegistrationField.EMAIL, VALID_EMAIL);
        registrationPage.clickField(RegistrationField.PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.PASSPORT, VALID_PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.DATE_PASSPORT_ISSUER, VALID_DATE_PASSPORT_ISSUER);
    }

    @Step("Ставлю курсор в поле email, но его не заполняю.Ввожу данные для остольных полей")
    public void openRegistrationAddDateNotEmail() {
        openRegistrationAddCodeAndClickContinue();
        registrationPage.clickField(RegistrationField.EMAIL);
        registrationPage.inputPersonalData(RegistrationField.SURNAME, VALID_SURNAME);
        registrationPage.inputPersonalData(RegistrationField.NAME, VALID_NAME);
        registrationPage.inputPersonalData(RegistrationField.PATRONYMIC, VALID_PATRONYMIC);
        registrationPage.inputPersonalData(RegistrationField.BIRTHDAY, VALID_BIRTHDAY);
        registrationPage.clickField(RegistrationField.PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.PASSPORT, VALID_PASSPORT);
        registrationPage.inputPersonalData(RegistrationField.DATE_PASSPORT_ISSUER, VALID_DATE_PASSPORT_ISSUER);
    }
    
    @AfterMethod(alwaysRun = true)
    public void close() {
        brManager.reloadPage();
        registrationPage.clickClose();
    }
}
