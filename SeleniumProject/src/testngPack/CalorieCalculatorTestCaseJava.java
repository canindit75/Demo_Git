package testngPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalorieCalculatorTestCaseJava {
	WebDriver driver = null;
	@BeforeClass
	public void LaunchBrowser() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(); 
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
	}	
	
	@Test(dataProvider="EnterCalorieDetails")
	//@Test(dataProvider="dprovider")
	public void EnterCalorieDetails(String age, String gendr){
		System.out.println(age + " " + gendr);
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear();
		ageTextbox.sendKeys("45"); /*
		System.out.println(ageTextbox.getTagName());
		System.out.println(ageTextbox.getAttribute("id"));
		System.out.println(ageTextbox.getAttribute("name"));
		System.out.println(ageTextbox.getAttribute("type"));
		System.out.println(ageTextbox.getAttribute("class"));
		System.out.println(ageTextbox.getAttribute("value"));
		List<WebElement> genderList = driver.findElements(By.name("csex"));
		if( genderList.size() > 0){
			for(WebElement gender: genderList){
				if(gender.getAttribute("value").equals(gendr)){
					if(!gender.isSelected()){
						gender.click();
						break;
					}
				}
			}
		}
*/	}
	
	
	@DataProvider(name = "EnterCalorieDetails")
	public Object[][] dprovider(){
		String[][] data = new String[2][2];
		data[0][0] = "45";
		data[0][1] = "f";
		data[1][0] = "45";
		data[1][1] = "m";		
		return data;
	}
	
	@AfterClass	
	public void closebrowser() throws InterruptedException{
/*		Thread.sleep(3000);
		if(driver!=null){
			driver.close();
		}
*/	}
}
