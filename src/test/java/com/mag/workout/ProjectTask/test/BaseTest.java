package com.mag.workout.ProjectTask.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.mag.workout.ProjectTask.driver.DriverFactory;

public class BaseTest {
	protected WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	public void setUp(String browser) {
		driver = DriverFactory.createDriver(browser);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
