package org.qed42.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestBase {
	public static WebDriver driver;
	
	public static File configFile;
	public static FileInputStream configFis;
	
	
	public static void readConfigPropFIle() {
		 configFile=new File("../SeleniumTask/src/test/java/org/qed42/resources/Config.properties");
		try {
			 configFis=new FileInputStream(configFile);
		    Properties configProp=new Properties();
		    configProp.load(configFis);
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
public static void invokeBrowser() 
{
		
	}

}
