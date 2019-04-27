package unitTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;

public class TestExcelDataProvider {

	
	@Test
	public void testExcel()
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		
		String value=excel.getStringCellData("testing", 0, 1);
		
		Assert.assertTrue(value.contains("Selenium"),"Excel Utility is not working");
		
	}
	
}
