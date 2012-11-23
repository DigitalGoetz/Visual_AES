
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
        message = new ByteArray(ByteArray.SIZE_128);
        
        key128 = new ByteArray(ByteArray.SIZE_128);
        ks128 = new KeySchedule(key128, ByteArray.SIZE_128);
        keys128 = ks128.generateKeySchedule();
        smallAES = new AES128(keys128, message);
        
        key192 = new ByteArray(ByteArray.SIZE_192);
        ks192 = new KeySchedule(key192, ByteArray.SIZE_192);
        keys192 = ks192.generateKeySchedule();
        medAES = new AES192(keys192, message);
        
        key256 = new ByteArray(ByteArray.SIZE_256);
        ks256 = new KeySchedule(key256, ByteArray.SIZE_256);
        keys256 = ks256.generateKeySchedule();
        largeAES = new AES256(keys256, message);
        
        print();
        
    }
    
    public void print(){
        System.out.println("message=" + message.toString());
        System.out.println();
        System.out.println("128 AES:");
        System.out.println("key =" + key128.toString());
        System.out.println("cipher text = " + smallAES.getCipherText());
        System.out.println();
        System.out.println("128 AES:");
        System.out.println("key =" + key192.toString());
        System.out.println("cipher text = " + medAES.getCipherText());
        System.out.println();
        System.out.println("128 AES:");
        System.out.println("key =" + key256.toString());
        System.out.println("cipher text = " + largeAES.getCipherText());
    }
}
