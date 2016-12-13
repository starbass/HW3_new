package HW3.darganddrop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class ActionPage {

    @FindBy(xpath = ".//*[@id='sortable']/li[text()='1']")
    private WebElement sourceElement1;

    @FindBy(xpath = ".//*[@id='sortable']/li[text()='2']")
    public WebElement sourceElement2;

    @FindBy(xpath = ".//*[@id='sortable']/li[text()='3']")
    private WebElement sourceElement3;

    @FindBy(xpath = ".//*[@id='sortable']/li[text()='4']")
    private WebElement sourceElement4;

    @FindBy(xpath = ".//*[@id='sortable']/li[text()='5']")
    private WebElement sourceElement5;

    @FindBy(xpath = ".//*[@id='sortable']/li[text()='6']")
    private WebElement sourceElement6;

    @FindBy(xpath = ".//*[@id='sortable']/li[text()='7']")
    private WebElement sourceElement7;

    @FindBy(id = "drop")
    private WebElement trashElement;


    @FindBy(xpath = ".//*[@id='sortable']/li[1]")
    private WebElement elementPositionNumber1;
    @FindBy(xpath = ".//*[@id='sortable']/li[2]")
    private WebElement elementPositionNumber2;
    @FindBy(xpath = ".//*[@id='sortable']/li[3]")
    private WebElement elementPositionNumber3;
    @FindBy(xpath = ".//*[@id='sortable']/li[4]")
    private WebElement elementPositionNumber4;
    @FindBy(xpath = ".//*[@id='sortable']/li[5]")
    private WebElement elementPositionNumber5;
    @FindBy(xpath = ".//*[@id='sortable']/li[6]")
    private WebElement elementPositionNumber6;
    @FindBy(xpath = ".//*[@id='sortable']/li[7]")
    private WebElement elementPositionNumber7;


    private WebDriver driver;
    private final static String URL = "file:///C:/Users/user/Desktop/drag_and_drop2/drag_and_drop2/index.html";

    public ActionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    public void dragAndDropElementNumber1() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement1, trashElement)
                .perform();
    }

    public boolean isElementNumber1Present() {
        try {
            this.sourceElement1.getTagName();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isNotElement1Present(By sourceElement1) {
        try {
            driver.findElement(sourceElement1);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    public void sortUpElementNumber1() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement1, elementPositionNumber1)
                .perform();
    }
    public void sortUpElementNumber2() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement2, elementPositionNumber2)
                .perform();
    }
    public void sortUpElementNumber3() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement3, elementPositionNumber3)
                .perform();
    }
    public void sortUpElementNumber4() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement4, elementPositionNumber4)
                .perform();
    }
    public void sortUpElementNumber5() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement5, elementPositionNumber5)
                .perform();
    }
    public void sortUpElementNumber6() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement6, elementPositionNumber6)
                .perform();
    }
    public void sortUpElementNumber7() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement7, elementPositionNumber7)
                .perform();
    }

    //from 7 to 1
    public void sortDownElementNumber7() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement7, elementPositionNumber1)
                .perform();
    }
    public void sortDownElementNumber6() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement6, elementPositionNumber2)
                .perform();
    }
    public void sortDownElementNumber5() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement5, elementPositionNumber3)
                .perform();
    }
    public void sortDownElementNumber4() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement4, elementPositionNumber4)
                .perform();
    }
    public void sortDownElementNumber3() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement3, elementPositionNumber5)
                .perform();
    }
    public void sortDownElementNumber2() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement2, elementPositionNumber6)
                .perform();
    }
    public void sortDownElementNumber1() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement1, elementPositionNumber7)
                .perform();
    }






    /*public boolean isDropped() {
        return trashElement.getAttribute("class").contains("ui-state-highlight");
    }

    public String getTargetText() {
        return trashElement.findElement(By.xpath(".//p")).getText();
    }

    public void switchToFrame() {
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
    }

    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }*/
}