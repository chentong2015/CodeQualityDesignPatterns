package null_object;

import java.util.Objects;

// java.util.Objects.requireNonNull
// java Library API中包含了判断非空的静态方法，该方法保证在null值时会抛出异常
public class NonnullRequirement {

    public static String checkNonNull(String value) {
        // Method will throw an exception when parameter is null
        Objects.requireNonNull(value);
        return value + "ok";
    }

    public static void main(String[] args) {

        System.out.println(checkNonNull(null));
    }
}
