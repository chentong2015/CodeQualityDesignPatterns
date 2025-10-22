package liquibase_plugins;

public interface Plugin {

    /**
     * Value to return from priority functions when the plugin is not applicable.
     */
    int PRIORITY_NOT_APPLICABLE = -1;

    /**
     * Value to return from priority functions when the plugin is the standard implementation.
     */
    int PRIORITY_DEFAULT = 1;

    /**
     * Value to return from priority functions when the plugin is a specialized, non-default implementation.
     */
    int PRIORITY_SPECIALIZED = 10;
}
