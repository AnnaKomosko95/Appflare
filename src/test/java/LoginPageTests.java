import org.junit.jupiter.api.Test;

public class LoginPageTests extends AbstractLoginPage {

    @Test
    public void Test1() {
        loginPage.loginTest(adminCredentials);
    }

    @Test
    public void Test2() {
        loginPage.loginTestWithEnter(adminCredentials);
    }


}
