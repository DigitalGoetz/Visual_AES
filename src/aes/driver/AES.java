

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
        smallAES = new AES128(key128.toString(), message.toString());
        
        key192 = ByteArray.random(ByteArray.SIZE_192);
        medAES = new AES192(key192.toString(), message.toString());
        
        key256 = ByteArray.random(ByteArray.SIZE_256);
        largeAES = new AES256(key256.toString(), message.toString());
        
        print();
        
    }
    
    private void print(){
        System.out.println("128 AES:");
        System.out.println("encryption key =" + key128.toString());
        System.out.println("plain message  =" + smallAES.message);
        System.out.println("encrypted text =" + smallAES.performEncryption().toString());
        System.out.println("decrypted text =" + smallAES.performDecryption().toString());
        
        System.out.println("192 AES:");
        System.out.println("encryption key =" + key192.toString());
        System.out.println("plain message  =" + medAES.message);
        System.out.println("encrypted text =" + medAES.performEncryption().toString());
        System.out.println("decrypted text =" + medAES.performDecryption().toString());
        
        System.out.println("256 AES:");
        System.out.println("encryption key =" + key256.toString());
        System.out.println("plain message  =" + largeAES.message);
        System.out.println("encrypted text =" + largeAES.performEncryption().toString());
        System.out.println("decrypted text =" + largeAES.performDecryption().toString());
        
    }
}
