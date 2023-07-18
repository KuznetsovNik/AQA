package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;

@Slf4j
public class RegistrationPage extends BasePage {

    private static final By PHONE_FIELD = By.xpath("//input[@name='telephone']");
    private static final By ERROR_MASSAGE_PHONE = By.xpath("//div[@data-testid = 'telephone-error-input-mask-formik']");
    private static final By SMS_CODE_FIELD = By.xpath("//input[@name='smsCode']");
    private static final By BUTTON_CONTINUE = By.xpath("//*[.='Продолжить']");
    private static final By BUTTON_COME_IN = By.xpath("//*[@class='button-s7wr8']");
    private static final By INVALID_SMS_CODE = By.xpath("//span[contains(text(),'Неверный код')]");
    private static final By INVALID_SMS_CODE_TEN_MINUTES = By.xpath("//span[contains(text(),'Вы сможете запросить код еще раз через 10 минут')]");
    private static final By NAME_FIELD = By.xpath("//input[@name='name']");
    private static final By PATRONYMIC_FIELD = By.xpath("//input[@name='patronymic']");
    private static final By SURNAME_FIELD = By.xpath("//input[@name='surname']");
    private static final By EMAIL_FIELD = By.xpath("//*[@name='email']");
    private static final By DATE_OF_BIRTH_FIELD = By.xpath("//*[@name='birthday']");
    private static final By PASSPORT_ID_FIELD = By.xpath("//input[@name='passport']");
    private static final By DATE_OF_ISSUE_PASSPORT_FIELD = By.xpath("//*[@name='datePassportIssue']");
    private static final By ERROR_MASSAGE_EMPTY_FIELD = By.xpath("//div[contains(text(),'Поле обязательно')]");
    private static final By ERROR_MASSAGE_NOT_CORRECT_EMAIL = By.xpath("//div[contains(text(),'Введены недопустимые символы')]");
    private static final By CREATE_PASSWORD = By.xpath("//*[@name='password']");
    private static final By CONFIRM_PASSWORD = By.xpath("//*[@name='confirmPassword']");
    private static final By ERROR_MASSAGE_PASSWORD = By.xpath("//div[@class='container-_8_FI' and contains(.,'Придумайте пароль')]/div[contains(.,'Пароль должен содержать')]");
    private static final By ERROR_MASSAGE_PASSWORD_NOT_MATCH = By.xpath("//div[@class='container-_8_FI' and contains(.,'Подтвердите пароль')]/div[contains(.,'Пароли не совпадают')]");
    private static final By BUTTON_DROPDOWN_QUESTIONS = By.xpath("//div[@class='container-_Adqw']");
    private static final By QUESTIONS_1 = By.xpath("//div[@class='selectedCard-qfeZI card-HZx01' and contains(.,'Девичья фамилия матери?')]");
    private static final By QUESTIONS_2 = By.xpath("//div[@class='card-HZx01' and contains(.,'Имя лучшего друга из детства?')]");
    private static final By QUESTIONS_3 = By.xpath("//div[@class='card-HZx01' and contains(.,'Какая ваша любимая книга?')]");
    private static final By QUESTIONS_4 = By.xpath("//div[@class='card-HZx01' and contains(.,'Какой ваш любимый цвет?')]");
    private static final By QUESTIONS_5 = By.xpath("//div[@class='card-HZx01' and contains(.,'Какое ваше любимое блюдо?')]");
    private static final By QUESTIONS_6 = By.xpath("//div[@class='card-HZx01' and contains(.,'Написать свой вопрос')]");
    private static final By WRITE_QUESTION = By.xpath("//*[@name='question']");
    private static final By WRITE_ANSWER = By.xpath("//*[@name='answer']");
    private static final By ERROR_QUESTION = By.xpath("//*[@data-testid='question-error-textarea-formik']");
    private static final By ERROR_QUESTION_SYMBOL = By.xpath("//span[contains(.,'Введены недопустимые символы.')]");
    private static final By ERROR_MASSAGE_INCORRECT_DATE = By.xpath("//div[contains(text(),'Некорректная дата')]");
    private static final By ERROR_MASSAGE_INVALID_DATE_BIRTH = By.xpath("//div[contains(text(),'Недопустимая дата')]");
    private static final By ERROR_MASSAGE_INVALID_DATE_ISSUE_PASSPORT = By.xpath("//div[contains(text(),' Введена недопустимая дата рождения')]");
    private static final By BUTTON_SLIDER_OFF = By.xpath("//label[@class='label-qXocP active-gCC9k']");
    private static final By BUTTON_SLIDER_ON = By.xpath("//label[@class='label-qXocP'] ");
    private static final By CLICK_REGISTRATION = By.xpath("//div[@class='title-YnVIS']");
    private static final By BUTTON_CLOSE = By.xpath("//button[@class='back-w0aMd']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickClose() {
        button.btnClick(BUTTON_CLOSE);
        return new LoginPage(drManager.getDriver());
    }

    public RegistrationPage acceptAlert() {
        alert.waitAndAcceptAlert();
        return this;
    }

    public boolean isButtonComeInClickable() {
        boolean result;
        if (button.checkButtonClickable(BUTTON_COME_IN)) result = true;
        else result = false;
        return result;
    }

    public boolean isButtonContinueRegistrationClickable() {
        boolean result;
        if (button.checkButtonClickable(BUTTON_CONTINUE)) result = true;
        else result = false;
        return result;
    }

    public boolean buttonContinueRegistrationClick() {
        try {
            button.clickWithoutWaitingClickable(BUTTON_CONTINUE);
            return true;
        } catch (ElementNotInteractableException exception) {
            return false;
        }
    }

    public String getValueOfField(RegistrationField field) {
        String text = null;
        if (field.equals(RegistrationField.PHONE)) {
            text = elementsAttributes.getAttrValue(PHONE_FIELD);
        } else if (field.equals(RegistrationField.CODE)) {
            text = elementsAttributes.getAttrValue(SMS_CODE_FIELD);
        } else if (field.equals(RegistrationField.SURNAME)) {
            text = elementsAttributes.getAttrValue(SURNAME_FIELD);
        } else if (field.equals(RegistrationField.NAME)) {
            text = elementsAttributes.getAttrValue(NAME_FIELD);
        } else if (field.equals(RegistrationField.PATRONYMIC)) {
            text = elementsAttributes.getAttrValue(PATRONYMIC_FIELD);
        } else if (field.equals(RegistrationField.EMAIL)) {
            text = elementsAttributes.getAttrValue(EMAIL_FIELD);
        } else if (field.equals(RegistrationField.BIRTHDAY)) {
            text = elementsAttributes.getAttrValue(DATE_OF_BIRTH_FIELD);
        } else if (field.equals(RegistrationField.PASSPORT)) {
            text = elementsAttributes.getAttrValue(PASSPORT_ID_FIELD);
        } else if (field.equals(RegistrationField.DATE_PASSPORT_ISSUER)) {
            text = elementsAttributes.getAttrValue(DATE_OF_ISSUE_PASSPORT_FIELD);
        } else if (field.equals(RegistrationField.PASSWORD)) {
            text = elementsAttributes.getAttrValue(CREATE_PASSWORD);
        } else if (field.equals(RegistrationField.CONFIRM_PASSWORD)) {
            text = elementsAttributes.getAttrValue(CONFIRM_PASSWORD);
        } else log.info("Поле с названием " + field + " не найдено");
        return text;
    }

    public RegistrationPage clickField(RegistrationField field) {
        if (field.equals(RegistrationField.PHONE)) {
            button.btnClick(PHONE_FIELD);
        } else if (field.equals(RegistrationField.CODE)) {
            button.btnClick(SMS_CODE_FIELD);
        } else if (field.equals(RegistrationField.SURNAME)) {
            button.btnClick(SURNAME_FIELD);
        } else if (field.equals(RegistrationField.NAME)) {
            button.btnClick(NAME_FIELD);
        } else if (field.equals(RegistrationField.PATRONYMIC)) {
            button.btnClick(PATRONYMIC_FIELD);
        } else if (field.equals(RegistrationField.EMAIL)) {
            button.btnClick(EMAIL_FIELD);
        } else if (field.equals(RegistrationField.BIRTHDAY)) {
            button.btnClick(DATE_OF_BIRTH_FIELD);
        } else if (field.equals(RegistrationField.PASSPORT)) {
            button.btnClick(PASSPORT_ID_FIELD);
        } else if (field.equals(RegistrationField.DATE_PASSPORT_ISSUER)) {
            button.btnClick(DATE_OF_ISSUE_PASSPORT_FIELD);
        } else log.info("Поле с названием " + field + " не найдено");
        return this;
    }

    public RegistrationPage inputPersonalData(RegistrationField field, String text) {
        if (field.equals(RegistrationField.PHONE)) {
            input.inputWithoutWaitClickable(PHONE_FIELD, text);
        } else if (field.equals(RegistrationField.CODE)) {
            input.inputWithoutWaitClickable(SMS_CODE_FIELD, text);
        } else if (field.equals(RegistrationField.SURNAME)) {
            input.inputWithoutWaitClickable(SURNAME_FIELD, text);
        } else if (field.equals(RegistrationField.NAME)) {
            input.inputWithoutWaitClickable(NAME_FIELD, text);
        } else if (field.equals(RegistrationField.PATRONYMIC)) {
            input.inputWithoutWaitClickable(PATRONYMIC_FIELD, text);
        } else if (field.equals(RegistrationField.EMAIL)) {
            input.inputWithoutWaitClickable(EMAIL_FIELD, text);
        } else if (field.equals(RegistrationField.BIRTHDAY)) {
            clickField(field);
            input.inputWithoutWaitClickable(DATE_OF_BIRTH_FIELD, text);
        } else if (field.equals(RegistrationField.PASSPORT)) {
            input.inputWithoutWaitClickable(PASSPORT_ID_FIELD, text);
        } else if (field.equals(RegistrationField.DATE_PASSPORT_ISSUER)) {
            clickField(field);
            input.inputWithoutWaitClickable(DATE_OF_ISSUE_PASSPORT_FIELD, text);
        } else if (field.equals(RegistrationField.PASSWORD)) {
            input.inputWithoutWaitClickable(CREATE_PASSWORD, text);
        } else if (field.equals(RegistrationField.CONFIRM_PASSWORD)) {
            input.inputWithoutWaitClickable(CONFIRM_PASSWORD, text);
        } else if (field.equals(RegistrationField.WRITE_QUESTION)) {
            input.inputWithoutWaitClickable(WRITE_QUESTION, text);
        } else if (field.equals(RegistrationField.WRITE_ANSWER)) {
            input.inputWithoutWaitClickable(WRITE_ANSWER, text);
        } else log.info("Поле с названием " + field + " не найдено");
        return this;
    }

    public RegistrationPage inputWithCustomClear(RegistrationField field, String text) {
        if (field.equals(RegistrationField.CODE)) {
            input.inputWithClear(SMS_CODE_FIELD, text);
        } else if (field.equals(RegistrationField.SURNAME)) {
            input.inputWithClear(SURNAME_FIELD, text);
        } else if (field.equals(RegistrationField.NAME)) {
            input.inputWithClear(NAME_FIELD, text);
        } else if (field.equals(RegistrationField.PATRONYMIC)) {
            input.inputWithClear(PATRONYMIC_FIELD, text);
        } else if (field.equals(RegistrationField.EMAIL)) {
            input.inputWithClear(EMAIL_FIELD, text);
        } else if (field.equals(RegistrationField.BIRTHDAY)) {
            input.inputWithClear(DATE_OF_BIRTH_FIELD, text);
        } else if (field.equals(RegistrationField.PASSPORT)) {
            input.inputWithClear(PASSPORT_ID_FIELD, text);
        } else if (field.equals(RegistrationField.DATE_PASSPORT_ISSUER)) {
            input.inputWithClear(DATE_OF_ISSUE_PASSPORT_FIELD, text);
        } else if (field.equals(RegistrationField.PASSWORD)) {
            input.inputWithClear(CREATE_PASSWORD, text);
        } else if (field.equals(RegistrationField.CONFIRM_PASSWORD)) {
            input.inputWithClear(CONFIRM_PASSWORD, text);
        } else if (field.equals(RegistrationField.WRITE_QUESTION)) {
            input.inputWithClear(WRITE_QUESTION, text);
        } else if (field.equals(RegistrationField.WRITE_ANSWER)) {
            input.inputWithClear(WRITE_ANSWER, text);
        } else log.info("Поле с названием " + field + " не найдено");
        return this;
    }

    public String getClassOfErrorTextEmptyField(RegistrationField field) {
        String class_name = null;
        if (field.equals(RegistrationField.SURNAME)
                | field.equals(RegistrationField.NAME)
                | field.equals(RegistrationField.PATRONYMIC)
                | field.equals(RegistrationField.EMAIL)
                | field.equals(RegistrationField.BIRTHDAY)
                | field.equals(RegistrationField.PASSPORT)
                | field.equals(RegistrationField.DATE_PASSPORT_ISSUER)
                | field.equals(RegistrationField.PASSWORD)) {
            class_name = elementsAttributes.getAttribute(ERROR_MASSAGE_EMPTY_FIELD, "class");
        } else log.info("Поле с названием " + field + " не найдено");
        return class_name;
    }

    int times = 0;

    public boolean isErrorMassageCodeVisible() {
        boolean result;
        if (times < 2) {
            if (elementsAttributes.isVisible(INVALID_SMS_CODE)) result = true;
            else result = false;
        } else {
            if (elementsAttributes.isVisible(INVALID_SMS_CODE_TEN_MINUTES)) result = true;
            else result = false;
        }
        times++;
        return result;
    }

    public String getClassOfErrorText(RegistrationField field) {
        String class_name = null;
        if (field.equals(RegistrationField.PHONE)) {
            class_name = elementsAttributes.getAttribute(ERROR_MASSAGE_PHONE, "class");
        } else if (field.equals(RegistrationField.EMAIL)) {
            class_name = elementsAttributes.getAttribute(ERROR_MASSAGE_NOT_CORRECT_EMAIL, "class");
        } else log.info("Поле с названием " + field + " не найдено");
        return class_name;
    }

    public String getClassOfErrorText(RegistrationField field, TypeOfErrorMassage type) {
        String class_name = null;
        if (field.equals(RegistrationField.BIRTHDAY)) {
            if (type.equals(TypeOfErrorMassage.INVALID_DATE)) {
                class_name = elementsAttributes.getAttribute(ERROR_MASSAGE_INVALID_DATE_BIRTH, "class");
            } else if (type.equals(TypeOfErrorMassage.INCORRECT_DATE)) {
                class_name = elementsAttributes.getAttribute(ERROR_MASSAGE_INCORRECT_DATE, "class");
            } else log.info("Тип ошибки " + type + " не найдено");
        }
        if (field.equals(RegistrationField.DATE_PASSPORT_ISSUER)) {
            if (type.equals(TypeOfErrorMassage.INVALID_DATE)) {
                class_name = elementsAttributes.getAttribute(ERROR_MASSAGE_INVALID_DATE_ISSUE_PASSPORT, "class");
            } else if (type.equals(TypeOfErrorMassage.INCORRECT_DATE)) {
                class_name = elementsAttributes.getAttribute(ERROR_MASSAGE_INCORRECT_DATE, "class");
            } else log.info("Тип ошибки " + type + " не найдено");
        }
        if (field.equals(RegistrationField.PASSWORD)) {
            if (type.equals(TypeOfErrorMassage.INCORRECT_CONTENT)) {
                class_name = elementsAttributes.getAttribute(ERROR_MASSAGE_PASSWORD, "class");
            } else if (type.equals(TypeOfErrorMassage.LINES_NOT_MATCH)) {
                class_name = elementsAttributes.getAttribute(ERROR_MASSAGE_PASSWORD_NOT_MATCH, "class");
            } else log.info("Тип ошибки " + type + " не найдено");
        }
        if (field.equals(RegistrationField.WRITE_QUESTION)) {
            if (type.equals(TypeOfErrorMassage.INVALID_SYMBOL)) {
                class_name = elementsAttributes.getAttribute(ERROR_QUESTION_SYMBOL, "class");
            } else if (type.equals(TypeOfErrorMassage.EXCESS_LENGTH)) {
                class_name = elementsAttributes.getAttribute(ERROR_QUESTION, "class");
            } else log.info("Тип ошибки " + type + " не найдено");
        } else log.info("Поле с названием " + field + " не найдено");
        return class_name;
    }

    public RegistrationPage clickButtonContinue() {
        button.btnClick(BUTTON_CONTINUE);
        return this;
    }

    public RegistrationPage clickOnPage() {
        button.btnClick(CLICK_REGISTRATION);
        return this;
    }

    public RegistrationPage clickQuestions1() {
        button.btnClick(BUTTON_DROPDOWN_QUESTIONS);
        button.btnClick(QUESTIONS_1);
        return this;
    }

    public RegistrationPage clickQuestions2() {
        button.btnClick(BUTTON_DROPDOWN_QUESTIONS);
        button.btnClick(QUESTIONS_2);
        return this;
    }

    public RegistrationPage clickQuestions3() {
        button.btnClick(BUTTON_DROPDOWN_QUESTIONS);
        button.btnClick(QUESTIONS_3);
        return this;
    }

    public RegistrationPage clickQuestions4() {
        button.btnClick(BUTTON_DROPDOWN_QUESTIONS);
        button.btnClick(QUESTIONS_4);
        return this;
    }

    public RegistrationPage clickQuestions5() {
        button.btnClick(BUTTON_DROPDOWN_QUESTIONS);
        button.btnClick(QUESTIONS_5);
        return this;
    }

    public RegistrationPage clickQuestions6() {
        button.btnClick(BUTTON_DROPDOWN_QUESTIONS);
        button.btnClick(QUESTIONS_6);
        return this;
    }

    public boolean isVisibleField() {
        try {
            elementsAttributes.isVisible(WRITE_QUESTION);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isVisibleField2() {
        try {
            elementsAttributes.isVisible(WRITE_ANSWER);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public RegistrationPage clickSliderOff() {
        button.btnClick(BUTTON_SLIDER_OFF);
        return this;
    }

    public RegistrationPage clickSliderOn() {
        button.btnClick(BUTTON_SLIDER_ON);
        return this;
    }

    public boolean isButtonPatronymic() {
        boolean result;
        if (button.checkButtonClickable(PATRONYMIC_FIELD)) result = true;
        else result = false;
        return result;
    }
}