package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProteiniSiLoginPage extends BaseHelper {
  WebDriver driver;

    public ProteiniSiLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className ="login-icon")
    WebElement loginButton;
    @FindBy(id = "login-form-email")
    WebElement inputEmail;
    @FindBy(id = "login-form-pass")
    WebElement inputPass;
    @FindBy(name = "submit")
    WebElement confirmationButton;


    private void navigateToPage(String url){
        driver.get(url);
    }

    private void acceptCookies(){
        List<WebElement> cookiesAcceptButton = driver.findElements(By.className("potrditev"));
        if (!cookiesAcceptButton.isEmpty()) {
            wdWait.until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton.get(0)));
            cookiesAcceptButton.get(0).click();
            wdWait.until(ExpectedConditions.invisibilityOf(cookiesAcceptButton.get(0)));
        }
        System.out.println("Accept cookies list size:" + cookiesAcceptButton.size());

    }

    private void clickOnLoginButton(){
        wdWait.until(ExpectedConditions.visibilityOf(loginButton));
       loginButton.click();
    }
    private void inputForEmail(String email){
        wdWait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(email);
    }
    private void inputForPassword(String password){
        wdWait.until(ExpectedConditions.visibilityOf(inputPass));
        inputPass.sendKeys(password);
    }
    private void clickOnConfirmationButton(){
        wdWait.until(ExpectedConditions.visibilityOf(confirmationButton));
        confirmationButton.click();
    }



    public void loginTest(String url,String email, String password) throws InterruptedException{
        navigateToPage(url);
        Thread.sleep(2000);
        acceptCookies();
       clickOnLoginButton();
       Thread.sleep(3000);
       inputForEmail(email);
       inputForPassword(password);
       clickOnConfirmationButton();
       Thread.sleep(2000);
    }















}
