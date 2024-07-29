package com.ohrm.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class OrangeHRMBase {
	public static WebDriver driver;
	public static Properties prop;
	
public void initialization() {
	propertyfileconfiguration();
	String browsername = prop.getProperty("browser");
	if (browsername.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}else if(browsername.equalsIgnoreCase("firefox")){
		driver=new FirefoxDriver();
	}else if(browsername.equalsIgnoreCase("ie")) {
		driver=new InternetExplorerDriver();
	}else if(browsername.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
		}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(prop.getProperty("url"));
}
public void teardown() {
	driver.quit();
}
public void propertyfileconfiguration() {
	String configfilepath = "./src/main/java/com/ohrm/config/config.properties";
	prop=new Properties();
	FileReader reader;
	try {
		reader=new FileReader(configfilepath);
		prop.load(reader);
	} catch (IOException e) {
		System.out.println("Unable to find the file");
		e.printStackTrace();
	}}
public static void CaptureScreenshot(String name) {
	String path="./Screenshot/"+name+".png";
	//to take screenshot
	TakesScreenshot ts=(TakesScreenshot)driver;
	File Scrnshot=ts.getScreenshotAs(OutputType.FILE);
	try {
	Files.copy(Scrnshot, new File(path));
}catch(IOException e) {
	e.printStackTrace();
}
}
}

