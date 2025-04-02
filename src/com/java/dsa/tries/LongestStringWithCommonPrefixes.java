import java.util.* ;
import java.io.*; 

class Node {
  Node[] links;
  boolean flag;
  public Node() {
    links = new Node[26];
    flag = false;
  }
  boolean containsKey(char ch) {
    return links[ch-'a'] != null;
  }
  Node get(char ch) {
    return links[ch-'a'];
  }
  void put(char ch, Node node) {
    links[ch-'a'] = node;
  }
  void setEnd() {
    flag = true;
  }
  boolean isEnd() {
    return flag;
  }
} 
class Trie {
  private Node root;
  Trie() {
    root = new Node();
  }
  public void insert(String word) {
    Node node = root;
    for (int i=0;i<word.length(); i++) {
      if (!node.containsKey(word.charAt(i))) {
        node.put(word.charAt(i), new Node());
      }
      node = node.get(word.charAt(i));
    }
    node.setEnd();
  }
  boolean checkIfPrefixExists(String word) {
    Node node = root;
    boolean flag = true;
    for (int i=0; i<word.length(); i++) {
      if (node.containsKey(word.charAt(i))) {
        node = node.get(word.charAt(i));
        flag = flag & node.isEnd();
      } else {
        return false;
      }
    }
    return flag;
  }
}
class LongestStringWithCommonPrefixes {  
  public static String completeString(int n, String[] a) {
    Trie obj = new Trie();
    for (int i=0; i<n; i++) {
      obj.insert(a[i]);
    }
    String longest = "";
    for (int i=0; i<n; i++) {
      if (obj.checkIfPrefixExists(a[i])) {
        if (a[i].length() > longest.length()) {
          longest = a[i];
        }
        else if (a[i].length() == longest.length() && a[i].compareTo(longest) < 0) {
          longest = a[i];
        }
      }
    }
    if (longest == "") return "None";
    return longest;
  }
}
