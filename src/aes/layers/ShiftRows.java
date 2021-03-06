package aes.layers;

import aes.utility.ByteArray;
import javax.swing.JTextArea;

public class ShiftRows {

    public static ByteArray shiftRows(ByteArray block, JTextArea out) {
        out.append( block.toString() + " = ShiftRow in\n");
        int[] bytes = new int[16];
        bytes[0] = block.getByte(0);
        bytes[1] = block.getByte(5);
        bytes[2] = block.getByte(10);
        bytes[3] = block.getByte(15);
        bytes[4] = block.getByte(4);
        bytes[5] = block.getByte(9);
        bytes[6] = block.getByte(14);
        bytes[7] = block.getByte(3);
        bytes[8] = block.getByte(8);
        bytes[9] = block.getByte(13);
        bytes[10] = block.getByte(2);
        bytes[11] = block.getByte(7);
        bytes[12] = block.getByte(12);
        bytes[13] = block.getByte(1);
        bytes[14] = block.getByte(6);
        bytes[15] = block.getByte(11);

        ByteArray results = new ByteArray(bytes);
        out.append(results.toString() + " = ShiftRow out\n");
        return results;
    }

    public static ByteArray inv_shiftRows(ByteArray block, JTextArea out) {
        out.append(block.toString() + " = InvShiftRow in\n");
        int[] bytes = new int[16];
        bytes[0] = block.getByte(0);
        bytes[1] = block.getByte(13);
        bytes[2] = block.getByte(10);
        bytes[3] = block.getByte(7);
        bytes[4] = block.getByte(4);
        bytes[5] = block.getByte(1);
        bytes[6] = block.getByte(14);
        bytes[7] = block.getByte(11);
        bytes[8] = block.getByte(8);
        bytes[9] = block.getByte(5);
        bytes[10] = block.getByte(2);
        bytes[11] = block.getByte(15);
        bytes[12] = block.getByte(12);
        bytes[13] = block.getByte(9);
        bytes[14] = block.getByte(6);
        bytes[15] = block.getByte(3);

        ByteArray results = new ByteArray(bytes);
        out.append(results.toString() + " = InvShiftRow out\n");
        return results;
    }
}
