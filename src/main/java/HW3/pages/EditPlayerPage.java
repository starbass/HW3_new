package HW3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPlayerPage {

    private WebDriver driver;

    public EditPlayerPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getEmail() {
        WebElement getEmailValue = driver.findElement(By.id("ff14642ac1c__us_email"));
        String emailValue = getEmailValue.getAttribute("value");
        return emailValue;
    }

    public String getFirstName() {
        WebElement getFnameValue = driver.findElement(By.id("ff14642ac1c__us_fname"));
        String fnameValue = getFnameValue.getAttribute("value");
        return fnameValue;
    }

    public String getLastName() {
        WebElement getLnameValue = driver.findElement(By.id("ff14642ac1c__us_lname"));
        String lnameValue = getLnameValue.getAttribute("value");
        return lnameValue;
    }

    public String getCity() {
        WebElement getCityValue = driver.findElement(By.id("ff14642ac1c__us_city"));
        String cityValue = getCityValue.getAttribute("value");
        return cityValue;
    }

    public String getAddress() {
        WebElement getAddressValue = driver.findElement(By.id("ff14642ac1c__us_address"));
        String addressValue = getAddressValue.getText();
        return addressValue;
    }

    public String getPhone() {
        WebElement getPhoneValue = driver.findElement(By.id("ff14642ac1c__us_phone"));
        String phoneValue = getPhoneValue.getAttribute("value");
        return phoneValue;
    }

    public void setNewEmail(String newEmail) {
        WebElement newEmailInput = driver.findElement(By.id("ff14642ac1c__us_email"));
        newEmailInput.clear();
        newEmailInput.sendKeys(newEmail);
    }

    public void setNewFirstName(String newFirstName) {
        WebElement newFirstNameInput = driver.findElement(By.id("ff14642ac1c__us_fname"));
        newFirstNameInput.clear();
        newFirstNameInput.sendKeys(newFirstName);
    }

    public void setNewLastName(String newLastName) {
        WebElement newLastNameInput = driver.findElement(By.id("ff14642ac1c__us_lname"));
        newLastNameInput.clear();
        newLastNameInput.sendKeys(newLastName);
    }

    public void setNewCity(String newCity) {
        WebElement newCityInput = driver.findElement(By.id("ff14642ac1c__us_city"));
        newCityInput.clear();
        newCityInput.sendKeys(newCity);
    }

    public void setNewAddress(String newAddress) {
        WebElement newAddressInput = driver.findElement(By.id("ff14642ac1c__us_address"));
        newAddressInput.clear();
        newAddressInput.sendKeys(newAddress);
    }

    public void setNewPhone(String newPhone) {
        WebElement newPhoneInput = driver.findElement(By.id("ff14642ac1c__us_phone"));
        newPhoneInput.clear();
        newPhoneInput.sendKeys(newPhone);
    }

    public void clickNewSaveButton() {
        WebElement newSaveButton = driver.findElement(By.xpath(".//input[@value='Save']"));
        newSaveButton.click();
    }

}


