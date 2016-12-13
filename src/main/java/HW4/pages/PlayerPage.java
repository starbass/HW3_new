package HW4.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlayerPage {
    @FindBy(id = "723a925886__login")
    private WebElement searchFieldInput;
    @FindBy(xpath = ".//input[@name='search' and @type='button']")
    private WebElement searchButton;
    @FindBy(xpath = ".//*[@name='reset']")
    private WebElement resetButton;
    @FindBy(xpath = ".//*[@id='723a925886__email']")
    private WebElement emailInput;
    @FindBy(xpath = ".//*[@id='723a925886__city']")
    private WebElement cityInput;
    @FindBy(xpath = ".//*[@id='723a925886__reg_date_from']")
    private WebElement fromRegDateInput;
    @FindBy(xpath = ".//*[@id='723a925886__firstname']")
    private WebElement firstNameInput;
    @FindBy(xpath = ".//*[@id='723a925886__lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = ".//*[@id='723a925886__reg_date_to']")
    private WebElement tillRegDateInput;


    private WebDriver driver;
    public static final String URL_PLAYERS = "http://80.92.229.236:81/players";

    public PlayerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL_PLAYERS);
    }

    public void setPlayerNameInSearchField(String userName) {
        searchFieldInput.clear();
        searchFieldInput.sendKeys(userName);
    }

    public void clickOnSearch() {
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
        resetButton.click();
    }

    public void performSearchByEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void performSearchByCity(String city) {
        cityInput.sendKeys(city);
    }

    public void performSearchByFromRegDate(String date) {
        fromRegDateInput.sendKeys(date);
    }

    public void performSearchByFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void performSearchByLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void performSearchByTillRegDate(String date) {
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
