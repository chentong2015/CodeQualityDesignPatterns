package design_patterns.pattern3_behavior.chain_of_responsibility.demo1;

public class CodeEditor implements IKeyHandler {

    IKeyHandler handlerUp;

    public CodeEditor(IKeyHandler handler) {
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
