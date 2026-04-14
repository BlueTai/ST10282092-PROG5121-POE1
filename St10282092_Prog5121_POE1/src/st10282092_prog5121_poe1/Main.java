package st10282092_prog5121_poe1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author bluet
 */
import java.util.Scanner;

/**
 *
 * @author bluet
 */
public class Main {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Login loginSystem = new Login();
            
            System.out.println("--- Registration ---");
            
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            
            System.out.print("Enter Cellphone: ");
            String cellNumber = scanner.nextLine();
            
            String registrationResponse = loginSystem.registerUser(username, password, cellNumber, firstName, lastName);
            System.out.println("\n" + registrationResponse);
            
            if (registrationResponse.equals("User has been registered successfully.")) {
                System.out.println("\n--- Login ---");
                
                System.out.print("Username: ");
                String loginUser = scanner.nextLine();
                
                System.out.print("Password: ");
                String loginPass = scanner.nextLine();
                
                boolean isAuthSuccessful = loginSystem.loginUser(loginUser, loginPass);
                String loginResponse = loginSystem.returnLoginStatus(isAuthSuccessful);
                
                System.out.println("\n" + loginResponse);
            }
        }
    }
}