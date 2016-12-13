package HW4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePlayerPage {
    @FindBy(id = "ff14642ac1c__us_login")
    private WebElement userNameInput;
    @FindBy(id = "ff14642ac1c__us_email")
    private WebElement emailInput;
    @FindBy(id = "ff14642ac1c__us_password")
    private WebElement passwInput;
    @FindBy(id = "ff14642ac1c__confirm_password")
    private WebElement confirmPasswordInput;
    @FindBy(id = "ff14642ac1c__us_fname")
    private WebElement firstNameInput;
    @FindBy(id = "ff14642ac1c__us_lname")
    private WebElement lastNameInput;
    @FindBy(id = "ff14642ac1c__us_city")
    private WebElement cityInput;
    @FindBy(id = "ff14642ac1c__us_address")
    private WebElement addressInput;
    @FindBy(id = "ff14642ac1c__us_phone")
    private WebElement phoneInput;
    @FindBy(xpath = ".//input[@value='Save']")
    private WebElement saveButton;

    private WebDriver driver;
    public static final String URL_INSERT = "http://80.92.229.236:81/players/insert";

    public CreatePlayerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    public void setEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        passwInput.clear();
        passwInput.sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(password);
    }

    public void setFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void setCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void setAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void setPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void clickOnSave() {
        saveButton.click();
    }
}