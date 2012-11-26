package aes.utility;

public class HexReader {

    public static ByteArray getByteArray(String hexString) {
        int size = (hexString.length() / 2);
        int[] bytes = new int[size];

        for (int i = 0; i < size; i++) {
            char a = hexString.charAt(2 * i);
            char b = hexString.charAt(2 * i + 1);
            String s = String.valueOf(a) + String.valueOf(b);

            bytes[i] = Integer.parseInt(s, 16);
        }

        return new ByteArray(bytes);
    }
}
