package basics;

import io.restassured.path.json.JsonPath;

public class jsonPathDemo {

	public static void main(String[] args) {

		String all = "{\r\n" + "\r\n" + "\"dashboard\": {\r\n" + "\r\n" + "\"purchaseAmount\": 910,\r\n" + "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n" + "\r\n" + "},\r\n" + "\r\n" + "\"courses\": [\r\n"
				+ "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"Selenium Python\",\r\n" + "\r\n" + "\"price\": 50,\r\n"
				+ "\r\n" + "\"copies\": 6\r\n" + "\r\n" + "},\r\n" + "\r\n" + "{\r\n" + "\r\n"
				+ "\"title\": \"Cypress\",\r\n" + "\r\n" + "\"price\": 40,\r\n" + "\r\n" + "\"copies\": 4\r\n" + "\r\n"
				+ "},\r\n" + "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"RPA\",\r\n" + "\r\n" + "\"price\": 45,\r\n"
				+ "\r\n" + "\"copies\": 10\r\n" + "\r\n" + "}\r\n" + "\r\n" + "]\r\n" + "\r\n" + "}";

		JsonPath jp = new JsonPath(all);
		int totalCourses = jp.getInt("courses.size");  //Size works with Array Items only
        
		System.out.println(totalCourses); // 3
		
		//1 purchase amount from dashbroard
		System.out.println(jp.getInt("dashboard.purchaseAmount")+""); //910
		
		//2.Get title and price of each course
		for(int i=0;i<totalCourses;i++) {
			System.out.println("Title :"+ jp.get("courses["+i+"].title"));
			System.out.println(" price :"+ jp.get("courses["+i+"].price"));
		}
				
//		Title :Selenium Python
//		 price :50
//		Title :Cypress
//		 price :40
//		Title :RPA
//		 price :45
//	
		
		

//5. Print no of copies sold by RPA Course
		
		
		for(int i=0;i<totalCourses;i++) {
			if(jp.get("courses["+i+"].title").toString().equalsIgnoreCase("RPA")) {
				System.out.println(" price :"+ jp.get("courses["+i+"].price"));
				break;
				
			}
			//45
			
		}
		
		
		
		
		
		
		
		
	}

}
