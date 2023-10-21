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

public class Checkout {
    private WebDriver driver;

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

    @Given("the user is logged in on the SauceDemo website")
    public void userIsLoggedIn() {
        driver.get("https://www.saucedemo.com/");
        // You should implement the login steps here, similar to the previous example
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @When("the user adds items to the shopping cart for checkout")
    public void userAddsItemsToCart4Checkout() {
        // Implement adding items to the cart, for example:
        WebElement addItemButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addItemButton.click();

        // You can add more items to the cart as needed
    }

    @And("proceeds to the checkout")
    public void userProceedsToCheckout() {
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();

        // Additional steps to proceed to checkout
    }

    @And("completes the checkout process")
    public void userCompletesCheckout() {
        // Implement the checkout process, which may include providing shipping and payment details
    }

    @Then("the user should see a confirmation message")
    public void userSeesConfirmationMessage() {
        WebElement confirmationMessage = driver.findElement(By.cssSelector(".complete-header"));
        assert confirmationMessage.getText().equals("THANK YOU FOR YOUR ORDER");
    }
}
