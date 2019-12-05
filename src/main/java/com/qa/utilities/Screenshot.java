package com.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.commons.io.FileUtils;

import com.kits.sit.Base_Setup.Base_Setup;

public class Screenshot extends Base_Setup {

	
	public static void takeScreenshot(String result) {
		
		TakesScreenshot s = ((TakesScreenshot)driver);
		File src = s.getScreenshotAs(OutputType.FILE);
		
		try {
			
			// now copy the screenshot to desired location using //
			
			FileUtils.copyFile(src,new File("C:/work/"+result+"screenshot.png"));
		}
		catch (IOException e)
		{
			
			System.out.println(e.getMessage());
		}
		
		
	}
}
