
package aes.driver;

import aes.utility.ByteArray;

public class AES {
    ByteArray key128;
    ByteArray key192;
    ByteArray key256;
    ByteArray message;
    
    public AES(){
        message = new ByteArray(ByteArray.SIZE_128);
        key128 = new ByteArray(ByteArray.SIZE_128);
        key192 = new ByteArray(ByteArray.SIZE_192);
        key256 = new ByteArray(ByteArray.SIZE_256);
        
        //Generate Key Schedules
        
        
    }
    
    
    public void print(){
        System.out.println("message=" + message.toString());
        System.out.println("key128 =" + key128.toString());
        System.out.println("key192 =" + key192.toString());
        System.out.println("key256 =" + key256.toString());
    }
    
}
