/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aes.utility;

/**
 *
 * @author Michael.Goetz
 */
public class Tool {
    
    public static int sbox(int input){
        return 0;
    }
    
    public static int roundConstant(int roundNumber){
        switch(roundNumber){
            case 1:
                return 0x01;
            case 2:
                return 0x02;
            case 3: 
                return 0x04;
            case 4: 
                return 0x08;
            case 5:
                return 0x10;
            case 6: 
                return 0x20;
            case 7:
                return 0x40;
            case 8: 
                return 0x80;
            case 9:
                return 0x1B;
            case 10:
                return 0x36;
            default:
                System.out.println("something broken in RC method...");
                return 0x00;
        }
    }
    
}
