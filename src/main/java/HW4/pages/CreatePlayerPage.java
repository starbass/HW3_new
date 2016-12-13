package HW4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatePlayerPage {

    private WebDriver driver;
    public static final String URL_INSERT = "http://80.92.229.236:81/players/insert";

    public CreatePlayerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName) {
        WebElement userNameInput = driver.findElement(By.id("ff14642ac1c__us_login"));
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    public void setEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("ff14642ac1c__us_email"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passwInput = driver.findElement(By.id("ff14642ac1c__us_password"));
        passwInput.clear();
        passwInput.sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        WebElement confirmPasswordInput = driver.findElement(By.id("ff14642ac1c__confirm_password"));
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(password);
    }

    public void setFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(By.id("ff14642ac1c__us_fname"));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebElement lastNameInput = driver.findElement(By.id("ff14642ac1c__us_lname"));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void setCity(String city) {
        WebElement cityInput = driver.findElement(By.id("ff14642ac1c__us_city"));
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void setAddress(String address) {
        WebElement addressInput = driver.findElement(By.id("ff14642ac1c__us_address"));
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void setPhone(String phone) {
        WebElement phoneInput = driver.findElement(By.id("ff14642ac1c__us_phone"));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void clickOnSave() {
        WebElement saveButton = driver.findElement(By.xpath(".//input[@value='Save']"));
        saveButton.click();
    }
}