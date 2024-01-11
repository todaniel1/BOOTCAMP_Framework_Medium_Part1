package com.bootcamp_part1_Medium_submission;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	public WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstNameInput;

	@FindBy(id = "input-lastname")
	private WebElement lastNameInput;

	@FindBy(id = "input-email")
	private WebElement emailInput;

	@FindBy(id = "input-telephone")
	private WebElement telephoneInput;

	@FindBy(id = "input-password")
	private WebElement passwordInput;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordInput;

	@FindBy(name = "agree")
	private WebElement agreeCheckbox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openRegistrationPage() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

	}

	public void enterFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);

	}

	public void enterLastName(String lastName) {
		lastNameInput.sendKeys(lastName);

	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);

	}

	public void enterTelephone(String telephone) {
		telephoneInput.sendKeys(telephone);

	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);

	}

	public void confirmPassword(String confirmPassword) {
		confirmPasswordInput.sendKeys(confirmPassword);

	}

	public void checkAgreeCheckbox() {
		agreeCheckbox.click();

	}

	public void clickContinueButton() {
		continueButton.click();
	}
}
