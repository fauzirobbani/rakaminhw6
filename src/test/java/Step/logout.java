package Step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class logout {
    WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver (e.g., ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        // Close the WebDriver after the scenario is complete
        driver.quit();
    }

    @Given("the user is logged in on the SauceDemo website for logout")
    public void userIsLoggedIn4Logout() {
        driver.get("https://www.saucedemo.com/");
        // Implement the login process
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }
    @When("the user logs out")
    public void theUserLogsOut() {
        WebElement navBar = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        navBar.click();
        WebElement logOut = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logOut.click();

    }

    @Then("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
    }
}
