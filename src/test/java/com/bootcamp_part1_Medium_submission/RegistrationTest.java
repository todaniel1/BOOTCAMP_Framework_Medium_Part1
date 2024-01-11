package com.bootcamp_part1_Medium_submission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
	public WebDriver driver;
	public RegistrationPage registrationPage;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		registrationPage = new RegistrationPage(driver);
		registrationPage.openRegistrationPage();
	}

	@Test
	public void testSuccessfulRegistrationWithValidCredentials() {

		registrationPage.enterFirstName("John");
		registrationPage.enterLastName("Doe");
		registrationPage.enterEmail("johnwee.doe@example.com");
		registrationPage.enterTelephone("1234567890");
		registrationPage.enterPassword("password123");
		registrationPage.confirmPassword("password123");
		registrationPage.checkAgreeCheckbox();
		registrationPage.clickContinueButton();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div[id='content'] h1")).isDisplayed());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
