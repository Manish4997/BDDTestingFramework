package Utilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.io.File;


import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	 private static String DataSheetName=ProjectConfiguration.LoadProperties("DataSheet");
	    private static String ExcelSheetName=ProjectConfiguration.LoadProperties("ExcelSheetName");
		private static String ExcelFilePath=System.getProperty("user.dir")+"/testData/"+ExcelSheetName;
	    private static HashMap<String,String> ExcelData;
	    
		public static String get(String testcasename,String columnname) {
			FileInputStream file;
			int x=0;
			int k=0;
			ExcelData=new HashMap<String,String>();
			try {
				file=new FileInputStream(new File(ExcelFilePath));
				
				@SuppressWarnings("resource")
				XSSFWorkbook wb=new XSSFWorkbook(file);
				XSSFSheet sh=wb.getSheet(DataSheetName);
				
				for(int i=0;i<sh.getPhysicalNumberOfRows();i++) {
					for(int j=0;j<sh.getRow(i).getPhysicalNumberOfCells();j++) {
					     if(sh.getRow(i).getCell(j,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").equalsIgnoreCase("Keyword")) {
					    	 x=j;
					     }
					     if(sh.getRow(i).getCell(j,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").equalsIgnoreCase("Keyword")) {
					    	 k=j;
					     }
					     if(sh.getRow(i).getCell(j,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").equalsIgnoreCase("testcasename")) {
					    	 ExcelData.put(sh.getRow(i).getCell(x,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", ""), 
					    			 sh.getRow(i).getCell(k,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", ""));
					    	 
					     }
					}
					
					
				}
					
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return ExcelData.get(testcasename); 
			
			
			
			
		}
			
			
		public static void main(String[] args) {		
			
			
			
			
			
			
			
			
		}
}
