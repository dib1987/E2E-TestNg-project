package com.orangehrmlive.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Base_Setup {
	
	
	
	
	public WebDriver driver;
	public static Properties prop;
	
	public Base_Setup() {
		
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\work\\DemoProject\\src\\main\\java\\Property\\config.properties");
			prop.load(ip);
			initialization();
			
			
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			driver = (WebDriver) new ChromeDriver(options);
			
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","C:\\work\\chromedriver_win32\\chromedriver.exe");
			
		}
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		//driver.get("facebook.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	//*public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Base_Setup.initialization();

	}
	


