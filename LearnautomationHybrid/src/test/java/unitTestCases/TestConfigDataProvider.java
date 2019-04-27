package unitTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;

public class TestConfigDataProvider {

	
	@Test
	public void testConfig()
	{
		ConfigDataProvider config=new ConfigDataProvider();
		
		String value=config.getPropertyValue("ToolName");
		
		Assert.assertTrue(value.contains("Selenium"),"Config Utility is not working");
		
	}
	
}
