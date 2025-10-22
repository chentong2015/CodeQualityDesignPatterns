package behavior_pattern.chain_of_responsibility.demo1;

public class CodeSelection implements IKeyHandler {

    IKeyHandler handlerUp;

    public CodeSelection(IKeyHandler handler) {
        this.handlerUp = handler;
    }

    @Override
    public void handleInputKey(String key) {
        if (key.equals("Alt+F4")) {
            System.out.println("Close IWork");
        } else {
            handlerUp.handleInputKey(key);
        }
    }
}
