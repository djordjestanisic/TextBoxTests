import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Domaci2 {
    public static void main(String[] args) throws InterruptedException {


//https://demoqa.com/text-box napisati test case za dati text box


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameField = driver.findElement(By.id("userName"));
        fullNameField.sendKeys("Petar Petrovic");

        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("petarpetrovic@example.com");

        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        currentAddressField.sendKeys("Petroviceva 9");

        WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
        permanentAddressField.sendKeys("Petroviceva 9");

        Thread.sleep(7000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedUrl = "https://demoqa.com/text-box";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        WebElement submitButtonAfterSubmit = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButtonAfterSubmit.isDisplayed());

        WebElement dataFramework = driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12"));
        Assert.assertTrue(dataFramework.isDisplayed());

        WebElement pageTitle = driver.findElement(By.className("main-header"));
        String pageTitleText = pageTitle.getText();
        String expectedTitle = "Text Box";
        Assert.assertEquals(pageTitleText, expectedTitle);

        WebElement nameText = driver.findElement(By.id("name"));
        String nameTextFull = nameText.getText();
        String expectedNameText = "Name:Petar Petrovic";
        Assert.assertEquals(nameTextFull, expectedNameText);

        WebElement emailText = driver.findElement(By.id("email"));
        String emailTextFull = emailText.getText();
        String expectedEmailText = "Email:petarpetrovic@example.com";
        Assert.assertEquals(emailTextFull, expectedEmailText);

        WebElement currentAddressText = driver.findElement(By.id("currentAddress"));
        String currentAddressFull = currentAddressText.getText();
        String expectedCurrentAddress = "Current Address:Petroviceva 9";
        Assert.assertNotEquals(currentAddressFull, expectedCurrentAddress);

        WebElement permanentAddressText = driver.findElement(By.id("permanentAddress"));
        String permanentAddressFull = permanentAddressText.getText();
        String expectedPermanentAddressText = "Permanent Address:Petroviceva 9";
        Assert.assertNotEquals(permanentAddressFull, expectedPermanentAddressText);

        driver.quit();




    }
}
