package tests;

import helpers.BaseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

public class ProteiniSiOrderingTest extends BaseHelper {
    @Test
    public void orderingProduct() throws InterruptedException {
        String url = "https://ba.proteini.si/";
        String searchTerm = "protein";
        String name = "Mila";
        String priimek = "Lico";
        String address = "Vidovdanska 56";
        String email = "mila67@gmail.com";
        String number = "058476318";



        ProteiniSiSearchProductPage orderingHP = new ProteiniSiSearchProductPage(driver);
        orderingHP.searchTest(url,searchTerm);

        ProteiniSiProductsPage resultsPage = new ProteiniSiProductsPage(driver);
        resultsPage.selectProduct();


        ProteiniSiProductPage productPage = new ProteiniSiProductPage(driver);
        productPage.selectDetails();
        Thread.sleep(3000);

        ProteiniSiConfirmOrderPage orderPage = new ProteiniSiConfirmOrderPage(driver);
        orderPage.continueOrdering();


        ProteiniSiOrderingWithoutRegistrationPage withoutRegistrationPage = new ProteiniSiOrderingWithoutRegistrationPage(driver);
        withoutRegistrationPage.continueWithOrdering();
        Thread.sleep(1000);


        ProteiniSiInputDataPage inputDataPage = new ProteiniSiInputDataPage(driver);
        inputDataPage.fillForm(name, priimek, address,email,number);
        Thread.sleep(2000);

        WebElement narudzba =wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout-section")));
        Assert.assertTrue("The order is not finished.",narudzba.getText().contains("HVALA ZA NARUDŽBU"));


















    }




















}
