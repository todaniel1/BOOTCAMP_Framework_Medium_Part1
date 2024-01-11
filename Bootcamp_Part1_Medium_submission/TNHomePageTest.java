package com.Bootcamp_Part1_Medium_submission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TNHomePageTest {
	public WebDriver driver;
	public HomePage homepage;

	@BeforeMethod
	public void openHomepage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		homepage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void homepageTest() {

		Assert.assertTrue(homepage.myaccount().isDisplayed());
		Assert.assertTrue(homepage.shopping_cart().isDisplayed());
		System.out.println("This is Home page");

	}

	@Test(priority = 3)
	public void navigateToHomePageAndVerifyElement() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rediff.com");

		String actualTitle = driver.getTitle();
		String expectedTitle = "Rediff.com: News | Rediffmail | Stock Quotes | Shopping";
		String actualCurrenturl = driver.getCurrentUrl();
		String expectedCurrenturl = "https://www.rediff.com/";

		WebElement logo = driver.findElement(By.xpath("//span[@class = 'hmsprite logo']"));
		WebElement createAccountLink = driver.findElement(By.linkText("Create Account"));

		if (actualTitle.equals(expectedTitle) && logo.isDisplayed() && createAccountLink.isEnabled()) {
			System.out.println("Landing Page is correct");
			driver.findElement(By.className("signin")).click();
		} else {
			System.out.println("Landing Page is incorrect");
		}

		System.out.println("Login page title is: " + driver.getTitle());
		System.out.println("Login page current url is: " + driver.getCurrentUrl());

		String actutalTitleLoginPage = driver.getTitle();
		String expectedTitleLoginPage = "Rediffmail";

		String actualCurrentUrlLoginPage = driver.getCurrentUrl();
		String expectedCurrentUrlLoginPage = "https://mail.rediff.com/cgi-bin/login.cgi";

		WebElement usernameTextbox = driver.findElement(By.id("login1"));
		WebElement passwordTextbox = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.name("proceed"));
		Thread.sleep(3000);
		if (actutalTitleLoginPage.equals(expectedTitleLoginPage)&& actualCurrentUrlLoginPage.equals(expectedCurrentUrlLoginPage) && usernameTextbox.isDisplayed()
				&& passwordTextbox.isEnabled()) {
			usernameTextbox.sendKeys("seleniumpanda@rediffmail.com");
			passwordTextbox.sendKeys("Selenium@123");
			loginButton.click();
		} else {
			System.out.println("Login Page is not valdiated");
		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
