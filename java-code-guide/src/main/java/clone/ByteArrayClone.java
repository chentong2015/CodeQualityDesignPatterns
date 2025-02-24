package clone;

// TODO. 关于字节数组Clone拷贝的问题
public class ByteArrayClone {

    private final byte[] bytesSalt;

    public ByteArrayClone(byte[] bytesSalt) {
        this.bytesSalt = bytesSalt;

        // 使用Clone避免被外部修改
        // this.bytesSalt = bytesSalt.clone();
    }

    // 该方法将当前对象字节数组中的数据拷贝到参数字节数组中
    public void cloneByteSalt(byte[] bytes) {
        // TODO. 直接赋值或调用.clone()，修改的参数只能内部可见
        // Clone是深度拷贝，只是对外部不可见 !!
        // bytes = this.bytesSalt;
        // bytes = this.bytesSalt.clone();
        // System.out.println(new String(bytes));

        // TODO. 调用系统API修改参数数组内容，并使其对外可见
        System.arraycopy(this.bytesSalt, 0, bytes, 0, this.bytesSalt.length);
    }

    // 该方法返回当前对象字节数组的引用，使其对外可见可修改
    public byte[] getBytesSalt() {
        return bytesSalt;
    }

    // 该方法返回当前对象字节数组的拷贝，外部的修改无法改变对象内的字节数组
    public byte[] getBytesSaltClone() {
        return bytesSalt.clone();
    }
}
