package datadrivenframework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import datadrivenframework.constants.UIconstants;

public class PropertyReader {
	private Properties property;
	private FileInputStream fis;
	private String userdir = System.getProperty("user.dir");

	public PropertyReader() {
		property = new Properties();
		File file = new File(userdir + UIconstants.FILE_PATH);
		loadProperty(file);
	}
	
	public PropertyReader(String filepath) {
		property = new Properties();
		File file = new File(filepath);
		loadProperty(file);
	}
	
	public void loadProperty(File file) {	
			try {
				fis = new FileInputStream(file);
				property.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public String getProperty(String key) {
		String value = property.getProperty(key);
		return value;
	}
	
	public HashMap<String,String> getProperties(){
		HashMap<String,String> keyValue = new HashMap<String,String>();
	    Set<Object> obj = property.keySet();
	    for(Object keys : obj) {
	    	String key = (String) keys;
	    	String Value = property.getProperty(key);
	    	keyValue.put(key, Value);
	    }
		
		return keyValue;
	}

	public static void main(String[] args) {
		PropertyReader a = new PropertyReader();
		String value =a.getProperty("browser");
		HashMap<String,String> map = a.getProperties();
        System.out.println(value);
        System.out.println(map);
	}

}