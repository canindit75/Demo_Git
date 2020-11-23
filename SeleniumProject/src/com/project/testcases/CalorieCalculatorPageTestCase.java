package com.project.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.project.pages.BMIPage;
import com.project.pages.CaloriePage;
import com.project.pages.CaloriePage2;
import com.project.pages.CaloriePage3;
import com.project.utils.PropertyReader;

public class CalorieCalculatorPageTestCase {
	WebDriver driver = null;
	@Test
	public void EnterCalorieDetails() throws IOException{
		System.setProperty("webdriver.chrome.driver", PropertyReader.ReadProperty("chromedriverpath"));
		driver = new ChromeDriver();
		driver.get(PropertyReader.ReadProperty("appurl"));
		  
		//Instance of CaloriePage
		//Page Object Implementation without PageFactory
		CaloriePage cp = new CaloriePage(driver);
		cp.EnterCalorieDetails("45", "f");
		
		//Page Object Model Implementation with PageFactory for intiializing page elements in the constructor
		CaloriePage2 cp2 = new CaloriePage2(driver);
		cp2.EnterCalorieDetails("75", "f");
		
		//Page Object Model Implementation with PageFactory - initializing page elements in the testcase
		CaloriePage3 cp3 = new CaloriePage3(driver);
		cp3 = PageFactory.initElements(driver, CaloriePage3.class);
		cp3.EnterCalorieDetails("67", "m");
		
		BMIPage bp = new BMIPage(driver);		
		cp2 = bp.CalorieLinkClick();
		cp2.EnterCalorieDetails("90", "f");
    }
}
