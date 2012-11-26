package aes.utility;

public class ByteArray {

    int size;
    public int bytes[];
    RandomGenerator generator;

    public static ByteArray random128() {
        ByteArray byteArray = new ByteArray();
        byteArray.size = ByteArray.SIZE_128;
        byteArray.generator = RandomGenerator.getInstance();
        byteArray.bytes = new int[byteArray.size];
        for (int i = 0; i < byteArray.size; i++) {
            byteArray.bytes[i] = byteArray.generator.getByte();
        }
        return byteArray;
    }

    public static ByteArray random192() {
        ByteArray byteArray = new ByteArray();
        byteArray.size = ByteArray.SIZE_192;
        byteArray.generator = RandomGenerator.getInstance();
        byteArray.bytes = new int[byteArray.size];
        for (int i = 0; i < byteArray.size; i++) {
            byteArray.bytes[i] = byteArray.generator.getByte();
        }
        return byteArray;
    }

    public static ByteArray random256() {
        ByteArray byteArray = new ByteArray();
        byteArray.size = ByteArray.SIZE_256;
        byteArray.generator = RandomGenerator.getInstance();
        byteArray.bytes = new int[byteArray.size];
        for (int i = 0; i < byteArray.size; i++) {
            byteArray.bytes[i] = byteArray.generator.getByte();
        }
        return byteArray;
    }

    public static ByteArray random(int size) {
        if (size == ByteArray.SIZE_128) {
            return ByteArray.random128();
        } else if (size == ByteArray.SIZE_192) {
            return ByteArray.random192();
        } else if (size == ByteArray.SIZE_256) {
            return ByteArray.random256();
        } else {
            return null;
        }
    }

    public static ByteArray makeByteArray(String input) {
        return HexReader.getByteArray(input);
    }

    public ByteArray(int[] array) {
        bytes = array;
        size = bytes.length;
        generator = RandomGenerator.getInstance();
    }

    public ByteArray() {
    }

    public ByteArray(Word a, Word b, Word c, Word d) {
        int[] bytes_array = new int[4 * 4];
        bytes_array[0] = a.byte0;
        bytes_array[1] = a.byte1;
        bytes_array[2] = a.byte2;
        bytes_array[3] = a.byte3;

        bytes_array[4] = b.byte0;
        bytes_array[5] = b.byte1;
        bytes_array[6] = b.byte2;
        bytes_array[7] = b.byte3;

        bytes_array[8] = c.byte0;
        bytes_array[9] = c.byte1;
        bytes_array[10] = c.byte2;
        bytes_array[11] = c.byte3;

        bytes_array[12] = d.byte0;
        bytes_array[13] = d.byte1;
        bytes_array[14] = d.byte2;
        bytes_array[15] = d.byte3;

        bytes = bytes_array;
        size = bytes.length;
        generator = RandomGenerator.getInstance();
    }

    public ByteArray(Word a, Word b, Word c, Word d, Word e, Word f) {
        int[] bytes_array = new int[4 * 6];
        bytes_array[0] = a.byte0;
        bytes_array[1] = a.byte1;
        bytes_array[2] = a.byte2;
        bytes_array[3] = a.byte3;

        bytes_array[4] = b.byte0;
        bytes_array[5] = b.byte1;
        bytes_array[6] = b.byte2;
        bytes_array[7] = b.byte3;

        bytes_array[8] = c.byte0;
        bytes_array[9] = c.byte1;
        bytes_array[10] = c.byte2;
        bytes_array[11] = c.byte3;

        bytes_array[12] = d.byte0;
        bytes_array[13] = d.byte1;
        bytes_array[14] = d.byte2;
        bytes_array[15] = d.byte3;

        bytes_array[16] = e.byte0;
        bytes_array[17] = e.byte1;
        bytes_array[18] = e.byte2;
        bytes_array[19] = e.byte3;

        bytes_array[20] = f.byte0;
        bytes_array[21] = f.byte1;
        bytes_array[22] = f.byte2;
        bytes_array[23] = f.byte3;

        bytes = bytes_array;
        size = bytes.length;
        generator = RandomGenerator.getInstance();
    }

    public ByteArray(Word a, Word b, Word c, Word d, Word e, Word f, Word g, Word h) {
        int[] bytes_array = new int[4 * 6];
        bytes_array[0] = a.byte0;
        bytes_array[1] = a.byte1;
        bytes_array[2] = a.byte2;
        bytes_array[3] = a.byte3;

        bytes_array[4] = b.byte0;
        bytes_array[5] = b.byte1;
        bytes_array[6] = b.byte2;
        bytes_array[7] = b.byte3;

        bytes_array[8] = c.byte0;
        bytes_array[9] = c.byte1;
        bytes_array[10] = c.byte2;
        bytes_array[11] = c.byte3;

        bytes_array[12] = d.byte0;
        bytes_array[13] = d.byte1;
        bytes_array[14] = d.byte2;
        bytes_array[15] = d.byte3;

        bytes_array[16] = e.byte0;
        bytes_array[17] = e.byte1;
        bytes_array[18] = e.byte2;
        bytes_array[19] = e.byte3;

        bytes_array[20] = f.byte0;
        bytes_array[21] = f.byte1;
        bytes_array[22] = f.byte2;
        bytes_array[23] = f.byte3;

        bytes_array[24] = g.byte0;
        bytes_array[25] = g.byte1;
        bytes_array[26] = g.byte2;
        bytes_array[27] = g.byte3;

        bytes_array[28] = h.byte0;
        bytes_array[29] = h.byte1;
        bytes_array[30] = h.byte2;
        bytes_array[31] = h.byte3;

        bytes = bytes_array;
        size = bytes.length;
        generator = RandomGenerator.getInstance();
    }

    public Word getWord(int index) {
        int i = index * 4;
        return new Word(bytes[i], bytes[i + 1], bytes[i + 2], bytes[i + 3]);
    }

    public int getByte(int index) {
        return bytes[index];
    }

    public void setByte(int index, int value) {
        bytes[index] = value;
    }

    public void printContents() {
        for (int i = 0; i < bytes.length; i++) {
            if (i < 10) {
                System.out.println("byte 0" + i + "=" + toHex(bytes[i]));
            } else {
                System.out.println("byte " + i + "=" + toHex(bytes[i]));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        for (int i = 0; i < bytes.length; i++) {
            sb.append(toHex(bytes[i]));
        }
        return sb.toString();
    }

    public String toBin(int b) {
        StringBuilder sb = new StringBuilder();
        String iString = Integer.toBinaryString(b);

        if (iString.length() < 8) {
            int c = 8 - iString.length();
            for (int i = 0; i < c; i++) {
                sb.append("0");
            }
            sb.append(iString);
            return sb.toString();
        } else {
            return iString;
        }


    }

    public String toHex(int b) {
        if (b < 16) {
            StringBuilder sb = new StringBuilder();
            sb.append("0");
            sb.append(Integer.toHexString(b));
            return sb.toString();
        } else {
            return Integer.toHexString(b);
        }
    }
    public static final int SIZE_128 = 16;
    public static final int SIZE_192 = 24;
    public static final int SIZE_256 = 32;
}
