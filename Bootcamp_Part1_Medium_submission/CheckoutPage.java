package com.Bootcamp_Part1_Medium_submission;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class CheckoutPage {

		@FindBy(name = "search")
		private WebElement searchBox;

		@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
		private WebElement searchButton;

		@FindBy(linkText = "HP LP3065")
		private WebElement productLink;

		@FindBy(xpath = "//button[@id='button-cart']")
		private WebElement addToCartButton;

		@FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
		private WebElement cartButton;

		@FindBy(xpath = "//span[@id='cart-total']")
		private WebElement cartTotal;

		@FindBy(xpath = "//strong[normalize-space()='View Cart']")
		private WebElement ViewCart;
		
		@FindBy(linkText = "HP LP3065")
		private WebElement productTitle;
		

		public CheckoutPage(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}

		public void searchProduct(String productName) {

			searchBox.sendKeys(productName);

			searchButton.click();

		}

		public void addProductToCart() throws Exception {

			productLink.click();

			addToCartButton.click();

			Thread.sleep(2000);

			cartButton.click();

		}

		public String getCartTotal() {

			return cartTotal.getText();

		}

		public void proceedToCheckout() {

			ViewCart.click();
		}

			public boolean isProductInCheckout(String expectedProductName) {
				return productTitle.getText().contains(expectedProductName);

		}

	}



