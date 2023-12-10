package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProteiniSiProductPage extends BaseHelper {
    WebDriver driver;

    public ProteiniSiProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "rs-select-button")
    WebElement selectButton;
    @FindBy(className = "rs-select-options")
    WebElement selectOptions;
    @FindBy(className = "js-add-to-cart")
    WebElement addtoCart;
    @FindBy(className = "cart")
    WebElement cartButton;


    private void selectFlavor (){
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", selectButton);
        selectButton.click();
        wdWait.until(ExpectedConditions.visibilityOf(selectOptions));
        WebElement productFlavor = driver.findElement(By.className("rs-select-options"));
        List<WebElement> flavorsList = productFlavor.findElements(By.className("rs-select-option"));
        WebElement flavor = flavorsList.get(1);
        flavor.click();

    }

    private void quantityOfProducts (){
        WebElement increaseButton = driver.findElement(By.className("increase"));
        for(int i=0; i<2; i++) {//uslov i inkrementacija
            increaseButton.click();
        }
    }

    private void addToCart (){
        wdWait.until(ExpectedConditions.visibilityOf(addtoCart));
        addtoCart.click();
    }

    private void openCart () {
        wdWait.until(ExpectedConditions.visibilityOf(cartButton));
        cartButton.click();


    }

    public void selectDetails () throws InterruptedException{
        selectFlavor();
        Thread.sleep(2000);
        quantityOfProducts();
        addToCart();
        Thread.sleep(5000);
        openCart();
    }

















}
