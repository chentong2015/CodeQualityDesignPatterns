package closeable;

import java.io.*;

// TODO. try-with-Resources优先于try-finally用于关闭资源
public class DemoTryWithResources {

    // try-with-Resources能够看到真正抛出的异常，而第二个随后的异常会被禁止
    // 同时能够设置在异常情况下抛出的默认值
    private static String getFirstLineOfFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            return "default value";
        }
    }

    private static void copy(String src, String target) throws IOException {
        try (InputStream inputStream = new FileInputStream(src);
             OutputStream outputStream = new FileOutputStream(target)) {
            byte[] buffer = new byte[32];
            int n;
            while ((n = inputStream.read(buffer)) >= 0) {
                outputStream.write(buffer, 0, n);
            }
        }
    }
}
