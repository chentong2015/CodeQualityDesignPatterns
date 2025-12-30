package exception.unchecked;

public class BuildWarning extends BuildException {

    public BuildWarning(String message) {
        super(message);
    }

    public BuildWarning(Exception ex) {
        super(ex);
    }

    public BuildWarning(String message, Exception ex) {
        super(message, ex);
    }
}
