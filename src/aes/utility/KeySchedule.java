package aes.utility;

import java.util.ArrayList;

public class KeySchedule {

    ByteArray key;
    int keySize;
    ArrayList<ByteArray> keyList;
    ArrayList<Word> wordList;

    public KeySchedule(ByteArray key, int keySize) {
        this.key = key;
        this.keySize = keySize;
        wordList = new ArrayList<>();
    }

    public ArrayList<ByteArray> generateKeySchedule() {
        switch (keySize) {
            case ByteArray.SIZE_128:
                generate128();
                return getKeyList();
            case ByteArray.SIZE_192:
                generate192();
                return getKeyList();
            case ByteArray.SIZE_256:
                generate256();
                return getKeyList();
            default:
                System.out.println("Error in keysize");
                break;

        }
        return null;
    }

    private ArrayList<ByteArray> getKeyList() {
        keyList = new ArrayList<>();
        int wordSize = wordList.size() / 4;

        for (int i = 0; i < wordSize; i++) {
            Word a = wordList.get(4 * i);
            Word b = wordList.get(4 * i + 1);
            Word c = wordList.get(4 * i + 2);
            Word d = wordList.get(4 * i + 3);
            keyList.add(new ByteArray(a, b, c, d));
        }

        return keyList;
    }

    private void generate128() {
        Word[] round_0 = new Word[4];
        round_0[0] = key.getWord(0);
        round_0[1] = key.getWord(1);
        round_0[2] = key.getWord(2);
        round_0[3] = key.getWord(3);
        wordList.add(round_0[0]);
        wordList.add(round_0[1]);
        wordList.add(round_0[2]);
        wordList.add(round_0[3]);

        Word[] round_1 = new Word[4];
        Word r1 = Word.g(1, round_0[3]);
        round_1[0] = Word.XOR(round_0[0], r1);
        round_1[1] = Word.XOR(round_1[0], round_0[1]);
        round_1[2] = Word.XOR(round_1[1], round_0[2]);
        round_1[3] = Word.XOR(round_1[2], round_0[3]);
        wordList.add(round_1[0]);
        wordList.add(round_1[1]);
        wordList.add(round_1[2]);
        wordList.add(round_1[3]);


        Word[] round_2 = new Word[4];
        Word r2 = Word.g(2, round_1[3]);
        round_2[0] = Word.XOR(round_1[0], r2);
        round_2[1] = Word.XOR(round_2[0], round_1[1]);
        round_2[2] = Word.XOR(round_2[1], round_1[2]);
        round_2[3] = Word.XOR(round_2[2], round_1[3]);
        wordList.add(round_2[0]);
        wordList.add(round_2[1]);
        wordList.add(round_2[2]);
        wordList.add(round_2[3]);


        Word[] round_3 = new Word[4];
        Word r3 = Word.g(3, round_2[3]);
        round_3[0] = Word.XOR(round_2[0], r3);
        round_3[1] = Word.XOR(round_3[0], round_2[1]);
        round_3[2] = Word.XOR(round_3[1], round_2[2]);
        round_3[3] = Word.XOR(round_3[2], round_2[3]);
        wordList.add(round_3[0]);
        wordList.add(round_3[1]);
        wordList.add(round_3[2]);
        wordList.add(round_3[3]);

        Word[] round_4 = new Word[4];
        Word r4 = Word.g(4, round_3[3]);
        round_4[0] = Word.XOR(round_3[0], r4);
        round_4[1] = Word.XOR(round_4[0], round_3[1]);
        round_4[2] = Word.XOR(round_4[1], round_3[2]);
        round_4[3] = Word.XOR(round_4[2], round_3[3]);
        wordList.add(round_4[0]);
        wordList.add(round_4[1]);
        wordList.add(round_4[2]);
        wordList.add(round_4[3]);

        Word[] round_5 = new Word[4];
        Word r5 = Word.g(5, round_4[3]);
        round_5[0] = Word.XOR(round_4[0], r5);
        round_5[1] = Word.XOR(round_5[0], round_4[1]);
        round_5[2] = Word.XOR(round_5[1], round_4[2]);
        round_5[3] = Word.XOR(round_5[2], round_4[3]);
        wordList.add(round_5[0]);
        wordList.add(round_5[1]);
        wordList.add(round_5[2]);
        wordList.add(round_5[3]);

        Word[] round_6 = new Word[4];
        Word r6 = Word.g(6, round_5[3]);
        round_6[0] = Word.XOR(round_5[0], r6);
        round_6[1] = Word.XOR(round_6[0], round_5[1]);
        round_6[2] = Word.XOR(round_6[1], round_5[2]);
        round_6[3] = Word.XOR(round_6[2], round_5[3]);
        wordList.add(round_6[0]);
        wordList.add(round_6[1]);
        wordList.add(round_6[2]);
        wordList.add(round_6[3]);

        Word[] round_7 = new Word[4];
        Word r7 = Word.g(7, round_6[3]);
        round_7[0] = Word.XOR(round_6[0], r7);
        round_7[1] = Word.XOR(round_7[0], round_6[1]);
        round_7[2] = Word.XOR(round_7[1], round_6[2]);
        round_7[3] = Word.XOR(round_7[2], round_6[3]);
        wordList.add(round_7[0]);
        wordList.add(round_7[1]);
        wordList.add(round_7[2]);
        wordList.add(round_7[3]);

        Word[] round_8 = new Word[4];
        Word r8 = Word.g(8, round_7[3]);
        round_8[0] = Word.XOR(round_7[0], r8);
        round_8[1] = Word.XOR(round_8[0], round_7[1]);
        round_8[2] = Word.XOR(round_8[1], round_7[2]);
        round_8[3] = Word.XOR(round_8[2], round_7[3]);
        wordList.add(round_8[0]);
        wordList.add(round_8[1]);
        wordList.add(round_8[2]);
        wordList.add(round_8[3]);

        Word[] round_9 = new Word[4];
        Word r9 = Word.g(9, round_8[3]);
        round_9[0] = Word.XOR(round_8[0], r9);
        round_9[1] = Word.XOR(round_9[0], round_8[1]);
        round_9[2] = Word.XOR(round_9[1], round_8[2]);
        round_9[3] = Word.XOR(round_9[2], round_8[3]);
        wordList.add(round_9[0]);
        wordList.add(round_9[1]);
        wordList.add(round_9[2]);
        wordList.add(round_9[3]);

        Word[] round_10 = new Word[4];
        Word r10 = Word.g(10, round_9[3]);
        round_10[0] = Word.XOR(round_9[0], r10);
        round_10[1] = Word.XOR(round_10[0], round_9[1]);
        round_10[2] = Word.XOR(round_10[1], round_9[2]);
        round_10[3] = Word.XOR(round_10[2], round_9[3]);
        wordList.add(round_10[0]);
        wordList.add(round_10[1]);
        wordList.add(round_10[2]);
        wordList.add(round_10[3]);

    }

    private void generate192() {

        Word[] round_0 = new Word[6];
        round_0[0] = key.getWord(0);
        round_0[1] = key.getWord(1);
        round_0[2] = key.getWord(2);
        round_0[3] = key.getWord(3);
        round_0[4] = key.getWord(4);
        round_0[5] = key.getWord(5);
        wordList.add(round_0[0]);
        wordList.add(round_0[1]);
        wordList.add(round_0[2]);
        wordList.add(round_0[3]);
        wordList.add(round_0[4]);
        wordList.add(round_0[5]);

        Word[] round_1 = new Word[6];
        Word r1 = Word.g(1, round_0[5]);
        round_1[0] = Word.XOR(round_0[0], r1);
        round_1[1] = Word.XOR(round_1[0], round_0[1]);
        round_1[2] = Word.XOR(round_1[1], round_0[2]);
        round_1[3] = Word.XOR(round_1[2], round_0[3]);
        round_1[4] = Word.XOR(round_1[3], round_0[4]);
        round_1[5] = Word.XOR(round_1[4], round_0[5]);
        wordList.add(round_1[0]);
        wordList.add(round_1[1]);
        wordList.add(round_1[2]);
        wordList.add(round_1[3]);
        wordList.add(round_1[4]);
        wordList.add(round_1[5]);

        Word[] round_2 = new Word[6];
        Word r2 = Word.g(2, round_1[5]);
        round_2[0] = Word.XOR(round_1[0], r2);
        round_2[1] = Word.XOR(round_2[0], round_1[1]);
        round_2[2] = Word.XOR(round_2[1], round_1[2]);
        round_2[3] = Word.XOR(round_2[2], round_1[3]);
        round_2[4] = Word.XOR(round_2[3], round_1[4]);
        round_2[5] = Word.XOR(round_2[4], round_1[5]);
        wordList.add(round_2[0]);
        wordList.add(round_2[1]);
        wordList.add(round_2[2]);
        wordList.add(round_2[3]);
        wordList.add(round_2[4]);
        wordList.add(round_2[5]);

        Word[] round_3 = new Word[6];
        Word r3 = Word.g(3, round_2[5]);
        round_3[0] = Word.XOR(round_2[0], r3);
        round_3[1] = Word.XOR(round_3[0], round_2[1]);
        round_3[2] = Word.XOR(round_3[1], round_2[2]);
        round_3[3] = Word.XOR(round_3[2], round_2[3]);
        round_3[4] = Word.XOR(round_3[3], round_2[4]);
        round_3[5] = Word.XOR(round_3[4], round_2[5]);
        wordList.add(round_3[0]);
        wordList.add(round_3[1]);
        wordList.add(round_3[2]);
        wordList.add(round_3[3]);
        wordList.add(round_3[4]);
        wordList.add(round_3[5]);

        Word[] round_4 = new Word[6];
        Word r4 = Word.g(4, round_3[5]);
        round_4[0] = Word.XOR(round_3[0], r4);
        round_4[1] = Word.XOR(round_4[0], round_3[1]);
        round_4[2] = Word.XOR(round_4[1], round_3[2]);
        round_4[3] = Word.XOR(round_4[2], round_3[3]);
        round_4[4] = Word.XOR(round_4[3], round_3[4]);
        round_4[5] = Word.XOR(round_4[4], round_3[5]);
        wordList.add(round_4[0]);
        wordList.add(round_4[1]);
        wordList.add(round_4[2]);
        wordList.add(round_4[3]);
        wordList.add(round_4[4]);
        wordList.add(round_4[5]);

        Word[] round_5 = new Word[6];
        Word r5 = Word.g(5, round_4[5]);
        round_5[0] = Word.XOR(round_4[0], r5);
        round_5[1] = Word.XOR(round_5[0], round_4[1]);
        round_5[2] = Word.XOR(round_5[1], round_4[2]);
        round_5[3] = Word.XOR(round_5[2], round_4[3]);
        round_5[4] = Word.XOR(round_5[3], round_4[4]);
        round_5[5] = Word.XOR(round_5[4], round_4[5]);
        wordList.add(round_5[0]);
        wordList.add(round_5[1]);
        wordList.add(round_5[2]);
        wordList.add(round_5[3]);
        wordList.add(round_5[4]);
        wordList.add(round_5[5]);

        Word[] round_6 = new Word[6];
        Word r6 = Word.g(6, round_5[5]);
        round_6[0] = Word.XOR(round_5[0], r6);
        round_6[1] = Word.XOR(round_6[0], round_5[1]);
        round_6[2] = Word.XOR(round_6[1], round_5[2]);
        round_6[3] = Word.XOR(round_6[2], round_5[3]);
        round_6[4] = Word.XOR(round_6[3], round_5[4]);
        round_6[5] = Word.XOR(round_6[4], round_5[5]);
        wordList.add(round_6[0]);
        wordList.add(round_6[1]);
        wordList.add(round_6[2]);
        wordList.add(round_6[3]);
        wordList.add(round_6[4]);
        wordList.add(round_6[5]);

        Word[] round_7 = new Word[6];
        Word r7 = Word.g(7, round_6[5]);
        round_7[0] = Word.XOR(round_6[0], r7);
        round_7[1] = Word.XOR(round_7[0], round_6[1]);
        round_7[2] = Word.XOR(round_7[1], round_6[2]);
        round_7[3] = Word.XOR(round_7[2], round_6[3]);
        round_7[4] = Word.XOR(round_7[3], round_6[4]);
        round_7[5] = Word.XOR(round_7[4], round_6[5]);
        wordList.add(round_7[0]);
        wordList.add(round_7[1]);
        wordList.add(round_7[2]);
        wordList.add(round_7[3]);
        wordList.add(round_7[4]);
        wordList.add(round_7[5]);

        Word[] round_8 = new Word[4];
        Word r8 = Word.g(8, round_7[5]);
        round_8[0] = Word.XOR(round_7[0], r8);
        round_8[1] = Word.XOR(round_8[0], round_7[1]);
        round_8[2] = Word.XOR(round_8[1], round_7[2]);
        round_8[3] = Word.XOR(round_8[2], round_7[3]);
        wordList.add(round_8[0]);
        wordList.add(round_8[1]);
        wordList.add(round_8[2]);
        wordList.add(round_8[3]);

    }

    private void generate256() {

        Word[] round_0 = new Word[8];
        round_0[0] = key.getWord(0);
        round_0[1] = key.getWord(1);
        round_0[2] = key.getWord(2);
        round_0[3] = key.getWord(3);
        round_0[4] = key.getWord(4);
        round_0[5] = key.getWord(5);
        round_0[6] = key.getWord(6);
        round_0[7] = key.getWord(7);
        wordList.add(round_0[0]);
        wordList.add(round_0[1]);
        wordList.add(round_0[2]);
        wordList.add(round_0[3]);
        wordList.add(round_0[4]);
        wordList.add(round_0[5]);
        wordList.add(round_0[6]);
        wordList.add(round_0[7]);

        Word[] round_1 = new Word[8];
        Word r1 = Word.g(1, round_0[7]);
        round_1[0] = Word.XOR(round_0[0], r1);
        round_1[1] = Word.XOR(round_1[0], round_0[1]);
        round_1[2] = Word.XOR(round_1[1], round_0[2]);
        round_1[3] = Word.XOR(round_1[2], round_0[3]);
        round_1[4] = Word.XOR(Word.h(round_1[3]), round_0[4]);
        round_1[5] = Word.XOR(round_1[4], round_0[5]);
        round_1[6] = Word.XOR(round_1[5], round_0[6]);
        round_1[7] = Word.XOR(round_1[6], round_0[7]);
        wordList.add(round_1[0]);
        wordList.add(round_1[1]);
        wordList.add(round_1[2]);
        wordList.add(round_1[3]);
        wordList.add(round_1[4]);
        wordList.add(round_1[5]);
        wordList.add(round_1[7]);
        wordList.add(round_1[6]);

        Word[] round_2 = new Word[8];
        Word r2 = Word.g(2, round_1[7]);
        round_2[0] = Word.XOR(round_1[0], r2);
        round_2[1] = Word.XOR(round_2[0], round_1[1]);
        round_2[2] = Word.XOR(round_2[1], round_1[2]);
        round_2[3] = Word.XOR(round_2[2], round_1[3]);
        round_2[4] = Word.XOR(Word.h(round_2[3]), round_1[4]);
        round_2[5] = Word.XOR(round_2[4], round_1[5]);
        round_2[6] = Word.XOR(round_2[5], round_1[6]);
        round_2[7] = Word.XOR(round_2[6], round_1[7]);
        wordList.add(round_2[0]);
        wordList.add(round_2[1]);
        wordList.add(round_2[2]);
        wordList.add(round_2[3]);
        wordList.add(round_2[4]);
        wordList.add(round_2[5]);
        wordList.add(round_2[6]);
        wordList.add(round_2[7]);

        Word[] round_3 = new Word[8];
        Word r3 = Word.g(3, round_2[7]);
        round_3[0] = Word.XOR(round_2[0], r3);
        round_3[1] = Word.XOR(round_3[0], round_2[1]);
        round_3[2] = Word.XOR(round_3[1], round_2[2]);
        round_3[3] = Word.XOR(round_3[2], round_2[3]);
        round_3[4] = Word.XOR(Word.h(round_3[3]), round_2[4]);
        round_3[5] = Word.XOR(round_3[4], round_2[5]);
        round_3[6] = Word.XOR(round_3[5], round_2[6]);
        round_3[7] = Word.XOR(round_3[6], round_2[7]);
        wordList.add(round_3[0]);
        wordList.add(round_3[1]);
        wordList.add(round_3[2]);
        wordList.add(round_3[3]);
        wordList.add(round_3[4]);
        wordList.add(round_3[5]);
        wordList.add(round_3[6]);
        wordList.add(round_3[7]);

        Word[] round_4 = new Word[8];
        Word r4 = Word.g(4, round_3[7]);
        round_4[0] = Word.XOR(round_3[0], r4);
        round_4[1] = Word.XOR(round_4[0], round_3[1]);
        round_4[2] = Word.XOR(round_4[1], round_3[2]);
        round_4[3] = Word.XOR(round_4[2], round_3[3]);
        round_4[4] = Word.XOR(Word.h(round_4[3]), round_3[4]);
        round_4[5] = Word.XOR(round_4[4], round_3[5]);
        round_4[6] = Word.XOR(round_4[5], round_3[6]);
        round_4[7] = Word.XOR(round_4[6], round_3[7]);
        wordList.add(round_4[0]);
        wordList.add(round_4[1]);
        wordList.add(round_4[2]);
        wordList.add(round_4[3]);
        wordList.add(round_4[4]);
        wordList.add(round_4[5]);
        wordList.add(round_4[6]);
        wordList.add(round_4[7]);

        Word[] round_5 = new Word[8];
        Word r5 = Word.g(5, round_4[7]);
        round_5[0] = Word.XOR(round_4[0], r5);
        round_5[1] = Word.XOR(round_5[0], round_4[1]);
        round_5[2] = Word.XOR(round_5[1], round_4[2]);
        round_5[3] = Word.XOR(round_5[2], round_4[3]);
        round_5[4] = Word.XOR(Word.h(round_5[3]), round_4[4]);
        round_5[5] = Word.XOR(round_5[4], round_4[5]);
        round_5[6] = Word.XOR(round_5[5], round_4[6]);
        round_5[7] = Word.XOR(round_5[6], round_4[7]);
        wordList.add(round_5[0]);
        wordList.add(round_5[1]);
        wordList.add(round_5[2]);
        wordList.add(round_5[3]);
        wordList.add(round_5[4]);
        wordList.add(round_5[5]);
        wordList.add(round_5[6]);
        wordList.add(round_5[7]);

        Word[] round_6 = new Word[8];
        Word r6 = Word.g(6, round_5[7]);
        round_6[0] = Word.XOR(round_5[0], r6);
        round_6[1] = Word.XOR(round_6[0], round_5[1]);
        round_6[2] = Word.XOR(round_6[1], round_5[2]);
        round_6[3] = Word.XOR(round_6[2], round_5[3]);
        round_6[4] = Word.XOR(Word.h(round_6[3]), round_5[4]);
        round_6[5] = Word.XOR(round_6[4], round_5[5]);
        round_6[6] = Word.XOR(round_6[5], round_5[6]);
        round_6[7] = Word.XOR(round_6[6], round_5[7]);
        wordList.add(round_6[0]);
        wordList.add(round_6[1]);
        wordList.add(round_6[2]);
        wordList.add(round_6[3]);
        wordList.add(round_6[4]);
        wordList.add(round_6[5]);
        wordList.add(round_6[6]);
        wordList.add(round_6[7]);

        Word[] round_7 = new Word[4];
        Word r7 = Word.g(7, round_6[3]);
        round_7[0] = Word.XOR(round_6[0], r7);
        round_7[1] = Word.XOR(round_7[0], round_6[1]);
        round_7[2] = Word.XOR(round_7[1], round_6[2]);
        round_7[3] = Word.XOR(round_7[2], round_6[3]);
        wordList.add(round_7[0]);
        wordList.add(round_7[1]);
        wordList.add(round_7[2]);
        wordList.add(round_7[3]);



    }
}
