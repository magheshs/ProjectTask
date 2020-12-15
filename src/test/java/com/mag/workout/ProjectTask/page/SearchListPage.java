package com.mag.workout.ProjectTask.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchListPage extends BasePage {
	public final static String TITLE =
			"Lenovo Laptop - Buy Products Online at Best Price in India - All Categories | Flipkart.com";
	@FindBy(css = "div._4rR01T")
	private List<WebElement> itemsNames;

	@FindBy(css = "div._30jeq3._1_WHN1")
	private List<WebElement> itemsPrice;

	public SearchListPage(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public List<SearchItem> getSearchItems() {
		List<SearchItem> searchItems = new ArrayList<>();
		for (int i = 0; i < itemsNames.size(); i++) {
			searchItems.add(new SearchItem(itemsNames.get(i).getText(), itemsPrice.get(i).getText()));
		}
		return searchItems;
	}

	public static class SearchItem {
		private String name;
		private String price;

		public SearchItem(String name, String price) {
			super();
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

	}
}
