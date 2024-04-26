package io.digisic.bank.test.generated;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GeneratedSavingsAccountTestsIT {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void createSavingsAccountWithSpecialCharacterName() {
        // Navigate to the savings account creation page
        driver.get("https://localhost:8443/bank");
        // Assuming there's a login process
        driver.findElement(By.id("username")).sendKeys("jsmith@demo.io");
        driver.findElement(By.id("password")).sendKeys("Demo123!");
        driver.findElement(By.id("submit")).click();

        // Navigate to the account creation section after successful login
        wait.until(ExpectedConditions.elementToBeClickable(By.id("savings-menu"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("new-savings-menu-item"))).click();

        // Fill out the form with special characters in the Name field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("#$%SpecialName");
        driver.findElement(By.id("Savings")).click();
        driver.findElement(By.id("Individual")).click();
        driver.findElement(By.id("openingBalance")).sendKeys("100");

        // Submit the form
        driver.findElement(By.id("newSavingsSubmit")).click();

        // Adding an explicit wait to check for the error message or confirmation that the account was not created
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sufee-alert")));
        String confirmationMessage = driver.findElement(By.cssSelector(".sufee-alert")).getText();
        assert confirmationMessage.contains("Account Not Created");
    }

    @Test
    public void createSavingsAccountWithInvalidDeposit() {
        // Navigate to the savings account creation page
        driver.get("https://localhost:8443/bank");
        // Assuming there's a login process
        driver.findElement(By.id("username")).sendKeys("jsmith@demo.io");
        driver.findElement(By.id("password")).sendKeys("Demo123!");
        driver.findElement(By.id("submit")).click();

        // Navigate to the account creation section after successful login
        wait.until(ExpectedConditions.elementToBeClickable(By.id("savings-menu"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("new-savings-menu-item"))).click();

        // Fill out the form with special characters in the Name field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("John Smith");
        driver.findElement(By.id("Savings")).click();
        driver.findElement(By.id("Individual")).click();
        driver.findElement(By.id("openingBalance")).sendKeys("10");

        // Submit the form
        driver.findElement(By.id("newSavingsSubmit")).click();

        // Adding an explicit wait to check for the error message or confirmation that the account was not created
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sufee-alert")));
        String confirmationMessage = driver.findElement(By.cssSelector(".sufee-alert")).getText();
        assert confirmationMessage.contains("Please enter a valid deposit amount.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}