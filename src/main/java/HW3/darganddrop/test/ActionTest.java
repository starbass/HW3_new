package HW3.darganddrop.test;

import HW3.darganddrop.page.ActionPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class ActionTest {

    private WebDriver driver;
    private ActionPage actionPage;
    private SoftAssert softAssert;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actionPage = new ActionPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void dragAndDropTest() {
        /*
        1. Open page.
        2. Perform drag and drop.
        2. Check text and class attribute.
         */
        actionPage.open();
        String msg = "Are you sure that you want to delete?";
        actionPage.dragAndDropElementNumber1();
        WebDriverWait wait = new WebDriverWait(driver, 20, 100);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        softAssert.assertEquals(driver.switchTo().alert().getText(), msg, "msg is NOT equals");
        alert.dismiss();
        softAssert.assertEquals(actionPage.isElementNumber1Present(), true, "element is not present on page");
        actionPage.dragAndDropElementNumber1();
        driver.switchTo().alert();
        softAssert.assertEquals(driver.switchTo().alert().getText(), msg, "msg is NOT equals");
        alert.accept();
        softAssert.assertEquals(actionPage.isNotElement1Present(By.xpath(".//*[@id='sortable']/li[text()='1']")),
                false, "element number 1 is present on page");
        softAssert.assertAll();
    }


    @Test(dependsOnMethods = "dragAndDropTest", alwaysRun = true)
    public void sortElementsFrom1To7(){
        actionPage.open();
        actionPage.sortUpElementNumber1();
        actionPage.sortUpElementNumber2();
        actionPage.sortUpElementNumber2();
        actionPage.sortUpElementNumber3();
        actionPage.sortUpElementNumber3();
        actionPage.sortUpElementNumber4();
        actionPage.sortUpElementNumber4();
        actionPage.sortUpElementNumber5();
        actionPage.sortUpElementNumber5();
        actionPage.sortUpElementNumber6();
        actionPage.sortUpElementNumber6();
        actionPage.sortUpElementNumber7();
        actionPage.sortUpElementNumber7();

        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='1']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[1]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='2']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[2]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='3']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[3]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='4']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[4]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='5']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[5]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='6']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[6]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='7']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[7]")),"it is not equals");

        actionPage.sortDownElementNumber7();
        actionPage.sortDownElementNumber6();
        actionPage.sortDownElementNumber6();
        actionPage.sortDownElementNumber5();
        actionPage.sortDownElementNumber5();
        actionPage.sortDownElementNumber4();
        actionPage.sortDownElementNumber4();
        actionPage.sortDownElementNumber3();
        actionPage.sortDownElementNumber3();
        actionPage.sortDownElementNumber2();
        actionPage.sortDownElementNumber2();
        actionPage.sortDownElementNumber1();
        actionPage.sortDownElementNumber1();

        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='7']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[1]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='6']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[2]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='5']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[3]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='4']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[4]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='3']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[5]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='2']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[6]")),"it is not equals");
        softAssert.assertEquals(driver.findElement(By.xpath(".//*[@id='sortable']/li[text()='1']")),
                driver.findElement(By.xpath(".//*[@id='sortable']/li[7]")),"it is not equals");
        softAssert.assertAll();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}