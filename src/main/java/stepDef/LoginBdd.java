package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginBdd extends env_target {
    WebDriverWait wait;

    @Given("I am on login page")
    public void iAmOnLoginPage(){
        //mengatur lokasi path chrmium
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SII - GALANG\\IdeaProjects\\TestAutomationDBS\\src\\main\\resources\\chromedriver.exe");
        //memperbesar driver dengan maksimal
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //setup url
        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(5);
         wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login\"]/button")));
    }

    @When("I fill username 'tomsmith' in username inputText")
    public void iFillUsernameInUsernameInputtext(){
        driver.findElement(By.name("username")).sendKeys("tomsmith");
    }

    @When("I fill wrong username 'ruben' in username inputText")
    public void iFillWrongUsernameInUsernameInputtext(){
        driver.findElement(By.name("username")).sendKeys("ruben");
    }

    @And("I fill password 'SuperSecretPassword!' in password inputText")
    public void iFillPasswordInPasswordInputtext(){
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    }

    @And("I click login button")
    public void iClickLoginButton(){
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
    }

    @Then("I successfully login")
    public void iSuccessfullyLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flash\"][@class=\"flash success\"]")));
    }

    @Then("I get error message")
    public void iGetErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flash\"][@class=\"flash error\"]")));
    }

    @And("I quit website")
    public void iQuitWebsite(){
        driver.quit();
    }
}
