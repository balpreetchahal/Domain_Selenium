package HomePageTest;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	
	public static WebDriver driverFireFox;
	public static void homePageMenu() throws InterruptedException{
	 int j = 1,i = 0;
	 // Below loop verifies all the home page menu links except "News" and "More"
	 String[] menuOptions = {"Buy","Rent","","Sold"};
	   for(i=0;i<7;i++,j++){
		driverFireFox.findElements(By.className("desktop-nav__menu-option")).get(i).click();
		if(i==0 || i==1 || i==3 ){
			assertTrue(menuOptions[i]+"page is not loaded correctly",driverFireFox.findElement(By.xpath("//div[@class='search-box-a__search-mode-nav']/button["+j+"]")).getAttribute("class").contains("is-selected"));
		}
		else if(i==2){
			assertTrue("New Homes page is not loaded correctly",driverFireFox.findElement(By.id("new-homes-searchbg")).isDisplayed());
		}
		else if(i==4){
			assertTrue("Commercial page is not loaded correctly",driverFireFox.findElement(By.className("homepage-tag-line")).isDisplayed());
	         i++;
		}
		else if (i==6){
			assertTrue("Agent page is not loaded correctly",driverFireFox.findElement(By.className("find-an-agent__content-title")).isDisplayed());
		}
		driverFireFox.navigate().back();
	   }
	// Below loop verifies "News" drop down options
	 String[] newsOptions = {"","News", "Advice", "Living","Money & Markets", "Domain"};
	  for(int l=1;l<6;l++){
		driverFireFox.findElements(By.className("desktop-nav__menu-option")).get(5).click();
		driverFireFox.findElement(By.xpath("//ul[@class='desktop-nav__dropdown-content']/li["+l+"]")).click();
        if(l==5){	
        	assertTrue("Video page is not loaded correctly",driverFireFox.findElement(By.xpath("//div[@class='header mT-headerMultimedia span-24']/p[1]")).getText().contains("Domain")); 
	    }else{
			assertTrue(newsOptions[l]+"page is not loaded correctly",driverFireFox.findElement(By.xpath("//div[@class='breadcrumbs']/ul[1]/li[2]")).getText().contains(newsOptions[l]));
		    }
        driverFireFox.navigate().back();
	   }
    // Below loop verifies "More" drop down options
	 String[] xpath = {"","[@id='domain-home-content']/header[1]","[@class='card plain invisible']","[@class='sales-results-landing-hero']/header[1]","[@class='hoods-suburb-search-inner-wrap']/header[1]","[@class='LhQgwmpi8FZoKEDcMR7LP']/div[1]","[@class='hero-wrap']"};
	 String[] moreOptions ={"","Find your perfect home","Home Price Guide","Auction results","Suburb profiles","Get the right loan at a great rate","Showcase your property with Domain and gain greater exposure"};
	   for(int m=1;m<7;m++){
			driverFireFox.findElements(By.className("desktop-nav__menu-option")).get(7).click();
			driverFireFox.findElement(By.xpath("//ul[@class='desktop-nav__dropdown-content']/li["+m+"]")).click();
			assertTrue(moreOptions[m]+"page is not loaded correctly",driverFireFox.findElement(By.xpath("//div"+xpath[m]+"/h1[1]")).getText().contains(moreOptions[m]));
			driverFireFox.navigate().back();
		}
	   }
}
