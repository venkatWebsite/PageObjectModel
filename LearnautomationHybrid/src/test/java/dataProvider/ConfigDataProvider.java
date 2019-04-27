package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	
	Properties pro;
	
	public ConfigDataProvider()
	{
		
		try {
			FileInputStream fis=new FileInputStream(new File("./Configuration/Project.properties"));
			
			pro=new Properties();
			
			pro.load(fis);
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found "+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("File not loaded "+e.getMessage());

		}
		
		
	}
	
	public String getPropertyValue(String key)
	{
		return pro.getProperty(key);
	}
	
	public String getStagingURL()
	{
		return pro.getProperty("stagingURL");
	}
	
	public String getProURL()
	{
		return pro.getProperty("proURL");
	}
	
	
}
