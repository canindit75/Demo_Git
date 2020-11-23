package SeleniumPack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//taskkill /im IEDriverServer.exe /f
public class LaunchBrowsers {
	public static String browser ="chrome"; 
	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		//Launch Chrome Browser and navigate to a url google
		//To Launch chrome browser we need to create a instance ChromeDriver class
		//System.setProperty("webdriver.chrome.driver", "F:\\Trainings_Nov2020\\TL_ITC_Nov2020\\Softwares\\chromedriver_win32_86.0.4240.22\\chromedriver.exe");
		//Version of Chrome Browser 86 and driver 86.0.4240.22
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			//Firefox browser version 81.0.2 geckodriver Version 0.27.0
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		///short cut for import - Ctrl+Shift+O
		//2 more steps need to be included
		//zoom level must be 100%
		//Protected Mode Level - must be either enabled for all zones or disabled for all zones
		}
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		driver.close();
	}

}
