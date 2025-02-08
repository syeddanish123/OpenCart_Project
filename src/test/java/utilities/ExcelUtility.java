package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    String loc;
	
	public ExcelUtility(String loc) {
		
		this.loc=loc;
	}
	
	public int getcol(String sheet,int row) throws Exception {
		
		FileInputStream File=new FileInputStream(loc);
		XSSFWorkbook wb=new XSSFWorkbook(File);
		XSSFSheet st=wb.getSheet(sheet);
		
		int val=(st.getRow(row).getLastCellNum());
		
		  wb.close();
		    File.close();
		
		return val;
	}
	
	public int getrow(String sheet) throws Exception{
		
		FileInputStream File=new FileInputStream(loc);
		XSSFWorkbook wb=new XSSFWorkbook(File);
		XSSFSheet st=wb.getSheet(sheet);
		int rows=st.getLastRowNum();
		
		  wb.close();
		    File.close();
		return rows;
	}
	
	public String getcelldata(String sheet,int row,int cell) throws Exception{
		
		FileInputStream File=new FileInputStream(loc);
		XSSFWorkbook wb=new XSSFWorkbook(File);
		XSSFSheet st=wb.getSheet(sheet);
		int totalrow=st.getLastRowNum();
	    int totalcol=st.getRow(1).getLastCellNum();
		
	    XSSFCell Currentcell=st.getRow(row).getCell(cell);
	    String data=Currentcell.toString();
	    
	    DataFormatter formatter=new DataFormatter();
	    String vals=formatter.formatCellValue(Currentcell);
	    
	    wb.close();
	    File.close();
	    
	    return vals;
		
		
	}
}
