import java.util.*;

public class EncryptDecryptMessages {
    public static void main(String[] args) {
      Cipher cipher = new Cipher(3);
      System.out.println("Encryption code: " + new String(cipher.encoder));
      System.out.println("Decryption code: " + new String(cipher.decoder));
      String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
      String encodedMessage = cipher.encrypt(message);
      System.out.println("The encoded message is: " + encodedMessage);
      String decodedMessage = cipher.decrypt(encodedMessage);
      System.out.println("The decoded message is: " + decodedMessage);
      /**
       * Output:
       *  Encryption code: DEFGHIJKLMNOPQRSTUVWXYZABC
          Decryption code: XYZABCDEFGHIJKLMNOPQRSTUVW
          The encoded message is: WKH HDJOH LV LQ SODB; PHHW DW MRH'V.
          The decoded message is: THE EAGLE IS IN PLAY; MEET AT JOE'S.
       */
    }
}
class Cipher {
  protected char[] encoder = new char[26];
  protected char[] decoder = new char[26];
  public Cipher(int rotation) {
    for (int i=0; i<26; i++) {
      encoder[i] = (char) ('A' + (i + rotation) % 26);
      decoder[i] = (char) ('A' + (i - rotation + 26) % 26);
    }
  }
  public String encrypt(String message) {
    return transform(message, encoder);
  }
  public String decrypt(String secret) {
    return transform(secret, decoder);
  }
  private String transform(String original, char[] code) {
    char[] msg = original.toCharArray();
    for (int i=0; i<msg.length; i++) {
      if (Character.isUpperCase(msg[i])) {
        int j = msg[i] - 'A'; // We will have a letter to change will be value form 0 to 25 replace the character
        msg[i] = code[j];
      }
    }
    return new String(msg);
  }
}