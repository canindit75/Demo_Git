package testngPack;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalorieCalculatorDDT2 {
	@Test(dataProvider="login")
	//@Test(dataProvider="getLoginData")
	public void Login(Hashtable<String,String> data){
		System.out.println("Enter username = " + data.get("username"));
		System.out.println("Enter password = " + data.get("password"));
		System.out.println("Click on Submit button");
	}
	@DataProvider(name="login")
	public Object[][] getLoginData(){
		//data - how do i tell testng testcase - that testdata for login is provided by this method
		//Lets put the data in  2 dimensional object array to pass it to the test case
/*		String[][] data = new String[2][2];
		//2 sets of test data and each data set - 1st col is username and 2nd col is password
		data[0][0] = "user1";
		data[0][1] = "pass1";
		data[1][0] = "user2";
		data[1][1] = "pass2";
		return data;*/
		Object[][] data = new Object[2][1];
		Hashtable<String,String> rec1 = new Hashtable<String,String>();
		rec1.put("username", "user1");
		rec1.put("password", "pass1");
		data[0][0] = rec1;
		System.out.println(rec1.get("username"));
		System.out.println(rec1.get("password"));
		Hashtable<String,String> rec2 = new Hashtable<String,String>();
		rec2.put("username", "user2");
		rec2.put("password", "pass2");
		System.out.println(rec2.get("username"));
		System.out.println(rec2.get("password"));
		data[1][0] = rec2;
		return data;
	}
	

}
