package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;
    WebElement openMenu;
    WebElement btnLogOut;

    String classLoading = "spinner";
    String xpathMainMenu = "/html/body/div[1]/app/div/div/toolbar/div/div[2]/md-menu/div[1]";
    String xpathButtonClose = "//*[@id=\"menu_container_6\"]/md-menu-content/md-menu-item/button";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(classLoading)));
        openMenu = driver.findElement(By.xpath(xpathMainMenu));
        openMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathButtonClose)));
        btnLogOut = driver.findElement(By.xpath(xpathButtonClose));
        btnLogOut.click();
    }

}
