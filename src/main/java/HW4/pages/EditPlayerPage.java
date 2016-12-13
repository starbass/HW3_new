package HW4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPlayerPage {
    @FindBy(id = "ff14642ac1c__us_email")
    private WebElement getEmailValue;
    @FindBy(id = "ff14642ac1c__us_fname")
    private WebElement getFnameValue;
    @FindBy(id = "ff14642ac1c__us_lname")
    private WebElement getLnameValue;
    @FindBy(id = "ff14642ac1c__us_city")
    private WebElement getCityValue;
    @FindBy(id = "ff14642ac1c__us_address")
    private WebElement getAddressValue;
    @FindBy(id = "ff14642ac1c__us_phone")
    private WebElement getPhoneValue;
    @FindBy(id = "ff14642ac1c__us_email")
    private WebElement newEmailInput;
    @FindBy(id = "ff14642ac1c__us_fname")
    private WebElement newFirstNameInput;
    @FindBy(id = "ff14642ac1c__us_lname")
    private WebElement newLastNameInput;
    @FindBy(id = "ff14642ac1c__us_city")
    private WebElement newCityInput;
    @FindBy(id = "ff14642ac1c__us_address")
    private WebElement newAddressInput;
    @FindBy(id = "ff14642ac1c__us_phone")
    private WebElement newPhoneInput;
    @FindBy(xpath = ".//input[@value='Save']" )
    private WebElement newSaveButton;


    private WebDriver driver;

    public EditPlayerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getEmail() {
        String emailValue = getEmailValue.getAttribute("value");
        return emailValue;
    }

    public String getFirstName() {
        String fnameValue = getFnameValue.getAttribute("value");
        return fnameValue;
    }

    public String getLastName() {
        String lnameValue = getLnameValue.getAttribute("value");
        return lnameValue;
    }

    public String getCity() {
        String cityValue = getCityValue.getAttribute("value");
        return cityValue;
    }

    public String getAddress() {
        String addressValue = getAddressValue.getText();
        return addressValue;
    }

    public String getPhone() {
        String phoneValue = getPhoneValue.getAttribute("value");
        return phoneValue;
    }

    public void setNewEmail(String newEmail) {
        newEmailInput.clear();
        newEmailInput.sendKeys(newEmail);
    }

    public void setNewFirstName(String newFirstName) {
        newFirstNameInput.clear();
        newFirstNameInput.sendKeys(newFirstName);
    }

    public void setNewLastName(String newLastName) {
        newLastNameInput.clear();
        newLastNameInput.sendKeys(newLastName);
    }

    public void setNewCity(String newCity) {
        newCityInput.clear();
        newCityInput.sendKeys(newCity);
    }

    public void setNewAddress(String newAddress) {
        newAddressInput.clear();
        newAddressInput.sendKeys(newAddress);
    }

    public void setNewPhone(String newPhone) {
        newPhoneInput.clear();
        newPhoneInput.sendKeys(newPhone);
    }
    
    public void clickNewSaveButton() {
        newSaveButton.click();
    }

}


