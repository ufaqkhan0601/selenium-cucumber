package com.cucumber.step_definitions;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.cucumber.helpers.ObjectRepository;
import atu.testrecorder.ATUTestRecorder;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import junit.framework.TestCase;

public class Hooks extends TestCase {
	public static WebDriver driver;
	ATUTestRecorder recorder;
	static String tcName;
static int i=0;
public static Properties config=null;
	@Before
	public void openBrowser(Scenario scenario) throws Exception {
		config = ObjectRepository.ObjectRepo(System.getProperty("user.dir")+"//src//test//resources//Config.properties");
		if(i==0)
		{
			FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + "/RecordedVideos/"));
			i++;
		}
		tcName = scenario.getName();
		recorder = new ATUTestRecorder(System.getProperty("user.dir") + "/RecordedVideos/", "TestVideo-" + tcName,
				false);
		recorder.start();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@After
	public void embedScreenshot(Scenario scenario) throws Exception {
		try {
		if (scenario.isFailed()) {
			
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}

	}
	
	

}