package Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Common{

public static WebDriver driver;
public ExtentReports extent;
public ExtentTest extenttet; 

@BeforeTest
public void lunch()
{
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("");	
	
}

@BeforeSuite
public void setup()
{
	ExtentSparkReporter SparkReporter = new ExtentSparkReporter("Screenshots/Test.html");
	extent = new ExtentReports();
	extent.attachReporter(SparkReporter);
}

@AfterSuite()
public void flush()
{
	if(extent !=null)
	{
		extent.flush();
	}
}
	@AfterMethod
	public void captureScreenshot(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshotpath=capturescreenshot(driver);
			extenttet.log(Status.FAIL,"Test failed :  "  + result.getThrowable());
			extenttet.addScreenCaptureFromBase64String(screenshotpath);
			
		}
	}

			public String capturescreenshot(WebDriver driver)
			{
				TakesScreenshot ts	=(TakesScreenshot)driver;
				return ts.getScreenshotAs(OutputType.BASE64);
			}
}
