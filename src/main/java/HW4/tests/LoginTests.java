package HW4.tests;

import HW4.pages.PlayerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import HW4.pages.LoginPage;
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
        loginPage.open();
        softAssert = new SoftAssert();
    }

    @DataProvider
    public Object[][] negativeLoginData() {
        return new Object[][] {
                {"admin", "1234", "Login", "Invalid username or password"},
                {"admin123", "123", "Login", "Invalid username or password"}
        };
    }
    @DataProvider
    public Object[][] nullLoginData() {
        return new Object[][] {
                {"", "", "Login", "Value is required and can't be empty"} };
    }
    @DataProvider
    public Object[][] positiveLoginData() {
        return new Object[][] {
                {"admin", "123", "Players"} };
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
    @Test(dataProvider = "negativeLoginData")
    public void negativeTestWrongPasssord(String username, String password, String title, String expectedMsg) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickOnLogin();
        String actualMsg = loginPage.getErrorMessage();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.URL_LOGIN, "You are NOT on login page.");
        softAssert.assertEquals(driver.getTitle(), title, "Wrong title after unsuccessful login");
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
    @Test(dependsOnMethods = "negativeTestWrongPasssord", alwaysRun = true, dataProvider = "negativeLoginData")
    public void negativeTestWrongLogin(String username, String password, String title, String expectedMsg) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickOnLogin();
        String actualMsg = loginPage.getErrorMessage();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.URL_LOGIN, "You are NOT on login page.");
        softAssert.assertEquals(driver.getTitle(), title, "Wrong title after unsuccessful login");
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
    @Test(dependsOnMethods = "negativeTestWrongLogin", alwaysRun = true, dataProvider = "nullLoginData")
    public void negativeTestEmptyFields(String username, String password, String title, String expectedMsg) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickOnLogin();
        String actualMsg = loginPage.getErrorMessage();
        softAssert.assertEquals(driver.getCurrentUrl(), LoginPage.URL_LOGIN, "You are NOT on login page.");
        softAssert.assertEquals(driver.getTitle(), title, "Wrong title after unsuccessful login");
        softAssert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
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
    @Test(dependsOnMethods = "negativeTestEmptyFields", alwaysRun = true, dataProvider = "positiveLoginData")
    public void positiveTest(String username, String password, String title) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickOnLogin();
        softAssert.assertEquals(driver.getTitle(), title, "Wrong title after login");
        softAssert.assertEquals(driver.getCurrentUrl(), PlayerPage.URL_PLAYERS, "Wrong url.");
        softAssert.assertEquals(driver.getCurrentUrl(), PlayerPage.URL_PLAYERS, "You are still on login page.");
        softAssert.assertAll();
    }

    @AfterTest
    public void afterTest() {driver.quit();}
}