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

public class AddCart {
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

    @Given("the user is logged in on the SauceDemo website for add cart")
    public void userIsLoggedIn4AddCart() {
        driver.get("https://www.saucedemo.com/");
        // Implement the login process
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @When("the user adds items to the shopping cart")
    public void userAddsItemsToCart() {
        // Add items to the cart, for example:
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();

        // You can add more items to the cart as needed
    }

    @Then("the cart should contain the added items")
    public void cartContainsAddedItems() {
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_badge"));
        assert cartIcon.getText().equals("1"); // Check if the cart icon shows the correct number of items
    }
}

