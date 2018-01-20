package Main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import HomePageTest.homePage;

public class homePage_TC extends homePage{
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:\\Users\\balpreet\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.domain.com.au/");
		homePage.driverFireFox=driver;
		homePage.homePageMenu();
		homePage.driverFireFox.close();
		System.out.println("--> Automation Test passed");
	}
}
