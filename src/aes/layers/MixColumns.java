package aes.layers;

import aes.utility.ByteArray;
import aes.utility.Tool;

public class MixColumns {

    public static ByteArray mix(ByteArray input) {
        int[] bytes = new int[16];

        bytes[0] = Tool.ByteSum(
                Tool.gfMultiply(0x02, input.getByte(0)),
                Tool.gfMultiply(0x03, input.getByte(1)),
                Tool.gfMultiply(0x01, input.getByte(2)),
                Tool.gfMultiply(0x01, input.getByte(3)));

        bytes[1] = Tool.ByteSum(
                Tool.gfMultiply(0x01, input.getByte(0)),
                Tool.gfMultiply(0x02, input.getByte(1)),
                Tool.gfMultiply(0x03, input.getByte(2)),
                Tool.gfMultiply(0x01, input.getByte(3)));
        bytes[2] =
                Tool.ByteSum(
                Tool.gfMultiply(0x01, input.getByte(0)),
                Tool.gfMultiply(0x01, input.getByte(1)),
                Tool.gfMultiply(0x02, input.getByte(2)),
                Tool.gfMultiply(0x03, input.getByte(3)));
        bytes[3] =
                Tool.ByteSum(
                Tool.gfMultiply(0x03, input.getByte(0)),
                Tool.gfMultiply(0x01, input.getByte(1)),
                Tool.gfMultiply(0x01, input.getByte(2)),
                Tool.gfMultiply(0x02, input.getByte(3)));


        bytes[4] = Tool.ByteSum(
                Tool.gfMultiply(0x02, input.getByte(4)),
                Tool.gfMultiply(0x03, input.getByte(5)),
                Tool.gfMultiply(0x01, input.getByte(6)),
                Tool.gfMultiply(0x01, input.getByte(7)));
        bytes[5] = Tool.ByteSum(
                Tool.gfMultiply(0x01, input.getByte(4)),
                Tool.gfMultiply(0x02, input.getByte(5)),
                Tool.gfMultiply(0x03, input.getByte(6)),
                Tool.gfMultiply(0x01, input.getByte(7)));
        bytes[6] = Tool.ByteSum(
                Tool.gfMultiply(0x01, input.getByte(4)),
                Tool.gfMultiply(0x01, input.getByte(5)),
                Tool.gfMultiply(0x02, input.getByte(6)),
                Tool.gfMultiply(0x03, input.getByte(7)));
        bytes[7] = Tool.ByteSum(
                Tool.gfMultiply(0x03, input.getByte(4)),
                Tool.gfMultiply(0x01, input.getByte(5)),
                Tool.gfMultiply(0x01, input.getByte(6)),
                Tool.gfMultiply(0x02, input.getByte(7)));

        bytes[8] = Tool.ByteSum(
                Tool.gfMultiply(0x02, input.getByte(8)),
                Tool.gfMultiply(0x03, input.getByte(9)),
                Tool.gfMultiply(0x01, input.getByte(10)),
                Tool.gfMultiply(0x01, input.getByte(11)));
        bytes[9] = Tool.ByteSum(
                Tool.gfMultiply(0x01, input.getByte(8)),
                Tool.gfMultiply(0x02, input.getByte(9)),
                Tool.gfMultiply(0x03, input.getByte(10)),
                Tool.gfMultiply(0x01, input.getByte(11)));
        bytes[10] = Tool.ByteSum(
                Tool.gfMultiply(0x01, input.getByte(8)),
                Tool.gfMultiply(0x01, input.getByte(9)),
                Tool.gfMultiply(0x02, input.getByte(10)),
                Tool.gfMultiply(0x03, input.getByte(11)));
        bytes[11] = Tool.ByteSum(
                Tool.gfMultiply(0x03, input.getByte(8)),
                Tool.gfMultiply(0x01, input.getByte(9)),
                Tool.gfMultiply(0x01, input.getByte(10)),
                Tool.gfMultiply(0x02, input.getByte(11)));

        bytes[12] = Tool.ByteSum(
                Tool.gfMultiply(0x02, input.getByte(12)),
                Tool.gfMultiply(0x03, input.getByte(13)),
                Tool.gfMultiply(0x01, input.getByte(14)),
                Tool.gfMultiply(0x01, input.getByte(15)));
        bytes[13] = Tool.ByteSum(
                Tool.gfMultiply(0x01, input.getByte(12)),
                Tool.gfMultiply(0x02, input.getByte(13)),
                Tool.gfMultiply(0x03, input.getByte(14)),
                Tool.gfMultiply(0x01, input.getByte(15)));
        bytes[14] = Tool.ByteSum(
                Tool.gfMultiply(0x01, input.getByte(12)),
                Tool.gfMultiply(0x01, input.getByte(13)),
                Tool.gfMultiply(0x02, input.getByte(14)),
                Tool.gfMultiply(0x03, input.getByte(15)));
        bytes[15] = Tool.ByteSum(
                Tool.gfMultiply(0x03, input.getByte(12)),
                Tool.gfMultiply(0x01, input.getByte(13)),
                Tool.gfMultiply(0x01, input.getByte(14)),
                Tool.gfMultiply(0x02, input.getByte(15)));

        return new ByteArray(bytes);
    }

    public static ByteArray inv_mix(ByteArray input) {

        int[] bytes = new int[16];

        bytes[0] = Tool.ByteSum(
                Tool.gfMultiply(0x0E, input.getByte(0)),
                Tool.gfMultiply(0x0B, input.getByte(1)),
                Tool.gfMultiply(0x0D, input.getByte(2)),
                Tool.gfMultiply(0x09, input.getByte(3)));

        bytes[1] = Tool.ByteSum(
                Tool.gfMultiply(0x09, input.getByte(0)),
                Tool.gfMultiply(0x0E, input.getByte(1)),
                Tool.gfMultiply(0x0B, input.getByte(2)),
                Tool.gfMultiply(0x0D, input.getByte(3)));
        bytes[2] =
                Tool.ByteSum(
                Tool.gfMultiply(0x0D, input.getByte(0)),
                Tool.gfMultiply(0x09, input.getByte(1)),
                Tool.gfMultiply(0x0E, input.getByte(2)),
                Tool.gfMultiply(0x0B, input.getByte(3)));
        bytes[3] =
                Tool.ByteSum(
                Tool.gfMultiply(0x0B, input.getByte(0)),
                Tool.gfMultiply(0x0D, input.getByte(1)),
                Tool.gfMultiply(0x09, input.getByte(2)),
                Tool.gfMultiply(0x0E, input.getByte(3)));


        bytes[4] = Tool.ByteSum(
                Tool.gfMultiply(0x0E, input.getByte(4)),
                Tool.gfMultiply(0x0B, input.getByte(5)),
                Tool.gfMultiply(0x0D, input.getByte(6)),
                Tool.gfMultiply(0x09, input.getByte(7)));
        bytes[5] = Tool.ByteSum(
                Tool.gfMultiply(0x09, input.getByte(4)),
                Tool.gfMultiply(0x0E, input.getByte(5)),
                Tool.gfMultiply(0x0B, input.getByte(6)),
                Tool.gfMultiply(0x0D, input.getByte(7)));
        bytes[6] = Tool.ByteSum(
                Tool.gfMultiply(0x0D, input.getByte(4)),
                Tool.gfMultiply(0x09, input.getByte(5)),
                Tool.gfMultiply(0x0E, input.getByte(6)),
                Tool.gfMultiply(0x0B, input.getByte(7)));
        bytes[7] = Tool.ByteSum(
                Tool.gfMultiply(0x0B, input.getByte(4)),
                Tool.gfMultiply(0x0D, input.getByte(5)),
                Tool.gfMultiply(0x09, input.getByte(6)),
                Tool.gfMultiply(0x0E, input.getByte(7)));

        bytes[8] = Tool.ByteSum(
                Tool.gfMultiply(0x0E, input.getByte(8)),
                Tool.gfMultiply(0x0B, input.getByte(9)),
                Tool.gfMultiply(0x0D, input.getByte(10)),
                Tool.gfMultiply(0x09, input.getByte(11)));
        bytes[9] = Tool.ByteSum(
                Tool.gfMultiply(0x09, input.getByte(8)),
                Tool.gfMultiply(0x0E, input.getByte(9)),
                Tool.gfMultiply(0x0B, input.getByte(10)),
                Tool.gfMultiply(0x0D, input.getByte(11)));
        bytes[10] = Tool.ByteSum(
                Tool.gfMultiply(0x0D, input.getByte(8)),
                Tool.gfMultiply(0x09, input.getByte(9)),
                Tool.gfMultiply(0x0E, input.getByte(10)),
                Tool.gfMultiply(0x0B, input.getByte(11)));
        bytes[11] = Tool.ByteSum(
                Tool.gfMultiply(0x0B, input.getByte(8)),
                Tool.gfMultiply(0x0D, input.getByte(9)),
                Tool.gfMultiply(0x09, input.getByte(10)),
                Tool.gfMultiply(0x0E, input.getByte(11)));

        bytes[12] = Tool.ByteSum(
                Tool.gfMultiply(0x0E, input.getByte(12)),
                Tool.gfMultiply(0x0B, input.getByte(13)),
                Tool.gfMultiply(0x0D, input.getByte(14)),
                Tool.gfMultiply(0x09, input.getByte(15)));
        bytes[13] = Tool.ByteSum(
                Tool.gfMultiply(0x09, input.getByte(12)),
                Tool.gfMultiply(0x0E, input.getByte(13)),
                Tool.gfMultiply(0x0B, input.getByte(14)),
                Tool.gfMultiply(0x0D, input.getByte(15)));
        bytes[14] = Tool.ByteSum(
                Tool.gfMultiply(0x0D, input.getByte(12)),
                Tool.gfMultiply(0x09, input.getByte(13)),
                Tool.gfMultiply(0x0E, input.getByte(14)),
                Tool.gfMultiply(0x0B, input.getByte(15)));
        bytes[15] = Tool.ByteSum(
                Tool.gfMultiply(0x0B, input.getByte(12)),
                Tool.gfMultiply(0x0D, input.getByte(13)),
                Tool.gfMultiply(0x09, input.getByte(14)),
                Tool.gfMultiply(0x0E, input.getByte(15)));

        return new ByteArray(bytes);
    }
}
