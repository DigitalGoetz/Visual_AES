
package aes.utility;

public class KeyAddition {
    
    ByteArray block, key;
    ByteArray result;
    
    public KeyAddition(ByteArray block, ByteArray key){
        this.block = block;
        this.key = key;
        
        Word a, b, c, d;
        a = Word.XOR( block.getWord(0) , key.getWord(0) );
        b = Word.XOR( block.getWord(1) , key.getWord(1) );
        c = Word.XOR( block.getWord(2) , key.getWord(2) );
        d = Word.XOR( block.getWord(3) , key.getWord(3) );
        
        result = new ByteArray(a, b, c, d);
    }
    
    public ByteArray getResult(){
        return result;
    }
    
}
