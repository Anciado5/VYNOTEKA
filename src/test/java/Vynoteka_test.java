import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Vynoteka_test {
    public static WebDriver driver = new ChromeDriver();
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void searchTest(){
        driver.get("https://vynoteka.lt/");

        WebElement acceptCookies = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        acceptCookies.click();

        WebElement ageVerification = driver.findElement(By.xpath("//*[@id=\"app__inner\"]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button"));
        ageVerification.click();

        WebElement closeAd = wait.until(ExpectedConditions.elementToBeClickable(By.id("omnisend-form-63ff1f31b40d6530aba59a6d-form-close-icon")));
        closeAd.click();

        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.className("form-control")));
        searchInput.sendKeys("vynas");
        searchInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-results__aside")));
        WebElement searchResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app__header\"]/div[2]/div/div/div[3]/div/div/div/form/div[2]/div/div[1]/div[2]/a")));
        searchResult.click();
    }



}
