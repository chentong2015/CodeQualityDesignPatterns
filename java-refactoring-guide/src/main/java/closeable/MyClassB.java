package closeable;

import java.io.Closeable;
import java.io.IOException;

public class MyClassB implements Closeable {

    private MyClassA myClassA;

    public MyClassB(MyClassA myClassA) {
        this.myClassA = myClassA;
    }

    public void print() {
        System.out.println("print something");
    }

    @Override
    public void close() throws IOException {
        System.out.println("call class B close()");
    }
}
