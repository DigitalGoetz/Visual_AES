
package aes.driver;

import aes.layers.ByteSubstitution;
import aes.layers.KeyAddition;
import aes.layers.MixColumns;
import aes.layers.ShiftRows;
import aes.utility.ByteArray;
import aes.utility.HexReader;
import aes.utility.KeySchedule;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class AES256 {
    
    ArrayList<ByteArray> schedule;
    public ByteArray message;
    public ByteArray cipherText;
    public ByteArray plainText;
    JTextArea out;
    
    public AES256(String key, String plain, JTextArea output) {
        KeySchedule keySchedule = new KeySchedule(HexReader.getByteArray(key), ByteArray.SIZE_256);
        schedule = keySchedule.generateKeySchedule();
        message = ByteArray.makeByteArray(plain);
        out = output;
    }
    
    public ByteArray enc_round(ByteArray input, ByteArray key){
        ByteArray subsResult = ByteSubstitution.subs(input, out);
        ByteArray shiftResult = ShiftRows.shiftRows(subsResult, out);
        ByteArray mixResult = MixColumns.mix(shiftResult, out);
        ByteArray result = KeyAddition.KeyAdd(mixResult, key, out);
        return result;
    }
    
    public ByteArray end_finalRound(ByteArray input, ByteArray key){
        ByteArray subsResult = ByteSubstitution.subs(input, out);
        ByteArray shiftResult = ShiftRows.shiftRows(subsResult, out);
        ByteArray result = KeyAddition.KeyAdd(shiftResult, key, out);
        return result;
    }
    
    public ByteArray dec_firstRound(ByteArray input, ByteArray key){
        ByteArray keyResult = KeyAddition.KeyAdd(input, key, out);
        ByteArray shiftResult = ShiftRows.inv_shiftRows(keyResult, out);
        ByteArray subResult = ByteSubstitution.inv_subs(shiftResult, out);
        return subResult;
    }
    
    public ByteArray dec_round(ByteArray input, ByteArray key){
        ByteArray keyResult = KeyAddition.KeyAdd(input, key, out);
        ByteArray mixResult = MixColumns.inv_mix(keyResult, out);
        ByteArray shiftResult = ShiftRows.inv_shiftRows(mixResult, out);
        ByteArray subResult = ByteSubstitution.inv_subs(shiftResult, out);
        return subResult;
    }
    
    public ByteArray performEncryption(){
        
        ByteArray cipher = KeyAddition.KeyAdd(message, schedule.get(0), out);
        for(int i = 1; i < AES256.ROUNDS; i++){
            cipher = enc_round(cipher, this.schedule.get(i));
        }
        
        cipher = end_finalRound(cipher, this.schedule.get(AES256.ROUNDS));
        this.cipherText = cipher;
        return cipher;
    }
    
        public ByteArray performDecryption(){
        plainText = dec_firstRound(cipherText, schedule.get(AES256.ROUNDS));
        for(int i = AES256.ROUNDS - 1; i > 0; i--){
            plainText = dec_round(plainText, schedule.get(i));
        }
        
        plainText = KeyAddition.KeyAdd(plainText, schedule.get(0), out);
        return plainText;
    }
    
    private static int ROUNDS = 14;
}
