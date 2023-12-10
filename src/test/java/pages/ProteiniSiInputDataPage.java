package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProteiniSiInputDataPage extends BaseHelper {
    WebDriver driver;

    public ProteiniSiInputDataPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "basket_submit")
    WebElement basketSubmit;
    @FindBy(name = "recipient-ime")
    WebElement inputName;
    @FindBy(name = "recipient-priimek")
    WebElement inputPriimek;
    @FindBy(name = "recipient-naslov")
    WebElement inputAddress;
    @FindBy(className = "rs-select-button")
    WebElement ZiP;
    @FindBy(name = "recipient-email")
    WebElement inputEmail;
    @FindBy(name ="recipient-telefon")
    WebElement inputNumber;

    private void inputNameForm (String name) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});",inputName);
        wdWait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys(name);
    }
    private void inputPriimekForm (String priimek){
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", inputPriimek);
        wdWait.until(ExpectedConditions.visibilityOf(inputPriimek));
        inputPriimek.sendKeys(priimek);
    }
    private void inputAddressForm (String address){
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});",inputAddress);
        wdWait.until(ExpectedConditions.visibilityOf(inputAddress));
        inputAddress.sendKeys(address);
    }
    private void selectZiPForm(){
        wdWait.until(ExpectedConditions.visibilityOf(ZiP));
        wdWait.until(ExpectedConditions.elementToBeClickable(ZiP));
        ZiP.click();
        WebElement zipNumbers = driver.findElement(By.className("rs-select-options-scroll"));
        List<WebElement> zipList = zipNumbers.findElements(By.className("rs-select-option"));
        WebElement numbers = zipList.get(5);
        wdWait.until(ExpectedConditions.elementToBeClickable(numbers));
        numbers.click();

    }
    private void inputEmailForm(String email){
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});",inputEmail);
        wdWait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(email);
    }
    private void inputNumberForm(String number){
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});",inputNumber);
        wdWait.until(ExpectedConditions.visibilityOf(inputNumber));
        inputNumber.sendKeys(number);
    }



    private void clickOnFinishButton (){
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", basketSubmit);
        wdWait.until(ExpectedConditions.visibilityOf(basketSubmit));
        js.executeScript("arguments[0].click();", basketSubmit);


    }




    public void fillForm (String name, String priimek, String address, String email, String number) throws InterruptedException {
        inputNameForm(name);
        inputPriimekForm(priimek);
        inputAddressForm(address);
        Thread.sleep(2000);
        selectZiPForm();
        Thread.sleep(2000);
        inputEmailForm(email);
        Thread.sleep(1000);
        inputNumberForm(number);
        clickOnFinishButton();
        Thread.sleep(10000);
    }













}
