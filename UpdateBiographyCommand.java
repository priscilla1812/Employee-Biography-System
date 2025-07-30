package biographymanagement;
/**
*
* @author Priscilla
*/
// Concrete command class for updating biography
public class UpdateBiographyCommand implements Command {
  private MyBiography bio;
  public UpdateBiographyCommand(MyBiography bio) {
    this.bio = bio;
  }
  @Override
  public void execute() {
    bio.updateMyBio();
  }
}
