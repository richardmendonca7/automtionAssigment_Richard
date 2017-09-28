package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.containsString;
import pages.AllUser_Page;
import pages.ApiCalls;
import pages.NewUser_Page;
import resources.Utilites;
/***
 * This Test creates users with different parameter
 * @author Richard Mendonca
 */
public class CreateUsersTests {

	NewUser_Page newuserPage;
	AllUser_Page alluserPage;
	ApiCalls  apicalls;

	@Before
	public void setUp() {
		newuserPage=new NewUser_Page();
		alluserPage=new AllUser_Page();
		apicalls=new ApiCalls();
		newuserPage.OpenBrowerWithUrl();
	}

	@Test
	public void createValidUserTest() {
		System.out.println("-------createValidUserTest-------------");
		apicalls.sendDeleteREquestToDeleteAllUser();
		String name=Utilites.getRandomString(13);
		newuserPage.setName(name);
		String email=Utilites.getRandomEmailId();
		newuserPage.setEmail(email);
		String password=Utilites.getRandomString(9);
		newuserPage.setPassword(password);
		newuserPage.setConfirmationPassword(password);
		newuserPage.clickSubmitButton();
		assertTrue("user present",alluserPage.verifyUserPresentInTable(name, email, password));
		String responseJson=apicalls.sendGetRequestToGetAllUser();
		assertThat(responseJson,containsString(name));
	}

	@Test
	public void  CreateDuplicateUser() {
		System.out.println("-------CreateDuplicateUser-------------");
			String name=Utilites.getRandomString(13);
			newuserPage.setName(name);
			String email=Utilites.getRandomEmailId();
			newuserPage.setEmail(email);
			String password=Utilites.getRandomString(9);
			newuserPage.setPassword(password);
			newuserPage.setConfirmationPassword(password);
			newuserPage.clickSubmitButton();
			assertTrue("user present",alluserPage.verifyUserPresentInTable(name, email, password));
			alluserPage.clickNewUserButton();
			// Duplicate user
			newuserPage.setName(name);
			email=Utilites.getRandomEmailId();
			newuserPage.setEmail(email);
			password=Utilites.getRandomString(9);
			newuserPage.setPassword(password);
			newuserPage.setConfirmationPassword(password);
			newuserPage.clickSubmitButton();
			boolean error=newuserPage.verifyDuplicateNameError();
			assertTrue("Error Message Not displayed",error);
	}

	@Test
	public void  CreateUserWithDifferentConfirmationPassword() {
		System.out.println("-------CreateUserWithDifferentConfirmationPassword-------------");
		String name=Utilites.getRandomString(13);
		newuserPage.setName(name);
		String email=Utilites.getRandomEmailId();
		newuserPage.setEmail(email);
		newuserPage.setPassword(Utilites.getRandomString(9));
		newuserPage.setConfirmationPassword(Utilites.getRandomString(9));
		newuserPage.clickSubmitButton();
		boolean error=newuserPage.verifyConfirmationPasswordError();
		assertTrue("Error Message Not displayed",error);
	}

	@Test
	public void  CreateUserWithoutEmail() {
		System.out.println("-------CreateUserWithoutEmail-------------");
		String name=Utilites.getRandomString(13);
		newuserPage.setName(name);
		String password=Utilites.getRandomString(9);
		newuserPage.setPassword(password);
		newuserPage.setConfirmationPassword(password);
		newuserPage.clickSubmitButton();
		boolean error=newuserPage.verifyEmailError();
		assertTrue("Error Message Not displayed",error);
	}

	@Test
	public void  CreateUserWithoutName() {
		System.out.println("-------CreateUserWithoutName-------------");
		String email=Utilites.getRandomEmailId();
		newuserPage.setEmail(email);
		newuserPage.setPassword(Utilites.getRandomString(9));
		newuserPage.setConfirmationPassword(Utilites.getRandomString(9));
		newuserPage.clickSubmitButton();
		boolean error=newuserPage.verifyNameError();
		assertTrue("Error Message Not displayed",error);
	}

	@Test
	public void  CreateUserWithoutConfirmationPassword() {
		System.out.println("-------CreateUserWithoutConfirmationPassword-------------");
		String name=Utilites.getRandomString(13);
		newuserPage.setName(name);
		String email=Utilites.getRandomEmailId();
		newuserPage.setEmail(email);
		newuserPage.setPassword(Utilites.getRandomString(9));
		newuserPage.clickSubmitButton();
		boolean error=newuserPage.verifyConfirmationPasswordError();
		assertTrue("Error Message Not displayed",error);
	}

	@After
	public void teardown() {
		newuserPage.closeBrowser();
		System.out.println("____________________________");
		System.out.println("-------Finished-------------");
	}
}
