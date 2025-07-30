import biographymanagement.MyBiography;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
*
* @author Priscilla
*/
public class MyBiographyJUnitTest {
  private MyBiography bio;
  @BeforeAll
  public static void setUpClass() {
    System.out.println("Welcome to Hill & Knowlton Employee Biography Management System");
    System.out.println("");
    // Step 1: Initiate Biography Update
    System.out.println("Initiating Updation of Employee Biography ... ");
  }
  @BeforeEach
  public void setUp() {
    // Initialize the MyBiography object before each test
    bio = new MyBiography();
  }
  // TODO add test methods here.
  // The methods must be annotated with annotation @Test.
  // OCL expressions for constraints
  @Test
  public void checkConstraints() {
    /* Employee name must not be empty.
    OCL:
    context MyBiography
    invariant: self.name <> '' */
    if (bio.name.isEmpty()) {
      System.out.println("Employee name must not be empty.");
      //throw new IllegalArgumentException
    }
    /* Email ID must be provided during biography update
    context MyBiography
    pre: self.isUpdatingBiography() implies (self.email <> '') */
    if (bio.email.isEmpty()) {
      System.out.println("Email ID must be provided during biography update.");
    }
    /* Phone number must be provided during biography update
    context MyBiography
    pre: self.isUpdatingBiography() implies (self.contact <> '') */
    if (bio.contact.isEmpty()) {
      System.out.println("Phone Number must be provided during biography update.");
    }
  }
  @Test
  public void testCheckConstraintsValid() {
    // Test when all constraints are valid
    bio.setName("Princy James");
    bio.setEmail("princy123@gmail.com");
    bio.setContact("+44 120****675");
    checkConstraints(); // This should pass without throwing an exception
  }
  @Test
  public void testUpdateBio() {
    // Test the updateMyBio method
    bio.updateMyBio();
    // Assert that the updatingBiography flag is true after calling updateBiography method
    assertTrue(bio.isUpdatingBiography(),"Biography information should be updated");
  }
  @Test
  public void testSubmitBiography() {
    // Test the submitBiography method
    bio.submitBiography();
    // Assert that the updatingBiography flag is false after calling submitBiography
    assertFalse(bio.isUpdatingBiography(),"Biography information should not be updated");
    // Assert that the biography has been submitted
    assertFalse(bio.isApproved(),"Biography should be submitted");
  }
  @Test
  public void testApproveBiography() {
    // Test the approveBiography method
    bio.approveBiography();
    // Assert that the biography is approved after calling approveBiography
    assertTrue(bio.isApproved(),"Biography should be approved");
  }
}
