package HW3.tests;

import HW3.pages.PlayerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HW3.pages.LoginPage;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private SoftAssert softAssert;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Preconditions:
     * Open application Login Page URL
     */
    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver);
        loginPage.open(); //open poker URL
        softAssert = new SoftAssert();
    }

    /**
     * Steps:
     * 1. Set "admin" to username field
     * 2. Set "12345" to password field
     * 3. Click Login button
     * 4. Assign to "expectedMsg" variable "Invalid username or password" value
     * 5. Assign to actualMsg getErrorMessage method
     * 6. Verify that URL equals to Login Page URL
     * 7. Verify that title of the page equals to "Login"
     * 8. Verify actualMsg and expectedMsg
     * */
    @Test
    public void negativeTestWrongPasssord() {
        loginPage.setUsername("admin");
        loginPage.setPassword("12345");
        loginPage.clickOnLogin();
        String expectedMsg = "Invalid username or password";
        String actualMsg = loginPage.getErrorMessage();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.URL_LOGIN, "You are NOT on login page.");
        softAssert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
        softAssert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
        softAssert.assertAll();
    }
    /**
     * Steps:
     * 1. Set "admin123" to username field
     * 2. Set "123" to password field
     * 3. Click Login button
     * 4. Assign to "expectedMsg" variable "Invalid username or password" value
     * 5. Assign to actualMsg getErrorMessage method
     * 6. Verify that URL equals to Login Page URL
     * 7. Verify that title of the page equals to "Login"
     * 8. Verify actualMsg and expectedMsg
     * */
    @Test
    public void negativeTestWrongLogin() {
        loginPage.setUsername("admin123");
        loginPage.setPassword("123");
        loginPage.clickOnLogin();
        String expectedMsg = "Invalid username or password";
        String actualMsg = loginPage.getErrorMessage();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.URL_LOGIN, "You are NOT on login page.");
        softAssert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
        softAssert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
        softAssert.assertAll();

    }
    /**
     *Steps:
     * 1. Set "" to username field
     * 2. Set "" to password field
     * 3. Click Login button
     * 4. Assign to "expectedMsg" variable "Invalid username or password" value
     * 5. Assign to actualMsg getErrorMessage method
     * 6. Verify that URL equals to Login Page URL
     * 7. Verify that title of the page equals to "Login"
     * 8. Verify actualMsg and expectedMsg
     * */
    @Test
    public void negativeTestEmptyFields() {
        loginPage.setUsername("");
        loginPage.setPassword("");
        loginPage.clickOnLogin();
        String expectedEmailMsg = "Value is required and can't be empty";
        String expectedPasswordMsg = "Value is required and can't be empty";
        String actualEmailMsg = loginPage.getErrorMessageEmptyUsernameFields();
        String actualPasswordMsg = loginPage.getErrorMessageEmptyPasswordFields();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.URL_LOGIN, "You are NOT on login page.");
        softAssert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
        softAssert.assertEquals(actualEmailMsg, expectedEmailMsg, "Validation error message is not valid.");
        softAssert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "Validation error message is not valid.");
        softAssert.assertAll();

    }
    /**
     * Steps:
     * 1. Set "admin" to username field
     * 2. Set "123" to password field
     * 3. Click Login button
     * 4. Verify that URL equals to Login Page URL
     * 5. Verify that title of the page equals to "Login"
     * */
    @Test
    public void positiveTest() {
        loginPage.setUsername("admin");
        loginPage.setPassword("123");
        loginPage.clickOnLogin();
        softAssert.assertEquals(driver.getTitle(), "Players", "Wrong title after login");
        softAssert.assertEquals(driver.getCurrentUrl(), PlayerPage.URL_PLAYERS, "Wrong url.");
        softAssert.assertEquals(driver.getCurrentUrl(), PlayerPage.URL_PLAYERS, "You are still on login page.");
        softAssert.assertAll();
    }

    @AfterTest
    public void afterTest() {driver.quit();}
}