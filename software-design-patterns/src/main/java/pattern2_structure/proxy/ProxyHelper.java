package pattern2_structure.proxy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;

public class ProxyHelper {

    private ProxyHelper() {
    }

    public static void showProxyInfos(Class proxyClass) {
        System.out.println("package = " + proxyClass.getPackage()
                + " SimpleName = " + proxyClass.getSimpleName()
                + " name =" + proxyClass.getName()
                + " CanonicalName = " + "" + proxyClass.getCanonicalName()
                + " implements Interfaces = " + Arrays.toString(proxyClass.getInterfaces())
                + " superClass = " + proxyClass.getSuperclass()
                + " methods =" + Arrays.toString(proxyClass.getMethods()));
    }

    public static void saveGeneratedJdkProxyFiles() throws Exception {
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        props.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    }

    // 保存生成的代理类class
    // className  生成的代理类名称
    // interfaces 代理类需要实现的接口
    // pathDir    代理类保存的目录路径,以目录分隔符结尾
    public static void saveClass(String className, Class<?>[] interfaces, String pathDir) {
        // byte[] classFile = ProxyGenerator.generateProxyClass(className, interfaces);
        Path path1 = Paths.get(pathDir);
        if (!path1.toFile().exists()) {
            path1.toFile().mkdirs();
        }
        String path = pathDir + className + ".class";
        try (FileOutputStream fos = new FileOutputStream(path)) {
            // fos.write(classFile);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
