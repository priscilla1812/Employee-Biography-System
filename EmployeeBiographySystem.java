package com.mycompany.employeebiographysystem;

import biographymanagement.ApproveBiographyCommand;
import biographymanagement.BiographySystemInvoker;
import biographymanagement.Command;
import biographymanagement.Employee;
import biographymanagement.MyBiography;
import biographymanagement.SubmitBiographyCommand;
import biographymanagement.UpdateBiographyCommand;
import java.util.Scanner;

/**
*
* @author Priscilla
*/

public class EmployeeBiographySystem {
  public static void main(String[] args) {
    System.out.println("");
    System.out.println("Welcome to Hill & Knowlton Employee Biography Management System");
    System.out.println("");
    
    Scanner scanner = new Scanner(System.in);
    
    //login using emloyee class
    // Instantiate an Employee object
    Employee emp = new Employee();
    System.out.println("Login...");
    // Prompt user for login credentials
    System.out.println("Enter Employee ID: ");
    int id = scanner.nextInt(); // nextInt() will try to parse the next token in the input as an integer.
    scanner.nextLine(); // nextLine() reads the next line from the input as a string.
    // Prompt user for login credentials
    System.out.println("Enter username: ");
    String username = scanner.nextLine();
    System.out.println("Enter password: ");
    String password = scanner.nextLine();
    
    if (username.equals(emp.Username) && password.equals(emp.Password)) {
      System.out.println("Login Successful! Access Granted! Welcome " + id + " !");
    } else {
      System.out.println("Invalid credentials. Login failed.");
    }

    System.out.println("");
    System.out.println("Displaying Employee Biography ... ");
    // Instantiate an My Biography object
    MyBiography bio = new MyBiography();
    bio.viewMyBio();
    System.out.println("");
    
    //Selected Use Case for software implementation: Update Eployee Biography
    System.out.println("Do you want to make any changes to your existing biography information? ");
    System.out.println("If Yes, Enter 'Y' to update your biography information:");
    String yes = scanner.nextLine();
    System.out.println("");

    // Step 1: Initiate Biography Update
    System.out.println("Initiating Updation of Employee Biography ... ");
    System.out.println("Which part of your biography has inaccurate or outdated information?");
    System.out.println("[1 = Email Id, 2 = Phone Number, 3 = Address]");
    System.out.println("Enter your choice:");
    int up = scanner.nextInt();
    scanner.nextLine();
    System.out.println("");

    // Step 2: Edit Biography Information
    switch (up) {
      case 1:
        System.out.print("Enter your email id: ");
        bio.setEmail(scanner.nextLine());
        break;
      case 2:
        System.out.print("Enter your phone no.: ");
        bio.setContact(scanner.nextLine());
        break;
      case 3:
        System.out.print("Enter your address: ");
        bio.setAddress(scanner.nextLine());
        break;
    }

    System.out.println("");
    // Step 3: Submit Biography Update
    System.out.println("Submitting Updated Employee Biography ...");
    // Step 4: Review and Approval by HR
    System.out.println("[Waiting for approval from HR department... If approved, employee will be notified...]");
    System.out.println("");
    System.out.println("Implementing Command Pattern:-");

    // Client code
    // Create instances
    //MyBiography bio = new MyBiography();
    Command updateCommand = new UpdateBiographyCommand(bio);
    Command submitCommand = new SubmitBiographyCommand(bio);
    Command approveCommand = new ApproveBiographyCommand(bio);
    
    BiographySystemInvoker invoker = new BiographySystemInvoker();
    
    // Simulating the workflow
    invoker.setCommand(updateCommand);
    invoker.executeCommand();
    
    invoker.setCommand(submitCommand);
    invoker.executeCommand();
    
    invoker.setCommand(approveCommand);
    invoker.executeCommand();
    
    // Checking the status
    System.out.println("Biography status: Updating - " + bio.isUpdatingBiography() +
    ", Approved - " + bio.isApproved());

    System.out.println("");
    // Step 5: Notify Employee of Biography Update Status
    bio.notifyEmployee();
    System.out.println("");
    
    // Check constraints after the update
    System.out.println("Implementing OCL expressions:-");
    try {
      bio.biographyInformationUpdate();
      bio.biographySubmission();
      bio.biographyApprovalStatus();
      System.out.println("Constraints passed successfully.");
      } catch (IllegalArgumentException e) {
        System.out.println("Constraint Violation: " + e.getMessage());
      }
  }
}
