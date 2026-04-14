package prog5121_poe1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bluet
 */
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Login loginSystem = new Login();
            
            System.out.println("=====================================");
            System.out.println("             REGISTRATION            ");
            System.out.println("=====================================");
            
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            
            System.out.print("Enter Username (max 5 chars, include '_'): ");
            String username = scanner.nextLine();
            
            System.out.print("Enter Password (min 8 chars, 1 upper, 1 number, 1 special): ");
            String password = scanner.nextLine();
            
            System.out.print("Enter Cellphone (e.g., +27...): ");
            String cellNumber = scanner.nextLine();
            
            // Pass the captured data to the Login class
            String registrationResponse = loginSystem.registerUser(username, password, cellNumber, firstName, lastName);
            System.out.println("\n-> " + registrationResponse);
            
            // Only show the Login menu if registration was completely successful
            if (registrationResponse.equals("User has been registered successfully.")) {
                System.out.println("\n=====================================");
                System.out.println("                 LOGIN               ");
                System.out.println("=====================================");
                
                System.out.print("Username: ");
                String loginUser = scanner.nextLine();
                
                System.out.print("Password: ");
                String loginPass = scanner.nextLine();
                
                // Check the credentials and print the final status
                boolean isAuthSuccessful = loginSystem.loginUser(loginUser, loginPass);
                String loginResponse = loginSystem.returnLoginStatus(isAuthSuccessful);
                
                System.out.println("\n-> " + loginResponse);
            }
        }
    }
}
