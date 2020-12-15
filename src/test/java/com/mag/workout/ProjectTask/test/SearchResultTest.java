package com.mag.workout.ProjectTask.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mag.workout.ProjectTask.page.Home;
import com.mag.workout.ProjectTask.page.SearchListPage;
import com.mag.workout.ProjectTask.page.SearchListPage.SearchItem;

public class SearchResultTest extends BaseTest {

	@Test
	public void testSearchResults() {
		SoftAssert assertion = new SoftAssert();

		Home home = new Home(driver);
		assertion.assertEquals(home.getTitle(), Home.TITLE);
		home.search("Lenova laptop");

		SearchListPage listPage = new SearchListPage(driver);
		assertion.assertEquals(listPage.getTitle(), SearchListPage.TITLE);

		List<SearchItem> searchItems = listPage.getSearchItems();

		/*
		 * Print all names
		 */
		int totalCount = 0;
		StringBuffer totalBuffer = new StringBuffer();

		for (SearchItem searchItem : searchItems) {
			totalBuffer.append(searchItem.getName() + "\n");
			totalCount++;
		}
		System.out.println();
		System.out.println("Total Items: " + totalCount);
		System.out.println(totalBuffer);

		/*
		 * Check any duplicates
		 */

		int duplicateCount = 0;
		StringBuffer duplicateBuffer = new StringBuffer();
		Set<String> unique = new HashSet<>();
		for (SearchItem searchItem : searchItems) {
			boolean add = unique.add(searchItem.getName());
			if (!add) {
				duplicateCount++;
				duplicateBuffer.append(searchItem.getName() + "\n");
				assertion.fail("Contains Duplicate Items");
			}
		}
		System.out.println();
		System.out.println("Duplicate Items: " + duplicateCount);
		System.out.println(duplicateBuffer);

		/*
		 * Price >35000
		 */
		int itemsGreatThan35000Count = 0;
		StringBuffer itemsGreatThan35000Buffer = new StringBuffer();
		for (SearchItem searchItem : searchItems) {
			double price = getPrice(searchItem.getPrice());
			if (price > 35000) {
				itemsGreatThan35000Count++;
				itemsGreatThan35000Buffer.append(price + " " + searchItem.getName() + "\n");
			}
		}
		System.out.println();
		System.out.println("Items Price >35000: " + itemsGreatThan35000Count);
		System.out.println(itemsGreatThan35000Buffer);

		assertion.assertAll();
	}

	private double getPrice(String price) {
		price = price.substring(1);
		price = price.replace(",", "");
		return Double.parseDouble(price);
	}

}
