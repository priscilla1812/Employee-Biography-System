package biographymanagement;
/**
*
* @author Priscilla
*/
// Invoker class
public class BiographySystemInvoker {
  private Command command;
  public void setCommand(Command command) {
    this.command = command;
  }
  public void executeCommand() {
    command.execute();
  }
}
