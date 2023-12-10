package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProteiniSiConfirmOrderPage extends BaseHelper {
    WebDriver driver;

    public ProteiniSiConfirmOrderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "button-confirmbasket")
    WebElement continueButton;

    private void continueOrder () {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", continueButton);
        wdWait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
    }



    public void continueOrdering (){
        continueOrder();

    }











}
