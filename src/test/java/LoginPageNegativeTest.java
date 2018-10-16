import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeoutException;

public class LoginPageNegativeTest extends AbstractLoginPage {

    @Test
    public void TestWithSpaces() {
        loginPage.loginTest(getAdminCredentialsWithSpaces);

    }

}
