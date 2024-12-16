import java.util.*;

public class KnuthMorrisPruttAlgo {
  public static void main(String[] args) {
    // https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/article/MTE5MDI%3D
    String text = "aabaacaadaabaaba"; 
    String pattern = "aaba"; 
    ArrayList<Integer> result = search(pattern, text);
    for (int i = 0; i < result.size(); i++) 
      System.out.print(result.get(i) + " ");
  }
  private static ArrayList<Integer> search(String pattern, String text) {
    ArrayList<Integer> result = new ArrayList<>();
    int[] lps = new int[pattern.length()];
    calculateLps(pattern, lps);
    int textPointer = 0, patternPointer = 0, textLength = text.length(), patternLength = pattern.length();
    while(textPointer < textLength) {
      // Step1: If characters match move both pointers forward
      if (text.charAt(textPointer) == pattern.charAt(patternPointer)) {
        textPointer++;
        patternPointer++;
        // Step2: If the entire pattern is matched, store the index in result
        if (patternPointer == patternLength) {
          result.add(textPointer - patternPointer);
          patternPointer = lps[patternPointer - 1]; // use LPS of previous index to skip unncessary comparisions
        }
      } else {
        // Step3: If there is a mismatch- use lps value of previousIndex to avoid redundant comparisions
        if (patternPointer != 0)
          patternPointer = lps[patternPointer - 1];
        else
          textPointer++;
      }
    }
    return result;
  }
  private static void calculateLps(String pattern, int[] lps) {
    int patternLength = pattern.length();
    // Step1: Intitialize lengthPointer to 0 and create lps[] array of the same length as patternLength
    // Place a pointer i at the start of the pattern for traversal
    int lengthPointer = 0;
    int i=1;
    lps[0] = 0;
    while ( i< patternLength) {
      if (pattern.charAt(i) == pattern.charAt(lengthPointer)) {
        // if pattern[lengthPointer] and pattern[i] match, increment lengthPointer and store it in lps[i], move i to next index
        lengthPointer++;
        lps[i] = lengthPointer;
        i++;
      } else {
        if (lengthPointer != 0) {
          // Since pattern[lengthPointer] and pattern[i] donot match set lengthPointer to lps[lengthPointer-1] -> Eg:lps[2] = 1;
          lengthPointer = lps[lengthPointer-1];
        } else {
          // if pattern[lengthPointer] and pattern[i] donot match and lengthPointer is 0, so lps[i] will be zer0, Move i to next index
          lps[i] = 0;
          i++;
        }
      }
    }
  }
}
