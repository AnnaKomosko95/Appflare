package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CredentialManager;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    WebElement inputLogin;
    WebElement inputPassword;
    WebElement btnLogin;


    String idInputLogin = "input_0";
    String idInputPassword = "input_1";
    String xpathButtonLogin = "/html/body/div/login-component/div/form[1]/div[2]/div[2]/button";
    String loginLink = "https://appflare.net/login";
    String link = "https://appflare.net/";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        openPage();
        this.inputLogin = driver.findElement(By.id(idInputLogin));
        this.inputPassword = driver.findElement(By.id(idInputPassword));
        this.btnLogin = driver.findElement(By.xpath(xpathButtonLogin));
    }

    public void openPage(){
        driver.get(loginLink);
        driver.manage().window().maximize();
    }

    public void inputLogin(String login){
        inputLogin.sendKeys(login);
    }

    public void inputPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }


    public void loginTest(CredentialManager manager){
        inputLogin(manager.getLogin());
        inputPassword(manager.getPassword());
        clickLogin();
        waitForLogin();
    }

    public void loginTestWithEnter(CredentialManager manager){
        inputLogin(manager.getLogin());
        inputPassword(manager.getPassword());
        getInputPassword().submit();
        waitForLogin();
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public void waitForLogin() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(link));
        }

}
