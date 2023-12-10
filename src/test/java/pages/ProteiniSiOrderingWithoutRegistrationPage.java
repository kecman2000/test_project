package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProteiniSiOrderingWithoutRegistrationPage extends BaseHelper {
        WebDriver driver;
        public ProteiniSiOrderingWithoutRegistrationPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver,this);
        }

        @FindBy(className = "checkout")
    WebElement continueButtonRight;

        private void clickOnRightButton(){
            js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'end', inline: 'center'});", continueButtonRight);

            WebElement buttonCard = driver.findElement(By.cssSelector(".row > .column:nth-child(3) .button.wide.green.arrow-right"));
            buttonCard.click();

        }

        public void continueWithOrdering (){
            clickOnRightButton();
        }

















}
