package HW3.tests;

import HW3.pages.CreatePlayerPage;
import HW3.pages.PlayerPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HW3.pages.LoginPage;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SearchTests {

    private WebDriver driver;
    public PlayerPage playerPage;
    private SoftAssert softAssert;

    public final String randomValue = RandomStringUtils.randomAlphanumeric(8);
    public final String email = randomValue + "@gmail.com";
    public final String userName = randomValue;
    public final String firstName = RandomStringUtils.randomAlphanumeric(8);
    public final String lastName = RandomStringUtils.randomAlphanumeric(8);
    public final String city = RandomStringUtils.randomAlphanumeric(8);
    public final String address = RandomStringUtils.randomAlphanumeric(8);
    public final String phone = RandomStringUtils.randomNumeric(8);

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        playerPage = loginPage.login("admin", "123");
        CreatePlayerPage createPlayerPage = new CreatePlayerPage(driver);
        playerPage.clickOnInsert();
        createPlayerPage.setUserName(userName);
        createPlayerPage.setEmail(email);
        createPlayerPage.setPassword(randomValue);
        createPlayerPage.setConfirmPassword(randomValue);
        createPlayerPage.setFirstName(firstName);
        createPlayerPage.setLastName(lastName);
        createPlayerPage.setCity(city);
        createPlayerPage.setAddress(address);
        createPlayerPage.setPhone(phone);
        createPlayerPage.clickOnSave();
    }

    @BeforeMethod
    public void beforeMethod() { softAssert = new SoftAssert();}

    @Test
    public void performSearchByFirstName() {
        playerPage.performSearchByFirstName(firstName);
        playerPage.clickOnSearch();
        softAssert.assertEquals(playerPage.getNumberOfUsersWith(userName), 1, "Search by first name is not working.");
        softAssert.assertAll();
    }

    /**
     * Steps:
     * 1. To fill a value in Player field. Click Search bnt and Reset btn
     * 2. To fill a value in Email field. Click Search bnt and Reset btn
     * 3. To fill a value in City field. Click Search bnt and Reset btn
     * 4. To fill a value in Reg Data From field. Click Search bnt and Reset btn
     * 5. To fill a value in First name field. Click Search bnt and Reset btn
     * 6. To fill a value in Last name field. Click Search bnt and Reset btn
     * 7. To fill a value in Reg Data Till field. Click Search bnt and Reset btn
     */
    @Test
    public void searchPlayerByFilterFields(){

        playerPage.performSearchByEmail(email);
        playerPage.clickOnSearch();
        playerPage.clickOnResetBtn();

        playerPage.performSearchByCity(city);
        playerPage.clickOnSearch();
        playerPage.clickOnResetBtn();

        playerPage.performSearchByFromRegDate("13-12-2016");//todo: change date to real dae of user creation (current date)
        playerPage.clickOnSearch();
        playerPage.clickOnResetBtn();

        playerPage.performSearchByFirstName(firstName);
        playerPage.clickOnSearch();
        playerPage.clickOnResetBtn();

        playerPage.performSearchByLastName(lastName);
        playerPage.clickOnSearch();
        playerPage.clickOnResetBtn();

        playerPage.performSearchByTillRegDate("13-12-2016");//todo: change date to real dae of user creation (current date)
        playerPage.clickOnSearch();
        playerPage.clickOnResetBtn();
        softAssert.assertAll();

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}