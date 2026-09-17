package com.mycompany.mavenproject4;

import java.util.regex.Pattern;

public class Login {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;

    private String loginUsername;
    private String loginPassword;

    // Constructor
    public Login(String firstName, String lastName,
            String username, String password,
            String cellPhoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // Check whether username contains an underscore
    // and is no more than five characters long
    public boolean checkUserName() {

        return username.contains("_")
                && username.length() <= 5;
    }

    // Check password complexity
    public boolean checkPasswordComplexity() {

        boolean hasEightCharacters = password.length() >= 8;
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        for (int i = 0; i < password.length(); i++) {

            char character = password.charAt(i);

            if (Character.isUpperCase(character)) {
                hasCapitalLetter = true;
            }

            if (Character.isDigit(character)) {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(character)) {
                hasSpecialCharacter = true;
            }
        }

        return hasEightCharacters
                && hasCapitalLetter
                && hasNumber
                && hasSpecialCharacter;
    }

    // Check South African cellphone number.
    // It must begin with +27 followed by 9 digits.
    //
    // Regular expression reference:
    // Oracle Java Pattern documentation:
    // https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
    public boolean checkCellPhoneNumber() {

        String regex = "^\\+27\\d{9}$";

        return Pattern.matches(regex, cellPhoneNumber);
    }

    // Return the appropriate registration message
    public String registerUser() {

        if (!checkUserName()) {

            return "Username is not correctly formatted; please ensure "
                    + "that your username contains an underscore and is "
                    + "no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {

            return "Password is not correctly formatted; please ensure "
                    + "that the password contains at least eight characters, "
                    + "a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {

            return "Cell phone number incorrectly formatted or does not "
                    + "contain international code.";
        }

        return "User registered successfully.";
    }

    // Store the username and password entered during login
    public void setLoginDetails(String loginUsername,
            String loginPassword) {

        this.loginUsername = loginUsername;
        this.loginPassword = loginPassword;
    }

    // Check whether login details match registration details
    public boolean loginUser() {

        return username.equals(loginUsername)
                && password.equals(loginPassword);
    }

    // Return login result
    public String returnLoginStatus() {

        if (loginUser()) {

            return "Welcome " + firstName + ", " + lastName
                    + " it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }
}
