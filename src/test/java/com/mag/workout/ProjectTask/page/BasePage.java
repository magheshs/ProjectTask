package com.mag.workout.ProjectTask.page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
