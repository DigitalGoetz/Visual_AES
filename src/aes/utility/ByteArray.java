
package aes.utility;


public class ByteArray {
    
    int size; 
    int bytes[];
    RandomGenerator generator;
    
    public ByteArray(int size){
        this.size = size;
        generator = RandomGenerator.getInstance();
        bytes = new int[this.size];
        for(int i = 0; i < this.size; i++){
            bytes[i] = generator.getByte();
        }
    }
    
    
    public void printContents(){
        for(int i = 0; i < bytes.length; i++){
            if( i < 10){
                System.out.println("byte 0" + i + "=" + toHex(bytes[i]));
            }else{
                System.out.println("byte " + i + "=" + toHex(bytes[i]));    
            }
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(32);
        for(int i = 0; i < bytes.length; i++){
            sb.append(toHex(bytes[i]));
        }
        return sb.toString();
    }
    
    public String toBin(int b){
        StringBuilder sb = new StringBuilder();
        String iString = Integer.toBinaryString(b);
        
        if(iString.length() < 8){
            int c = 8 - iString.length();
            for(int i = 0; i < c; i++){
                sb.append("0");
            }
            sb.append(iString);
            return sb.toString();
        }else{
            return iString;
        }
        
        
    }
    
    public String toHex(int b){
        if(b < 16){
            StringBuilder sb = new StringBuilder();
            sb.append("0");
            sb.append(Integer.toHexString(b));
            return sb.toString();
        }else{
            return Integer.toHexString(b);    
        }
        
        
    }
    
    
    public static final int SIZE_128 = 16;
    public static final int SIZE_192 = 24;
    public static final int SIZE_256 = 32;
}
