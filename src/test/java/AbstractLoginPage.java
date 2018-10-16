import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import util.CredentialManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractLoginPage {
    CredentialManager adminCredentials = new CredentialManager("admin", "admin");
    CredentialManager adminCredentialsFullLogin = new CredentialManager("admin@appflare.net", "admin");

    protected WebDriver driver = new ChromeDriver();

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
