package HW4.tests;

import HW4.pages.CreatePlayerPage;
import HW4.pages.EditPlayerPage;
import HW4.pages.LoginPage;
import HW4.pages.PlayerPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class CRUDUserTests {

    private WebDriver driver;
    private PlayerPage playerPage;
    private SoftAssert softAssert;

    public final String randomValue = RandomStringUtils.randomAlphanumeric(8);
    public final String email = randomValue + "@gmail.com";
    public final String userName = randomValue;
    public final String firstName = RandomStringUtils.randomAlphanumeric(8);
    public final String lastName = RandomStringUtils.randomAlphanumeric(8);
    public final String city = RandomStringUtils.randomAlphanumeric(8);
    public final String address = RandomStringUtils.randomAlphanumeric(8);
    public final String phone = RandomStringUtils.randomNumeric(8);
    //variables for edit player
    public final String newRandomValue = RandomStringUtils.randomAlphanumeric(9);
    public final String newEmail = newRandomValue + "@gmail.com";
    public final String newFirstName = RandomStringUtils.randomAlphanumeric(9);
    public final String newLastName = RandomStringUtils.randomAlphanumeric(9);
    public final String newCity = RandomStringUtils.randomAlphanumeric(9);
    public final String newAddress = RandomStringUtils.randomAlphanumeric(9);
    public final String newPhone = RandomStringUtils.randomNumeric(9);

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        playerPage = loginPage.login("admin", "123");
    }

    @BeforeMethod
    public void beforeMethod() {
        playerPage.open();
        softAssert = new SoftAssert();
    }

    @DataProvider
    public Object[][] createUserData() {
        return new Object[][] {
                { userName, email, randomValue, firstName, lastName,
                        city, address, phone}
        };
    }

    @DataProvider
    public Object[][] searchAndPreviewPlayerData() {
        return new Object[][] {
                { userName}
        };
    }
    @DataProvider
    public Object[][] editPlayerData() {
        return new Object[][] {
                { userName, newEmail, newFirstName, newLastName,
                        newCity, newAddress, newPhone}
        };
    }
    @DataProvider
    public Object[][] deletePlayerData() {
        return new Object[][] {
                { userName}
        };
    }

    /**
     * Steps:
     * 1. Open Insert page.
     * 2. Fill all required fields with random values.
     * 3. Click on Save button.
     * 4. Check title.
     * 5. Verify url.
     */
    @Test(dataProvider = "createUserData")
    public void createUserTest(String userName, String email, String randomValue, String firstName, String lastName,
                               String city, String address, String phone) {
        CreatePlayerPage createPlayerPage = playerPage.clickOnInsert();
        softAssert.assertEquals(driver.getCurrentUrl(), CreatePlayerPage.URL_INSERT, "You are NOT on insert page.");
        softAssert.assertEquals(driver.getTitle(), "Players - Insert", "Wrong title after click Insert btn");
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
        softAssert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful user creating");
        softAssert.assertEquals(driver.getCurrentUrl(), PlayerPage.URL_PLAYERS, "You are NOT on players page.");
        softAssert.assertAll();
    }

    /**
     * Steps:
     * 1. Perform search by user name.
     * 2. Click on edit button near user name.
     * 3. Check all user name fields.
     */
    @Test(dependsOnMethods = "createUserTest", alwaysRun = true, dataProvider = "searchAndPreviewPlayerData")
    public void searchAndPreviewPlayerTest(String userName){
        playerPage.setPlayerNameInSearchField(userName);
        playerPage.clickOnSearch();
        softAssert.assertEquals(driver.getCurrentUrl(), PlayerPage.URL_PLAYERS, "You are NOT on players page.");
        softAssert.assertEquals(driver.getTitle(), "Players", "Wrong title after unsuccessful user searching");
        EditPlayerPage editPlayerPage = playerPage.clickOnEditBtnNear(userName);
        softAssert.assertEquals(driver.getTitle(), "Players - Edit", "Wrong title after unsuccessful edit btn click");

        softAssert.assertEquals(editPlayerPage.getEmail(), email, "email does not match");
        softAssert.assertEquals(editPlayerPage.getFirstName(), firstName, "first name matches");
        softAssert.assertEquals(editPlayerPage.getLastName(), lastName, "last name matches");
        softAssert.assertEquals(editPlayerPage.getCity(), city, "city does not match");
        softAssert.assertEquals(editPlayerPage.getAddress(), address, "address matches");
        softAssert.assertEquals(editPlayerPage.getPhone(), phone, "phone does not match");
        softAssert.assertAll();
    }

    /**
     * Steps:
     * 1. Perform search by user name.
     * 2. Click on edit button near user name.
     * 3. Edit all fields with new data.
     * 4. Save changes.
     * 5. Preview changes.
     */
    @Test(dependsOnMethods = "searchAndPreviewPlayerTest", alwaysRun = true, dataProvider = "editPlayerData")
    public void editPlayerTest(String userName, String newEmail, String newFirstName, String newLastName,
                               String newCity, String newAddress, String newPhone){
        playerPage.setPlayerNameInSearchField(userName);
        playerPage.clickOnSearch();
        EditPlayerPage editPlayerPage = playerPage.clickOnEditBtnNear(userName);
        editPlayerPage.setNewEmail(newEmail);
        editPlayerPage.setNewFirstName(newFirstName);
        editPlayerPage.setNewLastName(newLastName);
        editPlayerPage.setNewCity(newCity);
        editPlayerPage.setNewAddress(newAddress);
        editPlayerPage.setNewPhone(newPhone);
        editPlayerPage.clickNewSaveButton();
    }

    /**
     * Steps:
     * 1. Perform search by user name.
     * 2. Click on delete button near user name. Confirm.
     * 3. Perform search.
     * 4. Verify that system was not found any user with current user name.
     */
    @Test(dependsOnMethods = "editPlayerTest", alwaysRun = true, dataProvider = "deletePlayerData")
    public void deletePlayerTest(String userName) {
        playerPage.setPlayerNameInSearchField(userName);
        playerPage.clickOnSearch();
        playerPage.clickOnDeleteBtnNear(userName);
        playerPage.webDriverWaitAndAlert();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
