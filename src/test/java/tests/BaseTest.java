package tests;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import request.RequestFactory;
import utils.ConfigRead;

public class BaseTest {
	
	String configFilename;
	Properties configProperties;
	RequestFactory requestFactory;
	
	String currentWorkingDirectory;

	@BeforeSuite
	public void preSetup() throws Exception {
		currentWorkingDirectory = System.getProperty("user.dir");
		
		configFilename = currentWorkingDirectory + "/src/test/resources/config/config.properties";
		
		configProperties = ConfigRead.readConfigProperties(configFilename);
	}
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = configProperties.getProperty("baseUrl");
		RestAssured.port = Integer.parseInt(configProperties.getProperty("baseUrl"));
		
		requestFactory = new RequestFactory();
	}
	
	@AfterClass
	public void cleanUp() {
		RestAssured.reset();
	}

}
