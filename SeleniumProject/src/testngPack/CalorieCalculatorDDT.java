package testngPack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalorieCalculatorDDT {
	@Test(dataProvider="login")
	//@Test(dataProvider="getLoginData")
	public void Login(String username, String password){
		System.out.println("Enter username = " + username);
		System.out.println("Enter password = " + password);
		System.out.println("Click on Submit button");
	}
	@DataProvider(name="login")
	public Object[][] getLoginData(){
		//data - how do i tell testng testcase - that testdata for login is provided by this method
		//Lets put the data in  2 dimensional object array to pass it to the test case
		String[][] data = new String[2][2];
		//2 sets of test data and each data set - 1st col is username and 2nd col is password
		data[0][0] = "user1";
		data[0][1] = "pass1";
		data[1][0] = "user2";
		data[1][1] = "pass2";
		return data;
	}
	

}
