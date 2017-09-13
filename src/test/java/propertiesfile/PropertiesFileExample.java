package propertiesfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileExample {

	public static void main(String[] args) {
		try {
			//create properties file
			// instead of GoogleTranslateWithProperties we used onl "  . " dat// nokta,its means class name
			//path the proporties file
			String filePath="./src/test/resources/testdata/configuration.properties";
			//open the proporties file using FileInputStream
			FileInputStream input=new FileInputStream(filePath);
			//create object of properties class
			Properties config=new Properties();
			//load all the data provided by fileinput stream
			config.load(input);
			//close the inputstream file to free up the memory
			input.close();
			
			System.out.println(config.getProperty("toLanguage"));
			System.out.println(config.getProperty("url"));
			System.out.println(config.getProperty("drivertype"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Hey file not there");// if we break code its gonna print this
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After try catch");
	}

}
