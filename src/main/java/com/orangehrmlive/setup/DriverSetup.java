package com.orangehrmlive.setup;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {
	
	public WebDriver driver;
	public static Properties prop;
	
	public DriverSetup() {			
		prop = new Properties();
		String propFileName = "config.properties";
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);		
			if (inputStream !=null) {
				prop.load(inputStream);
				initialization();
			}else {
				throw new FileNotFoundException(
						String.format("property file % not found in the classpath",propFileName));
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
            WebDriverManager.chromedriver().setup();
            if(!display) options.addArguments("--headless");
            driver = new ChromeDriver(options);
            break;
        case "firefox":
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            if(!display) firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
            break;
        default:
            throw new IllegalArgumentException(String.format("The given browser %s, is not supported", browserName));
    }
    driver.manage().timeouts().implicitlyWait(WaitingTimeSetup.getTimeToImplicitlyWait(), TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(WaitingTimeSetup.getTimeForPageLoad(), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));		
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	
	
}
	


