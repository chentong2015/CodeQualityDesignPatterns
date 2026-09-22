package random;

import java.util.*;

public class RandomGenerator {

    // TODO. 随机组合生成字符串(随机密码)
    public String createRandomString() {
        int alphaLength = 5;
        int numericLength = 2;
        int specialLength = 2;

        String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        String numericString = "0123456789";
        String specialString = "!@#$%&";

        List<Character> characters = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < alphaLength; i++) {
            int index = rand.nextInt(alphaString.length());
            characters.add(alphaString.charAt(index));
        }
        for (int i = 0; i < numericLength; i++) {
            int index = rand.nextInt(numericString.length());
            characters.add(numericString.charAt(index));
        }
        for (int i = 0; i < specialLength; i++) {
            int index = rand.nextInt(specialString.length());
            characters.add(specialString.charAt(index));
        }

        Collections.shuffle(characters);

        for (int i = 0; i < characters.size(); i++) {
            sb.append(characters.get(i));
        }
        return sb.toString();
    }

    // TODO. 自动义生成某范围内的随机int值
    // Design algo to generate an int number between 0 and bound
    // 0 <= ? < bound 什么样的逻辑能够使得数字均匀的生成 ??
    public int generateRandomNumber(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        // bound is a power of 2
        if ((bound & -bound) == bound) {
            // return (int)((bound * (long)next(31)) >> 31);
            return bound / 2;
        }
        int bits, val;
        do {
            // bits = next(31);
            bits = 10;
            val = bits % bound;
        } while (bits - val + (bound - 1) < 0);
        return val;
    }
}
