package HW4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "logIn")
    private WebElement loginButton;
    @FindBy(xpath = "//ul[@class='errors']/li")
    private WebElement errorMsgElement;
    @FindBy(xpath = ".//dd[@id ='username-element']//ul[@class='errors']/li")
    private WebElement errorMsgEmailFieldElement;
    @FindBy(xpath = ".//dd[@id ='password-element']//ul[@class='errors']/li")
    private WebElement errorMsgPasswordFieldElement;



    private WebDriver driver;
    public static final String URL_LOGIN = "http://80.92.229.236:81/auth/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL_LOGIN);
    }

    public PlayerPage login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickOnLogin();
        return new PlayerPage(driver);
    }

    public void setUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        String errorMsg = errorMsgElement.getText();
        return errorMsg;
    }

    public String getErrorMessageEmptyUsernameFields() {
        String errorEmailMsg = errorMsgEmailFieldElement.getText();
        return errorEmailMsg;
    }

    public String getErrorMessageEmptyPasswordFields() {
        String errorPasswordMsg = errorMsgPasswordFieldElement.getText();
        return errorPasswordMsg;
    }
}