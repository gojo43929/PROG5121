package com.mycompany.mavenproject4;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testUsernameCorrectlyFormatted() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&8sec@ke99!",
                "+27838968976"
        );

        assertTrue(user.checkUserName());
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyle!!!!!!!",
                "Ch&8sec@ke99!",
                "+27838968976"
        );

        assertFalse(user.checkUserName());
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&8sec@ke99!",
                "+27838968976"
        );

        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "password",
                "+27838968976"
        );

        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&8sec@ke99!",
                "+27838968976"
        );

        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&8sec@ke99!",
                "08966553"
        );

        assertFalse(user.checkCellPhoneNumber());
    }

    @Test
    public void testLoginSuccessful() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&8sec@ke99!",
                "+27838968976"
        );

        user.setLoginDetails(
                "kyl_1",
                "Ch&8sec@ke99!"
        );

        assertTrue(user.loginUser());
    }

    @Test
    public void testLoginFailed() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&8sec@ke99!",
                "+27838968976"
        );

        user.setLoginDetails(
                "wrongUsername",
                "wrongPassword"
        );

        assertFalse(user.loginUser());
    }

    @Test
    public void testIncorrectUsernameMessage() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyle!!!!!!!",
                "Ch&8sec@ke99!",
                "+27838968976"
        );

        String expected =
                "Username is not correctly formatted; please ensure "
                + "that your username contains an underscore and is "
                + "no more than five characters in length.";

        assertEquals(expected, user.registerUser());
    }

    @Test
    public void testIncorrectPasswordMessage() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "password",
                "+27838968976"
        );

        String expected =
                "Password is not correctly formatted; please ensure "
                + "that the password contains at least eight characters, "
                + "a capital letter, a number, and a special character.";

        assertEquals(expected, user.registerUser());
    }

    @Test
    public void testSuccessfulRegistrationMessage() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&8sec@ke99!",
                "+27838968976"
        );

        String expected = "User registered successfully.";

        assertEquals(expected, user.registerUser());
    }

    @Test
    public void testSuccessfulLoginMessage() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&8sec@ke99!",
                "+27838968976"
        );

        user.setLoginDetails(
                "kyl_1",
                "Ch&8sec@ke99!"
        );

        String expected =
                "Welcome Kyle, Smith it is great to see you again.";

        assertEquals(
                expected,
                user.returnLoginStatus()
        );
    }

    @Test
    public void testFailedLoginMessage() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&8sec@ke99!",
                "+27838968976"
        );

        user.setLoginDetails(
                "wrongUsername",
                "wrongPassword"
        );

        String expected =
                "Username or password incorrect, please try again.";

        assertEquals(
                expected,
                user.returnLoginStatus()
        );
    }
}
    

