package com.mycompany.mavenproject4;


import javax.swing.JOptionPane;

public class Mavenproject4 {

    public static void main(String[] args) {

        // Ask the user to enter registration information
        String firstName = JOptionPane.showInputDialog(
                "Enter your first name:");

        String lastName = JOptionPane.showInputDialog(
                "Enter your last name:");

        String username = JOptionPane.showInputDialog(
                "Enter your username:");

        String password = JOptionPane.showInputDialog(
                "Enter your password:");

        String cellPhoneNumber = JOptionPane.showInputDialog(
                "Enter your South African cell phone number "
                + "using the international code, e.g. +27838968976:");

        // Create the Login object
        Login user = new Login(
                firstName,
                lastName,
                username,
                password,
                cellPhoneNumber
        );

        // Check username
        if (user.checkUserName()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Username successfully captured."
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Username is not correctly formatted; please ensure "
                    + "that your username contains an underscore and is "
                    + "no more than five characters in length."
            );
        }

        // Check password
        if (user.checkPasswordComplexity()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Password successfully captured."
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Password is not correctly formatted; please ensure "
                    + "that the password contains at least eight characters, "
                    + "a capital letter, a number, and a special character."
            );
        }

        // Check cellphone number
        if (user.checkCellPhoneNumber()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Cell phone number successfully added."
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Cell phone number incorrectly formatted or does not "
                    + "contain international code."
            );
        }

        // Registration result
        JOptionPane.showMessageDialog(
                null,
                user.registerUser()
        );

        // Allow login only if registration details are valid
        if (user.checkUserName()
                && user.checkPasswordComplexity()
                && user.checkCellPhoneNumber()) {

            String loginUsername = JOptionPane.showInputDialog(
                    "Enter your username to login:");

            String loginPassword = JOptionPane.showInputDialog(
                    "Enter your password to login:");

            user.setLoginDetails(loginUsername, loginPassword);

            JOptionPane.showMessageDialog(
                    null,
                    user.returnLoginStatus()
            );
        }
    }
}
