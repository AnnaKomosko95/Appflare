package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CredentialManager;

import static org.openqa.selenium.By.xpath;

public class LoginPage {
    WebDriver driver;
    WebElement inputLogin;
    WebElement inputPassword;
    WebElement btnLogin;
    WebElement openMenu;
    WebElement btnLogOut;

    String idInputLogin = "input_0";
    String idInputPassword = "input_1";
    String xpathButtonLogin = "/html/body/div/login-component/div/form[1]/div[2]/div[2]/button";
    String loginLink = "https://appflare.net/login";
    String link = "https://appflare.net/";
    String classLoading = "spinner";
    String xpathMainMenu = "/html/body/div[1]/app/div/div/toolbar/div/div[2]/md-menu/div[1]";
    String xpathButtonClose = "//*[@id=\"menu_container_6\"]/md-menu-content/md-menu-item/button";

    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        openPage();
        this.inputLogin = driver.findElement(By.id(idInputLogin));
        this.inputPassword = driver.findElement(By.id(idInputPassword));
        this.btnLogin = driver.findElement(xpath(xpathButtonLogin));
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
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.urlToBe(link));
    }

    public void logout() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(classLoading)));
        openMenu = driver.findElement(By.xpath(xpathMainMenu));
        openMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathButtonClose)));
        btnLogOut = driver.findElement(By.xpath(xpathButtonClose));
        btnLogOut.click();
    }

}
