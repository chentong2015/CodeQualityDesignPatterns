package null_object;

import jakarta.annotation.Nonnull;

// javax.annotation.Nullable annotations:
// used either by IDE or by static code analysis tools to detect basic error at compile time 
// but do not prevent NullPointerException at runtime
public class NonnullAnnotation {

    private final String name;

    // 非空注解并不能保证在运行时非空，在创建对象时任然可以传递null值
    public NonnullAnnotation(@Nonnull String name) {
        this.name = name;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        // passing 'null' argument to parameter annotated as @NotNull
        NonnullAnnotation demo = new NonnullAnnotation(null);
        System.out.println(demo.getName().length());
    }
}
