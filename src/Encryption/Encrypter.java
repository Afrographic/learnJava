package Encryption;

import java.util.Arrays;

public class Encrypter {
    // Key - Shift every two character to encrypt the message
    static char[] alphabets = { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    public static void main(String[] args) {
        String encoded = encode(
                "i will be kind next time with your children kindly forgive me for my mistakes father");
        System.out.println("----- Encrypted message -----");
        System.out.println(encoded);
        System.out.println("----- Decrypted message -----");
        System.out.println(decode(encoded));
    }

    public static String encode(String str) {
        str = str.toUpperCase();
        char[] msg = str.toCharArray();
        char[] msgEncoded = str.toCharArray();
        for (int i = 0; i <= msg.length - 1; i++) {
            int index = Arrays.binarySearch(alphabets, msg[i]);
            if (index == 25) {
                msgEncoded[i] = ' ';
                continue;
            }
            if (index == 26) {
                msgEncoded[i] = 'A';
                continue;
            }
            msgEncoded[i] = alphabets[index + 2];
        }

        return new String(msgEncoded);
    }

    public static String decode(String str) {
        str = str.toUpperCase();
        char[] msg = str.toCharArray();
        char[] msgDecoded = str.toCharArray();
        for (int i = 0; i <= msg.length - 1; i++) {
            int index = Arrays.binarySearch(alphabets, msg[i]);
            if (index == 0) {
                msgDecoded[i] = 'Y';
                continue;
            }
            if (index == 1) {
                msgDecoded[i] = 'Z';
                continue;
            }
            msgDecoded[i] = alphabets[index - 2];
        }

        return new String(msgDecoded);
    }
}
