package com.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaloriePage {
 /* @FindBy(id="cage") */	
  WebElement ageTextbox;
  
 // @FindBy(name="csex")
  List<WebElement> genderList;
  WebDriver driver;
  public CaloriePage(WebDriver driver){
	  this.driver = driver;
	  //THeat ia wtih PageFactory, Page Elements Intialization
	// PageFactory.initElements(driver, this);
  }
  
  public void EnterCalorieDetails(String age, String sex){
	   ageTextbox = driver.findElement(By.id("cage"));
  	   ageTextbox.clear();
	   ageTextbox.sendKeys(age);
	  
	    List<WebElement> genderList = driver.findElements(By.name("csex"));
		if(genderList.size()>0){
			for(WebElement gender : genderList){
				if(gender.getAttribute("value").equals(sex))
				{
					if(!gender.isSelected()){
						gender.click();
						break;
					}
				}
			}
		}		
  }
}
