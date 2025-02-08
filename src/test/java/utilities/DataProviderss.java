package utilities;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderss {

	
	@DataProvider(name="dp")
	public Object[][] getdata() throws Exception {
		
		ExcelUtility excelutil=new ExcelUtility(System.getProperty("user.dir")+"\\testData\\DatatrivenTestData.xlsx");
		int totalrow=excelutil.getrow("Sheet1");
		int totalcell=excelutil.getcol("Sheet1",1);
		
		Object a[][]=new Object[totalrow][totalcell];
		
	try {
			
		for(int i=1;i<=totalrow;i++)
		{
			for(int j=0;j<totalcell;j++)
			{
				
				 a[i-1][j]=excelutil.getcelldata("Sheet1",i,j);
			}
		}
	
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	return a;
	   	
	}
	
}
