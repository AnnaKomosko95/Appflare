import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import util.CredentialManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractLoginPage {
    CredentialManager adminCredentials = new CredentialManager("admin", "admin");
    protected WebDriver driver = new ChromeDriver();

    LoginPage loginPage;

    @BeforeEach
    public void Preconditions() {
        loginPage = new LoginPage(driver);
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

    @AfterAll
    public void quit() {
        driver.close();
    }
}
