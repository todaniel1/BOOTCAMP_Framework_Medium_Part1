package com.bootcamp_part1_Medium_submission;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutPageTest {
    
private WebDriver driver;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo");
        checkoutPage = new CheckoutPage(driver);
        
    }

    @Test
    public void testAddProductToCartAndVerify() throws Exception {
        checkoutPage.searchProduct("HP");
        checkoutPage.addProductToCart();
        checkoutPage.proceedToCheckout();
        String expectedProductName = "HP LP3065" ;
        boolean isProductCorrect = checkoutPage.isProductInCheckout(expectedProductName);

        System.out.println("Is the correct product displayed on the checkout page? " + isProductCorrect);

        Assert.assertTrue(isProductCorrect, "Incorrect product displayed on the checkout page");
           }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

