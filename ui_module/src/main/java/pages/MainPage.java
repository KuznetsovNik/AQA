package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private static final By MAIN_PAGE = By.xpath("//*[.='Главная страница']");
    private static final By MAIN_PAGE_LOGOUT = By.xpath("//div[@class='logout-TbN6H']/child::*[name()='svg']");
    private static final By MAIN_PAGE_ALERT = By.xpath("//div[@class='cross-x3t_1']");
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean logo() {
        return elementsAttributes.isPresent(MAIN_PAGE);
    }

    public MainPage logout() {
        button.clickWithoutWaitingClickable(MAIN_PAGE_LOGOUT);
        return this;
    }

    public MainPage closeAlert(){
        button.clickWithoutWaitingClickable(MAIN_PAGE_ALERT);
        return this;
    }
}