package aes.layers;

import aes.utility.ByteArray;
import aes.utility.Word;
import javax.swing.JTextArea;

public class KeyAddition {

    public static ByteArray KeyAdd(ByteArray block, ByteArray key, JTextArea out) {
        out.append(block.toString() + " = KeyAddition input 1\n");
        out.append(key.toString() + " = KeyAddition input 2\n");
        Word a, b, c, d;
        a = Word.XOR(block.getWord(0), key.getWord(0));
        b = Word.XOR(block.getWord(1), key.getWord(1));
        c = Word.XOR(block.getWord(2), key.getWord(2));
        d = Word.XOR(block.getWord(3), key.getWord(3));

        ByteArray results = new ByteArray(a, b, c, d);
        out.append(results.toString() + " = KeyAddition out\n" );
        return results;
    }
    

}
