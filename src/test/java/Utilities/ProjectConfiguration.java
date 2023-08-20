package Utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ProjectConfiguration {
   
	
private static String FilePath=System.getProperty("user.dir")+"/"+"Configuration/config.properties";
	
	public static String LoadProperties(String properties) {
		Properties property=new Properties();
		try {
		File fileobj= new File(FilePath);
		FileReader reader = new FileReader(fileobj);
		property.load(reader);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return property.getProperty(properties);
	}
	
	public static void main(String [] args) throws IOException {
		
	System.out.println("Properties from configuration: "+ProjectConfiguration.LoadProperties("base_url"));
		
		
	}
}
