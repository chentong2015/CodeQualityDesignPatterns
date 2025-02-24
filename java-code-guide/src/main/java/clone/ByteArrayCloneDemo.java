package clone;

public class ByteArrayCloneDemo {

    public static void main(String[] args) {
        byte[] bytes = "test123".getBytes();
        System.out.println(bytes);
        System.out.println(bytes.length);

        // TODO. 拷贝只作用在当前Scope域
        byte[] bytes1 = bytes.clone();
        System.out.println(bytes);


        ByteArrayClone instance = new ByteArrayClone(bytes);
        // TODO. 保证拷贝结果的字节数组长度一致
        byte[] byteClone = new byte[bytes.length];
        instance.cloneByteSalt(byteClone);
        System.out.println(new String(byteClone));


        // TODO. 获取的字节数组对象，在外部通过引用修改
        byte[] bytesFiled1 = instance.getBytesSalt();
        bytes1[0] = 0;
        System.out.println(new String(bytesFiled1));
        byte[] bytesField2 = instance.getBytesSalt();
        System.out.println(new String(bytesField2));

        // TODO. 获取的字节数组对象，在外部通过引用修改
        byte[] bytesFiled3 = instance.getBytesSaltClone();
        bytesFiled3[0] = 0;
        System.out.println(new String(bytesFiled3));

        byte[] bytesField4 = instance.getBytesSaltClone();
        System.out.println(new String(bytesField4));
    }
}
