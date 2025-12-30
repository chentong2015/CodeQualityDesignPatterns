package closeable;

import java.io.IOException;

public class JavaAutoCloseable {

    // TODO. 使用时，会自动调用类型close()方法(自定义资源的释放等操作)
    //  会先释放MyClassB, 然后释放MyClassA
    public void testCloseWithTry() throws IOException {
        try (MyClassA myClassA = new MyClassA();
             MyClassB myClassB = new MyClassB(myClassA)) {
            myClassB.print();
        }
    }

    // TODO. 非try-with-with-Resources形式，释放资源时需要判断对象是否为null
    //  1. 如果为null，则抛出异常java.lang.NullPointerException
    //  2. 如果非null，则可以调用两次对象的close()方法 !!
    public static void testCloseWithoutTry() throws IOException {
        MyClassA myClassA = new MyClassA();
        MyClassB myClassB = new MyClassB(myClassA);

        if (myClassB != null) {
            myClassB.close();
        }
        if (myClassA != null) {
            myClassA.close();
        }

        myClassB.close();
        myClassA.close();
    }
}
