package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
//import io.cucumber.java.en.But;

public class Auth {
    WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver (e.g., ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
    }


    @Given("the user is on the SauceDemo login page")
    public void userIsOnLoginPage() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters a valid username and password")
    public void userEntersValidCredentials() throws InterruptedException {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");

//        Thread.sleep(5000);
    }

    @And("clicks the login button")
    public void userClicksLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("the user should be logged in")
    public void userIsLoggedIn() {
        WebElement productTitle = driver.findElement(By.className("title"));
        System.out.println("AKELMDAKLEMDKLAEMDKLA: " + productTitle.getText());
        assert productTitle.getText().equals("Products");
    }

    @When("the user enters an invalid username or password")
    public void userEntersInvalidCredentials() {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys("invalid_user");
        passwordInput.sendKeys("invalid_password");
    }

    @Then("the user should see an error message")
    public void userSeesErrorMessage() {
        WebElement errorContainer = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assert errorContainer.getText().equals("Epic sadface: Username and password do not match any user in this service");
    }

    @After
    public void tearDown() {
        // Close the WebDriver after the scenario is complete
        driver.quit();
    }
}

