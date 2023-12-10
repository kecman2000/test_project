package tests;

import helpers.BaseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ProteiniSiLoginPage;

public class ProteiniSiLoginTest extends BaseHelper {
    @Test

    public void loginTest() throws InterruptedException {
        String url = "https://ba.proteini.si/";
        String email = "anakecman433@gmail.com";
        String password = "LozinkazaTest";


        ProteiniSiLoginPage loginPage = new ProteiniSiLoginPage(driver);
        loginPage.loginTest(url,email,password);

       wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("login-label")));
      WebElement userName = driver.findElement(By.className("login-label"));
        Assert.assertTrue("You are not login!", userName.getText().contains("ANA"));













    }






}














