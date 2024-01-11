package com.Bootcamp_Part1_Medium_submission;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class HomePage {
	  WebDriver driver;
	  
	  public HomePage(WebDriver driver) {
		  this.driver = driver;
		  
		  PageFactory.initElements(driver,this);
		  
		  }
	  
	  @FindBy(linkText = "My Account")
	    private WebElement myaccount;
	  
	  @FindBy(linkText = "Shopping Cart")
	  private WebElement shopping_cart;
	  
	  @FindBy(xpath="//div[@class='input-group']/descendant::input[@type='text']")
	  private WebDriver searchbox;
	  
	  @FindBy(css="button.btn.btn-default.btn-lg")
	  private WebDriver search_Button;
	  
	  
	  public WebElement myaccount() {
		  return myaccount;
	  }
	  
	 public WebElement shopping_cart() {
		 return shopping_cart;
	  }
	 public WebDriver searchbox() {
		 return searchbox;
	 }
	 public WebDriver search_Button() {
		 return search_Button;
	 }
	}

