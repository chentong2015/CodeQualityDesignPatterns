package exception.unchecked;

public class BuildInfo extends BuildException {

    public BuildInfo(String message) {
        super(message);
    }

    public BuildInfo(Exception ex) {
        super(ex);
    }

    public BuildInfo(String message, Exception ex) {
        super(message, ex);
    }
}
