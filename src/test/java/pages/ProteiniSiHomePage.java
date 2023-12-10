package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProteiniSiHomePage extends BaseHelper {
    WebDriver driver;
public ProteiniSiHomePage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
}
    @FindBy(id = "search-input")
    WebElement searchInput;

    @FindBy(className = "search-submit")
    WebElement searchButton;

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

    private void inputSearchTerm(String searchTerm){
        wdWait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(searchTerm);
    }

    private void clickOnSearchButton(){
        wdWait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }
    public void searchTest(String url, String searchTerm) throws InterruptedException {
        navigateToPage(url);
        Thread.sleep(1000);
        acceptCookies();
        inputSearchTerm(searchTerm);
        clickOnSearchButton();
    }














}
