import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.MainPage;
import util.CredentialManager;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractLoginPage {
    CredentialManager adminCredentials = new CredentialManager("admin", "admin");
    CredentialManager adminCredentialsFullLogin = new CredentialManager("admin@appflare.net", "admin");
    CredentialManager getAdminCredentialsWithSpaces = new CredentialManager("ad min", "admin");



    protected WebDriver driver = new ChromeDriver();
    //protected WebDriver driver = new FirefoxDriver();

    LoginPage loginPage;
    MainPage mainPage;

    @BeforeEach
    public void Preconditions() {
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void PostCondition() {
        mainPage = new MainPage(driver);
        mainPage.logout();
    }

    @AfterAll
    public void quit() {
        driver.close();
    }
}
