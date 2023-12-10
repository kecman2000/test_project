package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProteiniSiProductsPage extends BaseHelper {
    WebDriver driver;

    public ProteiniSiProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "product_list")
    WebElement productList;



    private void selectCategory() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement categoryBtn = driver.findElement(By.id("product-list-filters"));

        categoryBtn.click();
        System.out.println("poslije clicka categorybtn");


        WebElement surutka = new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox'][data-id='1494'] + label")));

        if(surutka.isSelected()){
            System.out.println("izabrana");

        }
        surutka.click();

    }
    private void clickProduct () {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wdWait.until(ExpectedConditions.visibilityOf(productList));
        WebElement productContainer = driver.findElement(By.id("product_list"));
        List<WebElement> productList = productContainer.findElements(By.className("products_in_category"));
        WebElement product = productList.get(3);
        WebElement productCard = product.findElement(By.className("product-card"));
        productCard.click();

    }


    public void selectProduct() throws InterruptedException {
        selectCategory();
        clickProduct();
    }


















}
