

package aes.driver;

import aes.utility.ByteArray;
import aes.utility.KeySchedule;
import java.util.ArrayList;

public class AES {
    ByteArray key128;
    ByteArray key192;
    ByteArray key256;
    
    ArrayList<ByteArray> keys128, keys192, keys256;
    KeySchedule ks128, ks192, ks256;
    ByteArray message;
    
    AES128 smallAES;
    AES192 medAES;
    AES256 largeAES;
    
    public AES(){
        message = ByteArray.random(ByteArray.SIZE_128);
        key128 = ByteArray.random(ByteArray.SIZE_128);
        //smallAES = new AES128(key128.toString(), message.toString());
        
        key192 = ByteArray.random(ByteArray.SIZE_192);
        //medAES = new AES192(key192.toString(), message.toString());
        
        key256 = ByteArray.random(ByteArray.SIZE_256);
        //largeAES = new AES256(key256.toString(), message.toString());
        
        print();
        
    }
    
    private void print(){
        System.out.println("128 AES:");
        System.out.println(key128.toString() + " = encryption key");
        System.out.println(smallAES.performEncryption().toString() + " = encrypted text");
        System.out.println(smallAES.performDecryption().toString() + " = decrypted text");
        System.out.println(smallAES.message + " = original message");
        
        System.out.println("192 AES:");
        System.out.println(key192.toString() + " = encryption key");
        System.out.println(medAES.performEncryption().toString() + " = encrypted text");
        System.out.println(medAES.performDecryption().toString() + " = decrypted text");
        System.out.println(medAES.message + " = original message");
        
        System.out.println("256 AES:");
        System.out.println(key256.toString() + " = encryption key");
        System.out.println(largeAES.performEncryption().toString() + " = encrypted text");
        System.out.println(largeAES.performDecryption().toString() + " = decrypted text");
        System.out.println(largeAES.message + " = original message");
        
    }
}
