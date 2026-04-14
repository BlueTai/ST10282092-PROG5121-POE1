

// Notice there is no "jupiter" anywhere in these imports!
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import prog5121_poe1.Login;

public class LoginTest {
    
    private Login login;

    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCheckUserName() {
        assertTrue(login.checkUserName("kyl_1"));
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testRegisterUser() {
        Login temp1 = new Login();
        assertEquals("User has been registered successfully.", temp1.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith"));

        Login temp2 = new Login();
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", temp2.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith"));

        Login temp3 = new Login();
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", temp3.registerUser("kyl_1", "password", "+27838968976", "Kyle", "Smith"));

        Login temp4 = new Login();
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", temp4.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith"));
    }

    @Test
    public void testLoginUser() {
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertFalse(login.loginUser("kyl_1", "wrongpassword"));
    }

    @Test
    public void testReturnLoginStatus() {
        assertEquals("Welcome Kyle, Smith it is great to see you again.", login.returnLoginStatus(true));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }
}