
package aes.driver;

import aes.utility.*;
import java.util.ArrayList;


public class AES128 {
    ArrayList<ByteArray> schedule;
    ByteArray message;
    ByteArray encoded;
    
    AES128(ArrayList<ByteArray> ks, ByteArray plaintext){
        this.schedule = ks;
        this.message = plaintext;
        
        System.out.println("Message: " + plaintext.toString());
        System.out.println("Key : " + ks.get(0).toString());
    }
    
    public ByteArray round(ByteArray input, ByteArray key){
        ByteArray subsResult = new ByteSubstitution(input).getOutput();
        ByteArray shiftResult = new ShiftRows(subsResult).shiftRows();
        ByteArray mixResult = new MixColumns(shiftResult).getResult();
        ByteArray result = new KeyAddition(mixResult, key).getResult();
        return result;
    }
    
    public void performRounds(){
        
        ByteArray cipher = new KeyAddition(this.message, this.schedule.get(0)).getResult();
        for(int i = 1; i <= AES128.ROUNDS; i++){
            cipher = round(cipher, this.schedule.get(i));
        }
        encoded = cipher;
    }
    
    public ByteArray getCipherText(){
        performRounds();
        return encoded;
    }
    
    private static int ROUNDS = 10;
}
