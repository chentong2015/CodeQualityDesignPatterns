package closeable;

import java.io.*;

// try-finally可以保证无法是否发生异常，都执行finally语句快中的语句
public class DemoTryFinally {

    // 1. 当.readLine()出现异常时，执行.close()仍然抛出异常
    //    但是在异常堆栈中找不到第一个异常的记录(真正异常的信息)
    private static String getFirstLineOfFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        try {
            return bufferedReader.readLine();
        } finally {
            bufferedReader.close();
        }
    }

    // 2. 当出现多个资源需要关闭时，try-finally会造成代码非常糟糕
    private static void copy(String src, String target) throws IOException {
        InputStream inputStream = new FileInputStream(src);
        try {
            OutputStream outputStream = new FileOutputStream(target);
            try {
                byte[] buffer = new byte[32];
                int n;
                while ((n = inputStream.read(buffer)) >= 0) {
                    outputStream.write(buffer, 0, n);
                }
            } finally {
                outputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }
}
