package biographymanagement;
import com.mycompany.employeebiographysystem.EmployeeBiographySystem;
/**
*
* @author Priscilla
*/
//Implementation of Inheritance(Generalization) relationship
// b/w EmployeeBiographySystem class & MyBiography class
public class MyBiography extends EmployeeBiographySystem {
  private int empID;
  public String name;
  private String position;
  private String skill;
  private String workExp;
  public String email;
  private String address;
  public String contact;
  //Implementing Association relationship between Employee class and MyBiography class
  private Employee empl;
  // Receiver class representing an employee
  public boolean updatingBiography = false;
  private boolean approved = false;
  //for implementing command pattern
  public boolean isUpdatingBiography() {
    return updatingBiography;
  }
  //for implementing command pattern
  public boolean isApproved() {
    return approved;
  }
  //Constructor with defined parameters
  public MyBiography() {
    this.empID = 21520040;
    this.name = "Priscilla Philby Oommen";
    this.position = "Public Relations Officer";
    this.skill = "Leadership, Communication, Organizational skills, Strategic planning, MS Office";
    this.workExp = "Managed PR issues, Organized PR events";
    this.email = "pris_123@gmail.com";
    this.address = "190 Roberts Expressway, London, UK";
    this.contact = "+44 130****635";
  }
  //getters and setters
  public int getEmpID() {
    return empID;
  }
  public void setEmpID(int empID) {
    this.empID = empID;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
  public String getSkill() {
    return skill;
  }
  public void setSkill(String skill) {
    this.skill = skill;
  }
  public String getWorkExp() {
    return workExp;
  }
  public void setWorkExp(String workExp) {
    this.workExp = workExp;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getContact() {
    return contact;
  }
  public void setContact(String contact) {
    this.contact = contact;
  }
  //Methods
  // Method to display employee information
  public void viewMyBio(){
    System.out.println("Employee ID: " + empID);
    System.out.println("Employee Name: " + name);
    System.out.println("Position: " + position);
    System.out.println("Email ID: " + email);
    System.out.println("Address: " + address);
    System.out.println("Phone No.: " + contact);
    System.out.println("Skills: " + skill);
    System.out.println("Experience: " + workExp);
  }
  // Method to update employee information
  public void updateMyBio(){
    updatingBiography = true;
    System.out.println("Biography updated.");
  }
  /* An employee can update their biography information.
  OCL:
  context MyBiography
  invariant: self.updateBiography()*/
  public void biographyInformationUpdate() {
    if (updatingBiography) {
      updateMyBio();
      }
    }
  //Method to submit the updated employee information
  public void submitBiography() {
    System.out.println("Biography submitted.");
  }
  /* An employee must submit their updated biography for it to be considered.
  OCL:
  context MyBiography
  pre: self.isUpdatingBiography() implies self.submitBiography() */
  public void biographySubmission() {
    if (updatingBiography) {
      submitBiography();
    }
  }
  // Method for HR to approve the updated employee information
  public void approveBiography() {
    approved = true;
    System.out.println("Biography approved.");
  }
  /* A biography update is considered approved if HR approves it.
  OCL:
  context MyBiography
  post: self.isUpdatingBiography() implies self.isApproved() */
  public void biographyApprovalStatus() {
    if (updatingBiography) {
      approveBiography();
    }
  }
  /* Notify employee when biography update status changes
  context EmployeeBiographySystem
  pre: self.mybiography.isUpdatingBiography() implies self.notifyEmployee() */
  public void notifyEmployee() {
    if (updatingBiography) {
      System.out.println("Notification: Your biography update status has changed.");
    }
  }
}
