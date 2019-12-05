package com.kits.sit.Base_Setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class E2E_Flow {

	
	public static WebDriver driver;
	public static Properties prop;
	public static HSSFSheet ExcelWSheet;
	public static HSSFWorkbook ExcelWBook;
	public static HSSFCell Cell;
	public static HSSFSheet sheet;
	//public static String SheetName;
	public static HSSFRow row;
	public static String Path = "C:\\work\\TestData.xls";
	public static String SheetName ="login";
	
	public static void launchBrowser() throws IOException {
		
		
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
	}
	
	public static void setExcelFile(String Path,String SheetName) throws IOException {
		
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelWBook = new HSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		
		
	}
	public static String getCelldata(int RowNum,int ColNum) {
		
		DataFormatter formatter = new DataFormatter();
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = formatter.formatCellValue(Cell);
		return CellData;
	}
	
	public static void verifyLogin() throws IOException {
		
		E2E_Flow.setExcelFile(Path, SheetName);
		//E2E_Flow.getCelldata(RowNum, ColNum)
		driver.findElement(By.xpath("//input[@id=\"user\"]")).sendKeys(E2E_Flow.getCelldata(1, 0));
		driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys(E2E_Flow.getCelldata(1, 1));
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
	}
	
	public static void verifyLocation() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id=\"location\"]")).sendKeys(prop.getProperty("location"));
		driver.findElement(By.xpath("//input[@id=\"confirmLocation\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		String homepagetitle = driver.getTitle();
		System.out.println(homepagetitle);
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		E2E_Flow.launchBrowser();
		E2E_Flow.verifyLogin();
		E2E_Flow.verifyLocation();

	}

}
