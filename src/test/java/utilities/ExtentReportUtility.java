package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlGroups;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportUtility implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentreporter;
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
	    
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY.MM.dd.hh.mm.ss");
    	Date dt=new Date();
    	String dates=sdf.format(dt);
    	
    	String path=System.getProperty("user.dir")+"//reports//TestExecution_Report_"+dates+".html";
		sparkReporter=new ExtentSparkReporter(path);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Functional Test Reports");
		sparkReporter.config().setReportName("OpenCart_TestReport");
		
		extentreporter=new ExtentReports();
		extentreporter.attachReporter(sparkReporter);
		extentreporter.setSystemInfo("Browser",context.getCurrentXmlTest().getParameter("browser"));
		extentreporter.setSystemInfo("os",context.getCurrentXmlTest().getParameter("os"));
        
		extentreporter.setSystemInfo("Reporter Name",System.getProperty("user.name"));
	
		List<String> group=context.getCurrentXmlTest().getIncludedGroups();
		extentreporter.setSystemInfo("Groups", group.toString());
		
		context.getCurrentXmlTest().addExcludedGroup("datadriven");
	}
	
	public void onTestSuccess(ITestResult result) {
	    
		test=extentreporter.createTest(result.getTestClass().getName());
//Common steps: --		
		test.assignCategory(result.getMethod().getGroups());
		
	    test.log(Status.PASS,result.getName()+"Got passed");
	    
	}
	
	public void onTestFailure(ITestResult result) {
	    
		test=extentreporter.createTest(result.getTestClass().getName());
//Common steps: --	
		test.assignCategory(result.getMethod().getGroups());
		
	    test.log(Status.FAIL,result.getName()+"Got Failed");
        test.log(Status.INFO,result.getThrowable().getMessage());
	    
	    try {
	          
	    	String ss=new BaseClass().captureScreenshot(result.getName());
	        test.addScreenCaptureFromPath(ss);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		
	  }
	
	public void onTestSkipped(ITestResult result) {
	
		test=extentreporter.createTest(result.getTestClass().getName());
		//Common steps: --	
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,result.getName()+"got skipped");
		test.log(Status.INFO,result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext context) {
	    
		extentreporter.flush();
	  }
}
