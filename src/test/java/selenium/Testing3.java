package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	
  SoftAssert softAssert= new SoftAssert();
	
  @Test(priority = 1, groups = "smoke")//create new user test@test.com
  public void createUser() {
	  System.out.println("I am in Home Test");
	  System.out.println("Before Assertion");
	  Assert.assertTrue(4>3, "verifying element"); // we use regular assert in industry
	  System.out.println("After assertion");
	  Assert.assertEquals("abc", "abc");
	  System.out.println("after Second assert");
  }
  
  @Test(priority = 2, dependsOnMethods = "createUser") // Edit user test@test.com
  public void edituser() {
	  System.out.println("Before Assertion");
	  softAssert.assertTrue(2>3,"verifying Element");
	  System.out.println("After assertion");
	  softAssert.assertAll(); //similar to error colletor in junit
  }
  
  @Test(priority = 3, dependsOnMethods = "edituser") // Delete user test@test.com
  public void deleteuser() {
	  System.out.println("I am in end Test");
	  System.out.println("Before Assertion");
	  softAssert.assertTrue(4>3,"verifying Element");
	  System.out.println("After assertion");
	  softAssert.assertEquals("abc", "abc1");
	  System.out.println("After assertion");
	  softAssert.assertAll();
  }
}
