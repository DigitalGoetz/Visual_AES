
package aes.utility;

public class MixColumns {
    
    ByteArray result;
    
    public MixColumns(ByteArray input){

        int[] bytes = new int[16];
        
        bytes[0] = Tool.ByteSum(
                Tool.XOR(0x02, input.getByte(0)), 
                Tool.XOR(0x03, input.getByte(1)), 
                Tool.XOR(0x01, input.getByte(2)), 
                Tool.XOR(0x01, input.getByte(3)));  
        
        bytes[1] = Tool.ByteSum(
                Tool.XOR(0x01, input.getByte(0)), 
                Tool.XOR(0x02, input.getByte(1)), 
                Tool.XOR(0x03, input.getByte(2)), 
                Tool.XOR(0x01, input.getByte(3)));
        bytes[2] = 
                Tool.ByteSum(
                Tool.XOR(0x01, input.getByte(0)), 
                Tool.XOR(0x01, input.getByte(1)), 
                Tool.XOR(0x02, input.getByte(2)), 
                Tool.XOR(0x03, input.getByte(3)));
        bytes[3] = 
                Tool.ByteSum(
                Tool.XOR(0x03, input.getByte(0)), 
                Tool.XOR(0x01, input.getByte(1)), 
                Tool.XOR(0x01, input.getByte(2)), 
                Tool.XOR(0x02, input.getByte(3)));
        
        
        bytes[4] = Tool.ByteSum(
                Tool.XOR(0x02, input.getByte(4)), 
                Tool.XOR(0x03, input.getByte(5)), 
                Tool.XOR(0x01, input.getByte(6)), 
                Tool.XOR(0x01, input.getByte(7)));
        bytes[5] = Tool.ByteSum(
                Tool.XOR(0x01, input.getByte(4)), 
                Tool.XOR(0x02, input.getByte(5)), 
                Tool.XOR(0x03, input.getByte(6)), 
                Tool.XOR(0x01, input.getByte(7)));
        bytes[6] = Tool.ByteSum(
                Tool.XOR(0x01, input.getByte(4)), 
                Tool.XOR(0x01, input.getByte(5)), 
                Tool.XOR(0x02, input.getByte(6)), 
                Tool.XOR(0x03, input.getByte(7)));
        bytes[7] = Tool.ByteSum(
                Tool.XOR(0x03, input.getByte(4)), 
                Tool.XOR(0x01, input.getByte(5)), 
                Tool.XOR(0x01, input.getByte(6)), 
                Tool.XOR(0x02, input.getByte(7)));
        
        bytes[8] = Tool.ByteSum(
                Tool.XOR(0x02, input.getByte(8)), 
                Tool.XOR(0x03, input.getByte(9)), 
                Tool.XOR(0x01, input.getByte(10)), 
                Tool.XOR(0x01, input.getByte(11)));
        bytes[9] = Tool.ByteSum(
                Tool.XOR(0x01, input.getByte(8)), 
                Tool.XOR(0x02, input.getByte(9)), 
                Tool.XOR(0x03, input.getByte(10)), 
                Tool.XOR(0x01, input.getByte(11)));
        bytes[10] = Tool.ByteSum(
                Tool.XOR(0x01, input.getByte(8)), 
                Tool.XOR(0x01, input.getByte(9)), 
                Tool.XOR(0x02, input.getByte(10)), 
                Tool.XOR(0x03, input.getByte(11)));
        bytes[11] = Tool.ByteSum(
                Tool.XOR(0x03, input.getByte(8)), 
                Tool.XOR(0x01, input.getByte(9)), 
                Tool.XOR(0x01, input.getByte(10)), 
                Tool.XOR(0x02, input.getByte(11)));
        
        bytes[12] = Tool.ByteSum(
                Tool.XOR(0x02, input.getByte(12)), 
                Tool.XOR(0x03, input.getByte(13)), 
                Tool.XOR(0x01, input.getByte(14)), 
                Tool.XOR(0x01, input.getByte(15)));
        bytes[13] = Tool.ByteSum(
                Tool.XOR(0x01, input.getByte(12)), 
                Tool.XOR(0x02, input.getByte(13)), 
                Tool.XOR(0x03, input.getByte(14)), 
                Tool.XOR(0x01, input.getByte(15)));
        bytes[14] = Tool.ByteSum(
                Tool.XOR(0x01, input.getByte(12)), 
                Tool.XOR(0x01, input.getByte(13)), 
                Tool.XOR(0x02, input.getByte(14)), 
                Tool.XOR(0x03, input.getByte(15)));
        bytes[15] = Tool.ByteSum(
                Tool.XOR(0x03, input.getByte(12)), 
                Tool.XOR(0x01, input.getByte(13)), 
                Tool.XOR(0x01, input.getByte(14)), 
                Tool.XOR(0x02, input.getByte(15)));
                
        result = new ByteArray(bytes);
    }
    
    public ByteArray getResult(){
        return result;
    }
}
