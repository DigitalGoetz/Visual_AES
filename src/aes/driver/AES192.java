
package aes.driver;

import aes.layers.ByteSubstitution;
import aes.layers.KeyAddition;
import aes.layers.MixColumns;
import aes.layers.ShiftRows;
import aes.utility.*;
import java.util.ArrayList;

public class AES192 {
    
    ArrayList<ByteArray> schedule;
    ByteArray message;
    ByteArray cipherText;
    
    public AES192(String key, String plain) {
        KeySchedule keySchedule = new KeySchedule(HexReader.getByteArray(key), ByteArray.SIZE_192);
        schedule = keySchedule.generateKeySchedule();
        message = ByteArray.makeByteArray(plain);
    }
    
    public ByteArray enc_round(ByteArray input, ByteArray key){
        ByteArray subsResult = ByteSubstitution.subs(input);
        ByteArray shiftResult = ShiftRows.shiftRows(subsResult);
        ByteArray mixResult = MixColumns.mix(shiftResult);
        ByteArray result = KeyAddition.KeyAdd(mixResult, key);
        return result;
    }
    
    public ByteArray dec_firstRound(ByteArray input, ByteArray key){
        ByteArray keyResult = KeyAddition.KeyAdd(input, key);
        ByteArray shiftResult = ShiftRows.inv_shiftRows(keyResult);
        ByteArray subResult = ByteSubstitution.inv_subs(shiftResult);
        return subResult;
    }
    
    public ByteArray dec_round(ByteArray input, ByteArray key){
        ByteArray keyResult = KeyAddition.KeyAdd(input, key);
        ByteArray mixResult = MixColumns.inv_mix(keyResult);
        ByteArray shiftResult = ShiftRows.inv_shiftRows(mixResult);
        ByteArray subResult = ByteSubstitution.inv_subs(shiftResult);
        return subResult;
    }
    
    public ByteArray enc_finalRound(ByteArray input, ByteArray key){
        ByteArray subsResult = ByteSubstitution.subs(input);
        ByteArray shiftResult = ShiftRows.shiftRows(subsResult);
        ByteArray result = KeyAddition.KeyAdd(shiftResult, key);
        return result;
    }
    
    public ByteArray performDecryption(){
        ByteArray plainText;
        
        plainText = dec_firstRound(cipherText, schedule.get(AES192.ROUNDS));
        for(int i = AES192.ROUNDS - 1; i > 0; i--){
            plainText = dec_round(plainText, schedule.get(i));
        }
        
        plainText = KeyAddition.KeyAdd(plainText, schedule.get(0));
        return plainText;
    }
    
    
    public ByteArray performEncryption(){
        
        ByteArray cipher = KeyAddition.KeyAdd(message, schedule.get(0));
        for(int i = 1; i < AES192.ROUNDS; i++){
            cipher = enc_round(cipher, schedule.get(i));
        }
        
        cipher = enc_finalRound(cipher, schedule.get(AES192.ROUNDS));
        cipherText = cipher;
        return cipher;
    }
    
    private static int ROUNDS = 12;
}
