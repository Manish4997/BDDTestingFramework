package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

public class ExcelUtilities {

	private static String ExcelSheetName = ProjectConfiguration.LoadProperties("ExcelSheetName");
	private static String ExcelFilePath = System.getProperty("user.dir") + "/testData/" + ExcelSheetName;
	private static Map<String, String> testDataMap;
	private static XSSFWorkbook testDataWorkBook;

	public static void loadExcelTestDataWorkBook() {
		if (testDataWorkBook == null) {
			try {
				FileInputStream fis = new FileInputStream(new File(ExcelFilePath));
				testDataWorkBook = new XSSFWorkbook(fis);

			} catch (FileNotFoundException e) {
				Assert.fail("No Test Data excel sheet found at location : " + ExcelFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private static String getCellValue(XSSFCell cell) {
		try {
			switch (cell.getCellType()) {

			case STRING:
				return cell.getStringCellValue();
			case NUMERIC:
				return Double.toString(cell.getNumericCellValue());
			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			default:
				break;

			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}

	public static int getScenarioColName(String ScenarioName, XSSFSheet sheet) {
		XSSFRow scNameRow = sheet.getRow(0);
		int colNo = scNameRow.getPhysicalNumberOfCells();
		for (int colNum = 1; colNum <= colNo; colNum++) {
			XSSFCell cell = scNameRow.getCell(colNum);
			String cellvalue = getCellValue(cell);
			if (cellvalue != null && !cellvalue.isBlank() && cellvalue.equalsIgnoreCase(ScenarioName)) {
				return colNo;
			}
		}
		return -1;

	}

	public static Map<String, String> getDataforScenario(String ScenarioName) {
		testDataMap = new HashMap<String, String>();
		try {
			if (testDataWorkBook == null) {
				loadExcelTestDataWorkBook();
			} else {
				System.out.println("WorkBook is already in memory");
			}
			if (ScenarioName != null) {
				XSSFSheet sheet = testDataWorkBook.getSheet(ScenarioName.split(",")[0].trim());
				int reqCol = getScenarioColName(ScenarioName.split(",")[1].trim(), sheet);
				System.out.println(reqCol);
				if (reqCol > 0) {
					testDataMap.put("ScenarioName", ScenarioName.split(",")[1].trim());
					int numRows = sheet.getPhysicalNumberOfRows();
					for (int row = 1; row < numRows; row++) {
						
						testDataMap.put(getCellValue(sheet.getRow(row).getCell(0)),
								getCellValue(sheet.getRow(row).getCell(reqCol-1)));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testDataMap;
	}
	public static void writeDatainOneRowforpopulation(String sheetname,String scenarioRow, List<String> data)
	{
		try {
			if (testDataWorkBook == null) {
				loadExcelTestDataWorkBook();
			} else {
				System.out.println("WorkBook is already in memory");
			}
			XSSFSheet sheet = testDataWorkBook.getSheet(sheetname);
		    int rowNumber=0;
		    for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
		    	if(sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(scenarioRow)) {
		    		for(int j=0;j<data.size();j++) {
		    			sheet.getRow(i).createCell(j+1).setCellValue(data.get(j).toString());
		    		}
		    	break;
		    	}
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(getDataforScenario("OrangeHRM,OrangeHrm_Scenario"));
	}
}
