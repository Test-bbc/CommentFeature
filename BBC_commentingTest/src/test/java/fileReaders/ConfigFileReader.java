/*class to read property files and define appropriate methods to provide value*/
package fileReaders;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String configFilePath= "src//test//resources//ConfigFiles//config.properties";

	/*buffer reading of property file*/
	public ConfigFileReader(){
		BufferedReader bufferReader;
		try {
			bufferReader = new BufferedReader(new FileReader(configFilePath));
			properties = new Properties();
			properties.load(bufferReader);
			bufferReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/*method to return url*/
	public String getUrl(){
		String url = properties.getProperty("url");
		if(url!= null) return url;
		else throw new RuntimeException("url is empty in the config.properties file.");		
	}

	/*method to return email value*/
	public String getEmail(){
		String email = properties.getProperty("email");
		if(email!= null) return email;
		else throw new RuntimeException("email is empty in the config.properties file.");		
	}

	/*method to return password value*/
	public String getPassword(){
		String password = properties.getProperty("password");
		if(password!= null) return password;
		else throw new RuntimeException("password is empty in the config.properties file.");		
	}

	/*method to return username*/
	public String getUserName(){
		String username = properties.getProperty("username");
		if(username!= null) return username;
		else throw new RuntimeException("username is empty in the config.properties file.");		
	}

	/*method to return inputtext*/
	public String getInputText(){
		String inputtext = properties.getProperty("inputtext");
		if(inputtext!= null) return inputtext;
		else throw new RuntimeException("inputtext is empty in the config.properties file.");		
	}

	/*method to return extent report config file path*/
	public String getExtentReportConfigPath(){
		String extentconfigpath = properties.getProperty("extentconfigpath");
		if(extentconfigpath!= null) return extentconfigpath;
		else throw new RuntimeException("extentconfigpath is empty in the config.properties file.");		
	}

	/*method to return screenshot file path*/
	public String getScreenshotPath(){
		String screenshotpath = properties.getProperty("screenshotpath");
		if(screenshotpath!= null) return screenshotpath;
		else throw new RuntimeException("screenshotpath is empty in the config.properties file.");		
	}

	/*method to return implicit wait value*/
	public long getImplicitWait(){
		String implicitWait = properties.getProperty("implicitWait");
		if(implicitWait!= null) return Long.parseLong(implicitWait);
		else throw new RuntimeException("implicitWait is empty in the config.properties file.");		
	}
}
