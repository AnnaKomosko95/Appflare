package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.CredentialManager;

public class LoginPage {
    WebDriver driver;
    WebElement inputLogin;
    WebElement inputPassword;
    WebElement btnLogin;
    WebElement btnClose;

    String idInputLogin = "input_0";
    String idInputPassword = "input_1";
    String xpathButtonLogin = "/html/body/div/login-component/div/form[1]/div[2]/div[2]/button";
    //String xpathButtonClose = "/html/body/div/app/div/div/toolbar/div/div[2]/md-menu/div[1]";
    String link = "https://appflare.net/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        openPage();
        this.inputLogin = driver.findElement(By.id(idInputLogin));
        this.inputPassword = driver.findElement(By.id(idInputPassword));
        this.btnLogin = driver.findElement(By.xpath(xpathButtonLogin));
        //this.btnClose = driver.findElement(By.xpath(xpathButtonClose));
    }

    public void openPage(){
        driver.get(link);
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

    public void clickClose(){
        btnClose.click();
    }

    public void loginTest(CredentialManager manager){
        inputLogin(manager.getLogin());
        inputPassword(manager.getPassword());
        clickLogin();
    }

    public void loginTestWithEnter(CredentialManager manager){
        inputLogin(manager.getLogin());
        inputPassword(manager.getPassword());
        getInputPassword().submit();
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

}
