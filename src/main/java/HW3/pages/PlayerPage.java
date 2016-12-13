package HW3.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlayerPage {

    private WebDriver driver;
    public static final String URL_PLAYERS = "http://80.92.229.236:81/players";

    public PlayerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL_PLAYERS);
    }

    public void setPlayerNameInSearchField(String userName) {
        WebElement searchFieldInput = driver.findElement(By.id("723a925886__login"));
        searchFieldInput.clear();
        searchFieldInput.sendKeys(userName);
    }

    public void clickOnSearch() {
        WebElement searchButton = driver.findElement(By.xpath(".//input[@name='search' and @type='button']"));
        searchButton.click();
    }

    public CreatePlayerPage clickOnInsert() {
        driver.findElement(By.xpath(".//img[@alt='Insert']")).click();
        return new CreatePlayerPage(driver);
    }

    public EditPlayerPage clickOnEditBtnNear(String userName) {
        WebElement editButton = driver.findElement(By.xpath(".//tr[.//a[text()='" + userName + "']]//img[@alt='Edit']"));
        editButton.click();
        return new EditPlayerPage(driver);
    }

    public void clickOnResetBtn(){
        WebElement resetButton = driver.findElement(By.xpath(".//*[@name='reset']"));
        resetButton.click();
    }

    public void performSearchByEmail(String email) {
        WebElement emailInput = driver.findElement(By.xpath(".//*[@id='723a925886__email']"));
        emailInput.sendKeys(email);
    }

    public void performSearchByCity(String city) {
        WebElement cityInput = driver.findElement(By.xpath(".//*[@id='723a925886__city']"));
        cityInput.sendKeys(city);
    }

    public void performSearchByFromRegDate(String date) {
        WebElement fromRegDateInput = driver.findElement(By.xpath(".//*[@id='723a925886__reg_date_from']"));
        fromRegDateInput.sendKeys(date);
    }

    public void performSearchByFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(By.xpath(".//*[@id='723a925886__firstname']"));
        firstNameInput.sendKeys(firstName);
    }

    public void performSearchByLastName(String lastName) {
        WebElement lastNameInput = driver.findElement(By.xpath(".//*[@id='723a925886__lastname']"));
        lastNameInput.sendKeys(lastName);
    }

    public void performSearchByTillRegDate(String date) {
        WebElement tillRegDateInput = driver.findElement(By.xpath(".//*[@id='723a925886__reg_date_to']"));
        tillRegDateInput.sendKeys(date);
    }

    public void clickOnDeleteBtnNear(String userName) {
        WebElement deleteButton = driver.findElement(By.xpath(".//tr[.//a[text()='" + userName + "']]//img[@alt='Delete']"));
        deleteButton.click();
    }

    public int getNumberOfUsersWith(String userName) {
        return driver.findElements(By.xpath(".//tr[.//a[text()='" + userName + "']]")).size();
    }
    public void webDriverWaitAndAlert(){
        WebDriverWait wait = new WebDriverWait(driver, 20, 100);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
