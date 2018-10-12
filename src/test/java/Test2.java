import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
    WebDriver driver = new ChromeDriver();
    @BeforeEach
    public void Preconditions() {
        driver.get("https://appflare.net/login");
        driver.manage().window().maximize();
    }

    @Test
    public void Test1() {
        WebElement element = driver.findElement(By.id("input_0"));
        element.sendKeys("admin@appflare.net");
        WebElement element2 = driver.findElement(By.id("input_1"));
        element2.sendKeys("admin");
        element2.sendKeys(Keys.ENTER);
    }

    @Test
    public void Test2() {
        WebElement element = driver.findElement(By.id("input_0"));
        element.sendKeys("admin@appflare.net");
        WebElement element2 = driver.findElement(By.id("input_1"));
        element2.sendKeys("admin");
        WebElement element3 = driver.findElement(By.xpath("/html/body/div/login-component/div/form[1]/div[2]/div[2]/button"));
        element3.click();
    }
    @AfterEach
    public void PostCondition() throws InterruptedException {
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("/html/body/div/app/div/div/toolbar/div/div[2]/md-menu/div[1]"));
        element.click();

        Thread.sleep(1000);
        element = driver.findElement(By.xpath("//*[@id=\"menu_container_6\"]/md-menu-content/md-menu-item/button"));
        element.click();
    }
}

