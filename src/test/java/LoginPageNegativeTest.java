import org.junit.jupiter.api.Test;

public class LoginPageNegativeTest extends AbstractLoginPage {

    @Test
    public void TestWithSpaces() {
        loginPage.loginTest(getAdminCredentialsWithSpaces);

    }

}
