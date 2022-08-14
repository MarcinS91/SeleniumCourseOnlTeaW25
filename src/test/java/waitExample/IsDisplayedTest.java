package waitExample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class IsDisplayedTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "http://automationpractice.com/index.php";
        driver.get(url);
        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();
        WebElement emailInput = driver.findElement(By.id("email_create"));
        emailInput.sendKeys("poczta@poczta.pl");
        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("create_account_error"))));
        boolean warning = driver.findElement(By.id("create_account_error")).isDisplayed();
        Assert.assertTrue(warning);
        driver.quit();
    }
}
