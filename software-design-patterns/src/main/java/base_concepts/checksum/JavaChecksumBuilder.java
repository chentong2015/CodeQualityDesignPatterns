package concept.checksum;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

// TODO. Checksum的值可以设计成16进制的Hash Code
// 使用Java原生API来计算基于不同算法的Hash映射的值
public class JavaChecksumBuilder {

    // Support MD5, SHA-1, SHA-256
    private static final String HASH_FUNCTION = "SHA-256";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String value = "resources";
        JavaChecksumBuilder checksumBuilder = new JavaChecksumBuilder();
        String checksum = checksumBuilder.messageDigest(value);
        System.out.println(checksum);
    }

    public String messageDigest(String string) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(HASH_FUNCTION);
        byte[] digestBytes = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
        return new String(digestBytes);
    }

    public String toBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public byte[] base64ToBytes(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }
}
