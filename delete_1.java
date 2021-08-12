import java.util.Scanner;
// 48 -> 0 to 57 -> 9
public class delete_1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("\n\n\t\t----PlayFairCipherProgram----\n");
    System.out.print("Enter keyword: ");
    String key = in .nextLine();
    System.out.print("Enter message to encrypt: ");
    String msg = in .nextLine();

    PFE PFE = new PFE();
    PFE.makeArray(key);
    msg = PFE.manageMessage(msg);
    PFE.doPlayFair(msg, "Encrypt");
    String en = PFE.getEncrypted();
    System.out.println("Encrypting....\n\nThe encrypted text is: " + en);
    System.out.println("=======================================");
    PFE.doPlayFair(en, "Decrypt");
    System.out.print("\nDecrypting....\n\nThe encrypted text is: " + PFE.getDecrypted());
  }
}

class PFE {

  private char[][] alphabets = new char[6][6];
  private char[] uniqueChar = new char[36];
  private String ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private String encrypted = "";
  private String decrypted = "";

  void makeArray(String keyword) {
    keyword = keyword.toUpperCase();
    boolean present, terminate = false;
    int val = 0;
    int uniqueLen;
    for (int i = 0; i<keyword.length(); i++) {
      present = false;
      uniqueLen = 0;
      if (keyword.charAt(i) != ' ') {
        for (int k = 0; k<uniqueChar.length; k++) {
          if (Character.toString(uniqueChar[k]) == null) {
            break;
          }
          uniqueLen++;
        }
        for (int j = 0; j<uniqueChar.length; j++) {
          if (keyword.charAt(i) == uniqueChar[j]) {
            present = true;
          }
        }
        if (!present) {
          uniqueChar[val] = keyword.charAt(i);
          val++;
        }
      }
      ch = ch.replaceAll(Character.toString(keyword.charAt(i)), "");
    }

    for (int i = 0; i<ch.length(); i++) {
      uniqueChar[val] = ch.charAt(i);
      val++;
    }
    val = 0;

    for (int i = 0; i<6; i++) {
      for (int j = 0; j<6; j++) {
        alphabets[i][j] = uniqueChar[val];
        val++;
        System.out.print(alphabets[i][j] + "\t");
      }
      System.out.println();
    }
  }

  String manageMessage(String msg) {
    int val = 0;
    int len = msg.length() - 2;
    String newTxt = "";
    String intermediate = "";
    while (len >= 0) {
      intermediate = msg.substring(val, val + 2);
      if (intermediate.charAt(0) == intermediate.charAt(1)) {
        newTxt = intermediate.charAt(0) + "X" + intermediate.charAt(1);
        msg = msg.replaceFirst(intermediate, newTxt);
        len++;
      }
      len -= 2;
      val += 2;
    }

    if (msg.length() % 2 != 0) {
      msg = msg + 'Z';
    }
    return msg.toUpperCase().replaceAll(" ", "");
  }

  void doPlayFair(String msg, String tag) {
    int val = 0;
    while (val<msg.length()) {
      searchAndEncryptOrDecrypt(msg.substring(val, val + 2), tag);
      val += 2;
    }
  }

  void searchAndEncryptOrDecrypt(String doubblyCh, String tag) {
    char ch1 = doubblyCh.charAt(0);
    char ch2 = doubblyCh.charAt(1);
    int row1 = 0, col1 = 0, row2 = 0, col2 = 0;
    for (int i = 0; i<6; i++) {
      for (int j = 0; j<6; j++) {
        if (alphabets[i][j] == ch1) {
          row1 = i;
          col1 = j;
        } else if (alphabets[i][j] == ch2) {
          row2 = i;
          col2 = j;
        }
      }
    }
    if (tag == "Encrypt")
      encrypt(row1, col1, row2, col2);
    else if (tag == "Decrypt")
      decrypt(row1, col1, row2, col2);
  }

  void encrypt(int row1, int col1, int row2, int col2) {
    if (row1 == row2) {
      col1 = col1 + 1;
      col2 = col2 + 1;
      if (col1 > 5)
        col1 = 0;
      if (col2 > 5)
        col2 = 0;
      encrypted += (Character.toString(alphabets[row1][col1]) + Character.toString(alphabets[row1][col2]));
    } else if (col1 == col2) {
      row1 = row1 + 1;
      row2 = row2 + 1;
      if (row1 > 5)
        row1 = 0;
      if (row2 > 5)
        row2 = 0;
      encrypted += (Character.toString(alphabets[row1][col1]) + Character.toString(alphabets[row2][col1]));
    } else {
      encrypted += (Character.toString(alphabets[row1][col2]) + Character.toString(alphabets[row2][col1]));
    }
  }

  void decrypt(int row1, int col1, int row2, int col2) {
    if (row1 == row2) {
      col1 = col1 - 1;
      col2 = col2 - 1;
      if (col1<0)
        col1 = 5;
      if (col2<0)
        col2 = 5;
      decrypted += (Character.toString(alphabets[row1][col1]) + Character.toString(alphabets[row1][col2]));
    } else if (col1 == col2) {
      row1 = row1 - 1;
      row2 = row2 - 1;
      if (row1<0)
        row1 = 5;
      if (row2<0)
        row2 = 5;
      decrypted += (Character.toString(alphabets[row1][col1]) + Character.toString(alphabets[row2][col1]));
    } else {
      decrypted += (Character.toString(alphabets[row1][col2]) + Character.toString(alphabets[row2][col1]));
    }
  }

  String getEncrypted() {
    return encrypted;
  }

  String getDecrypted() {
    return decrypted;
  }

}