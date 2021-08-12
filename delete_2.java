import java.util.*;
public class delete_2 {
    public static final char START_LOWER_CASE_ALPHABET = 'a'; // ASCII-97
    public static final char END_LOWER_CASE_ALPHABET = 'z'; // ASCII-122
    public static final char START_UPPER_CASE_ALPHABET = 'A'; // ASCII-65
    public static final char END_UPPER_CASE_ALPHABET = 'Z'; // ASCII-90
    public static final int ALPHABET_SIZE = 'Z' - 'A' + 1; // 26 of course
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----CaesarCipherProgram----");
        int choise;
        do {
            System.out.println("\n 1) PlainText to CipherText \n 2) CipherText to PlainText \n 3) Exit ");
            System.out.print("Enter Your Choise : ");
            choise = sc.nextInt();
            switch (choise) {
                case 1:
                    textUser();
                    break;
                case 2:
                    encrypt();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choise.");
            }
        } while (choise != 0);
    }
    public static void textUser(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter PlainText : ");
        String plainText = sc.nextLine();
        System.out.println("Enter Shift Number : ");
        int shift = sc.nextInt();
        // int shift = 23;
        // String plainText = "The quick brown fox jumps over the lazy dog";
        System.out.println("Plaintext  : " + plainText);
        String ciphertext = caesarCipherEncrypt(plainText, shift);
        System.out.println("Ciphertext : " + ciphertext);

        String decrypted = caesarCipherDecrypt(ciphertext, shift);
        System.out.println("Decrypted  : " + decrypted);
        System.out.println("Successful decryption: " + decrypted.equals(plainText));
    }
    public static void encrypt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CipherText : ");
        String cipherText = sc.nextLine();
        cipherText = cipherText.toLowerCase();
        char cchar[] = new char[cipherText.length()];
        for(int i = 0; i < cchar.length; i++){
            cchar[i] = cipherText.charAt(i);
        }
        int count = 0;
        char cipher[] = new char[255];
        System.out.println("\n\n---Decrypted CipherText---");
        for (int key = 1; key <= 26; key++) {
            for (int i = 0; i < cchar.length; i++) {
                if ((cchar[i] >= START_LOWER_CASE_ALPHABET) && (cchar[i] <= END_LOWER_CASE_ALPHABET)) {
                    cipher[i] = (char) (cchar[i] - key);
                    if(cipher[i] < START_LOWER_CASE_ALPHABET){
                        cipher[i] = (char) (cipher[i] + 26);
                    }
                } 
            }
            count++;
            System.out.print("\nDycript Text : " + count + " -> "+ String.valueOf(cipher));
        }
    }
    public static String caesarCipherEncrypt(String plaintext, int shift) {
        return caesarCipher(plaintext, shift, true);
    }
    public static String caesarCipherDecrypt(String ciphertext, int shift) {
        return caesarCipher(ciphertext, shift, false);
    }
    private static String caesarCipher(String input, int shift, boolean encrypt) {
        StringBuilder output = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            int calculatedShift = (encrypt) ? shift : (ALPHABET_SIZE - shift);
            char startOfAlphabet;
            if ((inputChar >= START_LOWER_CASE_ALPHABET) && (inputChar <= END_LOWER_CASE_ALPHABET)) {
                startOfAlphabet = START_LOWER_CASE_ALPHABET;
            } else if ((inputChar >= START_UPPER_CASE_ALPHABET) && (inputChar <= END_UPPER_CASE_ALPHABET)) {
                startOfAlphabet = START_UPPER_CASE_ALPHABET;
            } else {
                output.append(inputChar);
                continue;
            }
            int inputCharIndex = inputChar - startOfAlphabet;
            int outputCharIndex = (inputCharIndex + calculatedShift) % ALPHABET_SIZE;
            char outputChar = (char) (outputCharIndex + startOfAlphabet);
            output.append(outputChar);
        }
        return output.toString();
    }
}