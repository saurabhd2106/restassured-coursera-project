package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import request.RequestFactory;

public class ProductTest extends BaseTest {
	
	
	@Test
	public void verifyGetProduct() {
		requestFactory.getAllProducts().then().log().all().statusCode(200);
	}
	
	
	@Test
	public void verifyAddProduct() {
		
		String requestPayload = "{\r\n" + 
				"  \"name\": \"Samsung Mobile\",\r\n" + 
				"  \"type\": \"Mobile\",\r\n" + 
				"  \"price\": 1000,\r\n" + 
				"  \"shipping\": 12,\r\n" + 
				"  \"upc\": \"Mobile\",\r\n" + 
				"  \"description\": \"Best Mobile Phone\",\r\n" + 
				"  \"manufacturer\": \"Samsung\",\r\n" + 
				"  \"model\": \"string\",\r\n" + 
				"  \"url\": \"string\",\r\n" + 
				"  \"image\": \"string\"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"";
		
		requestFactory.addAllProducts(requestPayload).then().log().all().statusCode(201);
	}
	
	
	@Test
	public void verifyAddProductWithRequestPayloadAsMap() {
		
		Map<String, Object> requestPayload = new HashMap<>();
		
		  requestPayload.put("name", "Samsung Mobile");
		  requestPayload.put("type", "Mobile");
		  requestPayload.put("price", 1000);
		  requestPayload.put("shipping", 12);
		  requestPayload.put("upc", "Mobile");
		  requestPayload.put("description", "Best Mobile Phone");
		  requestPayload.put("manufacturer", "Samsung");
		  requestPayload.put("model", "string");
		  requestPayload.put("url", "string");
		  requestPayload.put("image", "string");

		
		requestFactory.addAllProducts(requestPayload).then().log().all().statusCode(201);
	}

}
