package com.orangehrmlive.setup;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.String.format;

public class DriverSetup {
	
	public WebDriver driver;
	public static Properties prop;
	
	//private static String WINDOWS_DRIVER = "driver/chromedriver.exe";
	
	//Added by Dibyendu//
	public static String path = System.getProperty("user.dir");
	
	public DriverSetup() {			
		prop = new Properties();
		String propFileName = "config.properties";
		try {
			InputStream inputStream = new FileInputStream(propFileName);
			if (inputStream !=null) {
				prop.load(inputStream);
				initialization();
			}else {
				throw new FileNotFoundException("property file not found in the classpath");
			}
		}catch (IOException ex) {
			System.out.println(ex);
		}
	}
	
	private void initialization() {
		String browserName = prop.getProperty("browser");
		switch (browserName.toLowerCase()){
	        case "chrome":
	            ChromeOptions options = new ChromeOptions();
	            
	            //String sDriver =getClass().getClassLoader().getResource(WINDOWS_DRIVER).getFile();
	            //System.setProperty("webdriver.chrome.driver", urlDecode(sDriver) );
	            
	            System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\java\\resource\\chromedriver.exe" );
	            driver = new ChromeDriver(options);
	            break;	        
	        default:
	            throw new IllegalArgumentException(format("The given browser %s, is not supported", browserName));
	    }
		driver.manage().timeouts().implicitlyWait(WaitingTimeSetup.getTimeToImplicitlyWait(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(WaitingTimeSetup.getTimeForPageLoad(), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));		
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	private static String urlDecode(String value)  {
        try {
            return java.net.URLDecoder.decode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
	
}
	


