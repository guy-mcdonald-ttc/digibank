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

import static org.junit.Assert.assertTrue;

public class GeneratedLoginTestsIT {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup(); // Setting up WebDriverManager to use FirefoxDriver
        driver = new FirefoxDriver(); // Initializing the driver to use Firefox
        wait = new WebDriverWait(driver, 20); // Setting up WebDriverWait with a wait time of 20 seconds
        driver.manage().window().maximize(); // Maximizing the browser window
    }

    @Test
    public void testLoginWithEmptyUsernameAndPassword() {
        driver.get("https://localhost:8443/bank"); // Placeholder URL - Replace with the actual URL of the login page

        // Locating the username and password fields and the login button.
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))); // Placeholder - replace id as per the actual element
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))); // Placeholder - replace id as per the actual element
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))); // Placeholder - replace id as per the actual element

        // Sending empty strings to mimic empty input fields
        usernameField.sendKeys("");
        passwordField.sendKeys("");

        // Clicking the login button
        loginButton.click();

        // Adding an assertion to check if the appropriate error message is displayed. This requires you to know the error message element's locator.
        // Here, it's assumed; replace '#error-message' with the actual selector.
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sufee-alert")));
        String expectedErrorMessage = "Invalid credentials or access not granted due to user account status or an existing user session."; // Placeholder error message
        assertTrue(errorMessage.getText().contains(expectedErrorMessage));
    }

    @Test
    public void loginUserWithEmptyUsernameAndInvalidPassword() {
        driver.get("https://localhost:8443/bank");
        // Locate the username input field and interact with it
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameInput.clear();
        usernameInput.sendKeys(""); //Set username field to empty

        // Locate the password input field and interact with it
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordInput.clear();
        passwordInput.sendKeys("invalidPassword!@#"); //Set password to an invalid value

        // Locate the login button and perform a click action to attempt login
        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();

        // Wait for the login error message to be visible and assert it is displayed
        // This ensures that users cannot log in with an empty username and an invalid password.
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sufee-alert")));
        assert(errorMessage.isDisplayed());

        // Additional assertions could be added here to verify the content of the error message
        // to ensure it appropriately indicates the failure reason to the user.
    }

    @Test
    public void loginWithSpecialCharactersUsernamePassword() {
        driver.get("https://localhost:8443/bank");// Navigate to the login page

        // Wait until the username field is present to ensure the page has loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        // Locate the username and password fields and submit button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        // Input special characters in username and password fields
        usernameField.sendKeys("user!@#$");
        passwordField.sendKeys("pass!@#$");

        // Click on the submit button
        submitButton.click();

        // Wait for the error message to appear
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sufee-alert"))); // Assuming there's an element showing error messages

        // Assert that the error message is displayed, indicating invalid login (Note: Error message/content may vary depending on the application's response)
        assertTrue(errorMessage.isDisplayed());

        // Optionally, assert the content of the message if known
        // assertTrue(errorMessage.getText().contains("expected error message"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Closing the browser at the end of the test
        }
    }
}