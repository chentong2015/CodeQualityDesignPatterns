package extensions;

public class MySqlGenerator implements SqlGenerator {

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }
}
