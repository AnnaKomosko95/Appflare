import org.junit.jupiter.api.Test;

public class LoginPageTests extends AbstractLoginPage {

    @Test
    public void TestWithShortLogin() {
        loginPage.loginTest(adminCredentials);
    }

    @Test
    public void TestWithEnterShortLogin() {
        loginPage.loginTestWithEnter(adminCredentials);
    }

    @Test
    public void TestWithFullLogin() {
        loginPage.loginTest(adminCredentialsFullLogin);
    }

    @Test
    public  void TestWithEnterFullLogin() {
        loginPage.loginTestWithEnter(adminCredentialsFullLogin);
    }

}
