package biographymanagement;
/**
*
* @author Priscilla
*/
// Concrete command class for approving biography
public class ApproveBiographyCommand implements Command {
  private MyBiography bio;
  public ApproveBiographyCommand(MyBiography bio) {
    this.bio = bio;
  }
  @Override
  public void execute() {
    bio.approveBiography();
  }
}
