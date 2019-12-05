package com.kits.sit.Base_Setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BQUK_Agent_Flow {

	public static WebDriver driver;
	public static Properties prop;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\475742\\eclipse-workspace\\Automation\\src\\main\\java\\com\\qa\\property\\config.properties");
		prop.load(ip);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.equals("IE")) {
			System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver_win32\\chromedriver.exe");
			
		}
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//input[@id=\"user\"]")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		//Assert.
		//Assert.assertEquals(“.com+ Select your location”, "pagetitle");
		driver.findElement(By.xpath("//input[@id=\"location\"]")).sendKeys(prop.getProperty("location"));
		driver.findElement(By.xpath("//input[@id=\"confirmLocation\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		String homepagetitle = driver.getTitle();
		System.out.println(homepagetitle);
		
		
		
		
			
			

	}

}
