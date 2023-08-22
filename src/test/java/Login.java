import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends env_target{
    @Test
    public void successLogin(){
        //mengatur lokasi path chrmium
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SII - GALANG\\IdeaProjects\\TestAutomationDBS\\src\\main\\resources\\chromedriver.exe");
        //memperbesar driver dengan maksimal
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //setup url
        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login\"]/button")));

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flash\"][@class=\"flash success\"]")));

        driver.quit();
    }

    @Test
    public void failedLogin(){
        //mengatur lokasi path chrmium
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SII - GALANG\\IdeaProjects\\TestAutomationDBS\\src\\main\\resources\\chromedriver.exe");
        //memperbesar driver dengan maksimal
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //setup url
        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login\"]/button")));

        driver.findElement(By.name("username")).sendKeys("tomsmi");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flash\"][@class=\"flash error\"]")));
        driver.quit();
    }
}
