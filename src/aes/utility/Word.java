
package aes.utility;


public class Word {
    
    public int byte0;
    public int byte1;
    public int byte2;
    public int byte3;
    
    public Word(){
        
    }
    
    public Word(int a, int b, int c, int d){
        byte0 = a;
        byte1 = b;
        byte2 = c;
        byte3 = d;
    }
    
    public static Word g(int roundNumber, Word source){
        int b0, b1, b2, b3, temp;
        b0 = source.byte0;
        b1 = source.byte1;
        b2 = source.byte2;
        b3 = source.byte3;
                
        temp = b0;
        b0 = b1;
        b1 = b2;
        b2 = b3;
        b3 = temp;
        
        b0 = Tool.sbox(b0);
        b1 = Tool.sbox(b1);
        b2 = Tool.sbox(b2);
        b3 = Tool.sbox(b3);
        
        b0 = b0 ^ Tool.roundConstant(roundNumber);
        
        return new Word(b0, b1, b2, b3);
        
    }
    
    public static Word h(Word source){
        int b0, b1, b2, b3;
        b0 = Tool.sbox(source.byte0);
        b1 = Tool.sbox(source.byte1);
        b2 = Tool.sbox(source.byte2);
        b3 = Tool.sbox(source.byte3);
        
        return new Word(b0, b1, b2, b3);
    }
    
    public static Word XOR(Word a, Word b){
        Word n = new Word();
        n.byte0 = a.byte0 ^ b.byte0;
        n.byte1 = a.byte1 ^ b.byte1;
        n.byte2 = a.byte2 ^ b.byte2;
        n.byte3 = a.byte3 ^ b.byte3;
        return n;
    }
    
    
    
    
}
