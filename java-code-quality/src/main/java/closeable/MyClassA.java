package closeable;

import java.io.Closeable;
import java.io.IOException;

public class MyClassA implements Closeable {

    @Override
    public void close() throws IOException {
        System.out.println("call class A close()");
    }
}