
package aes.utility;

public class HexReader {
    
    String hexString;
    int size;
    byte[] bytes;
    
    public HexReader(String hexString){
        this.hexString = hexString;
        size = (hexString.length() / 2);
        setByteArray(this.hexString);
        
    }
    
    private static void setByteArray(String hex){
        for(int i = 0; i < hex.length(); i += 2){
            char a = hex.charAt(i);
            char b = hex.charAt(i+ 1);
            String s = String.valueOf(a) + String.valueOf(b);
            System.out.println(s);
        }
    }
    
    public static void main(String[] args){
        String a = "6ba7310fedf74184db6e139f0529a212";
        setByteArray(a);
    }
    
    
    
}
