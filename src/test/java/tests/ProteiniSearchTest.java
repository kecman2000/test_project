package tests;

import helpers.BaseHelper;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ProteiniSiHomePage;

import java.util.List;

public class ProteiniSearchTest extends BaseHelper {
    @Test
    public void proteiniSearch() throws InterruptedException {
        String url = "https://ba.proteini.si/";
        String searchTerm = "majica";

        ProteiniSiHomePage homePage = new ProteiniSiHomePage(driver);
        homePage.searchTest(url, searchTerm);

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_list")));
        WebElement searchResults = driver.findElement(By.id("product_list"));
        List<WebElement> results = searchResults.findElements(By.className("product-card"));

        for (WebElement result : results) {
            String title = result.findElement(By.tagName("h4")).getText();
            softAssertion.assertTrue(title.toUpperCase().contains(searchTerm.toUpperCase()), "Article: \n" + title + "\n does NOT contain Search Term in the tittle!");
        }
        softAssertion.assertAll();

        Thread.sleep(3000);











    }







}
