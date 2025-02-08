package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import testBase.BaseClass;

public class ScreenshotUtility extends BaseClass {
          
	public static TakesScreenshot ts;
	
    public static String captureScreenshot(String tname) throws IOException {
    	
    	SimpleDateFormat sdf=new SimpleDateFormat("YYYY.MM.dd.hh.mm.ss");
    	Date dt=new Date();
    	String dates=sdf.format(dt);
    	
    	ts=(TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	
    	String Filepath=System.getProperty("user.dir")+"//screenshots//"+tname+"_Failed Screenshot_"+dates+".png";
    	
    	FileUtils.copyFile(source, new File(Filepath));
    	
//    	File target=new File(Filepath);
//    	
//    	source.renameTo(target);
//    
    	return Filepath;
    }
	
}
