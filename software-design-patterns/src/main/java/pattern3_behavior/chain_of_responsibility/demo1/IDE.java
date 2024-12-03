package pattern3_behavior.chain_of_responsibility.demo1;

public class IDE implements IKeyHandler {

    @Override
    public void handleInputKey(String key) {
        if (key.equals("Ctrl+F")) {
            System.out.println("Full Search");
        } else if (key.equals("Alt+F4")) {
            System.out.println("Close IWork");
        } else {
            System.out.println("Can not handle it");
        }
    }
}
