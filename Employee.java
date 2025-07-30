package biographymanagement;
import java.util.List;
/**
*
* @author Priscilla
*/
public class Employee {
  public int empID;
  // Simulating user data (username and password)
  public String Username;
  public String Password;
  //Implementing Association relationship between Employee class and MyBiography class
  private List<MyBiography> mybio;
  // Constructors, getters, and setters go here
  public Employee() {
    this.empID = 21520040;
    this.mybio = mybio;
    this.Username = "pris123";
    this.Password = "pass123";
  }
  //Getters and Setters
  public int getEmpID() {
    return empID;
  }
  public void setEmpID(int empID) {
    this.empID = empID;
  }
  public String getUsername() {
    return Username;
  }
  public void setUsername(String Username) {
    this.Username = Username;
  }
  public String getPassword() {
    return Password;
  }
  public void setPassword(String Password) {
    this.Password = Password;
  }
  public List<MyBiography> getMybio() {
    return mybio;
  }
  public void setMybio(List<MyBiography> mybio) {
    this.mybio = mybio;
  }
}
