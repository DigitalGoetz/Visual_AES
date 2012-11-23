/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.utility;

/**
 *
 * @author Michael.Goetz
 */
public class ByteSubstitution {
    
    ByteArray output;
    
    public ByteSubstitution(ByteArray input){
        
        int[] bytes = new int[16];
        bytes[0] = input.getByte(0);
        bytes[1] = input.getByte(1);
        bytes[2] = input.getByte(2);
        bytes[3] = input.getByte(3);
        bytes[4] = input.getByte(4);
        bytes[5] = input.getByte(5);
        bytes[6] = input.getByte(6);
        bytes[7] = input.getByte(7);
        bytes[8] = input.getByte(8);
        bytes[9] = input.getByte(9);
        bytes[10] = input.getByte(10);
        bytes[11] = input.getByte(11);
        bytes[12] = input.getByte(12);
        bytes[13] = input.getByte(13);
        bytes[14] = input.getByte(14);
        bytes[15] = input.getByte(15);
        
        bytes[0] = Tool.sbox(bytes[0]);
        bytes[1] = Tool.sbox(bytes[1]);
        bytes[2] = Tool.sbox(bytes[2]);
        bytes[3] = Tool.sbox(bytes[3]);
        bytes[4] = Tool.sbox(bytes[4]);
        bytes[5] = Tool.sbox(bytes[5]);
        bytes[6] = Tool.sbox(bytes[6]);
        bytes[7] = Tool.sbox(bytes[7]);
        bytes[8] = Tool.sbox(bytes[8]);
        bytes[9] = Tool.sbox(bytes[9]);
        bytes[10] = Tool.sbox(bytes[10]);
        bytes[11] = Tool.sbox(bytes[11]);
        bytes[12] = Tool.sbox(bytes[12]);
        bytes[13] = Tool.sbox(bytes[13]);
        bytes[14] = Tool.sbox(bytes[14]);
        bytes[15] = Tool.sbox(bytes[15]);
        
        output = new ByteArray(bytes);
    }
    
    public ByteArray getOutput(){
        return output;
    }
    

    
}
