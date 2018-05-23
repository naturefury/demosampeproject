package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;



import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import SeleniumPackage.TestAttributes;



public class Reporter extends TestAttributes {

	private static ExtentTest test;
	private static ExtentReports extent;
	//static String a= new SimpleDateFormat("YYYY-MM-DD_HH:MM:SS").format(new Date());
	static String a= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
	static int number=1;
	@Test
	public static void report(String desc,String status, String methoddesc) throws Throwable
	{

		
		//long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;

		try {
			FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) , new File(userpath+"/reports/Run_"+i+"/images/step "+number+"_"+methoddesc+".jpg"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

		// Write if it is successful or failure or information
		if(status.toUpperCase().equals("PASS")){
			test.log(LogStatus.PASS, desc+test.addScreenCapture(userpath+"\\reports\\Run_"+i+"\\images\\step "+number+"_"+methoddesc+".jpg"));
		}else if(status.toUpperCase().equals("FAIL")){
			test.log(LogStatus.FAIL, desc+test.addScreenCapture(userpath+"\\reports\\Run_"+i+"\\images\\step#"+number+"_"+methoddesc+".jpg"));
			//throw new RuntimeException("FAILED");
		}else if(status.toUpperCase().equals("INFO")){
			test.log(LogStatus.INFO, desc);
		}
		number++;
	}


	public static void startResult(){

		extent = new ExtentReports(userpath+"\\reports\\Run_"+i+"\\"+a+"_cyclos_Run "+i+".html", false);
		
		File filee=new File(userpath+"\\extent-config.xml");
		extent.loadConfig(filee);

	}

	public static void startTestCase(String iData){
		test=extent.startTest(iData);
	}

	public static void endtest(){
		extent.endTest(test);
	}

	public static void endflush(){

		extent.flush();
	}



}

