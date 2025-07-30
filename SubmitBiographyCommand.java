package biographymanagement;
/**
*
* @author Priscilla
*/
// Concrete command class for submitting biography
public class SubmitBiographyCommand implements Command {
  private MyBiography bio;
  public SubmitBiographyCommand(MyBiography bio) {
    this.bio = bio;
  }
  @Override
  public void execute() {
    bio.submitBiography();
  }
}
