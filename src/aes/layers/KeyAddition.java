package aes.layers;

import aes.utility.ByteArray;
import aes.utility.Word;

public class KeyAddition {

    public static ByteArray KeyAdd(ByteArray block, ByteArray key) {
        Word a, b, c, d;
        a = Word.XOR(block.getWord(0), key.getWord(0));
        b = Word.XOR(block.getWord(1), key.getWord(1));
        c = Word.XOR(block.getWord(2), key.getWord(2));
        d = Word.XOR(block.getWord(3), key.getWord(3));

        return new ByteArray(a, b, c, d);
    }
}
