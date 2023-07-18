package gor_ui;

import driver.BrowserManager;
import driver.DriverManager;
import driver.InitDriver;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import pages.ForgetPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.Navigation;
import pages.RegistrationPage;

@Slf4j
@Getter
public abstract class BaseTest {
    private WebDriver driver = InitDriver.initDriver("chrome");
    public LoginPage loginPage;
    public Navigation navigation;
    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public ForgetPasswordPage forgetPasswordPage;
    public DriverManager drManager;
    public BrowserManager brManager;


    public BaseTest() {
        managersInit();
        pagesInit();
    }

    private void managersInit() {
        this.drManager = new DriverManager(InitDriver.initDriver("chrome"));
        this.brManager = new BrowserManager(InitDriver.initDriver("chrome"));
        log.info("Driver manager created");
    }

    private void pagesInit() {
        loginPage = new LoginPage(driver);
        navigation = new Navigation(driver);
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        forgetPasswordPage = new ForgetPasswordPage(driver);
    }

    @AfterTest(alwaysRun = true)
    public void driverQuite() {
        brManager.quit();
        log.info("Driver closed");
    }
}