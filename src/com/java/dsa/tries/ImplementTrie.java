public class ImplementTrie {
  Trie trie = new Trie();
  trie.insert("apple");
  trie.insert("app");
  System.out.println("Inserting strings 'apple', 'app' into Trie");
  System.out.print("Count Words Equal to 'apple': ");
  System.out.println(trie.countWordsEqualTo("apple"));
  System.out.print("Count Words Starting With 'app': ");
  System.out.println(trie.countWordsStartingWith("app"));
  System.out.println("Erasing word 'app' from trie");
  trie.erase("app");
  System.out.print("Count Words Equal to 'apple': ");
  System.out.println(trie.countWordsEqualTo("apple"));
  System.out.print("Count Words Starting With 'apple': ");
  System.out.println(trie.countWordsStartingWith("app"));
}
class Trie {
  static class Node {
    Node[] links;
    int countEndWith;
    int countPrefix;
    boolean flag = false;
    Node() {
      links = new Node[26];
      countEndWith = 0;
      countPrefix = 0;
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
    void increaseEnd() {
      countEndWith++;
    }
    void increasePrefix() {
      countPrefix++;
    }
    void deleteEnd() {
      countEndWith--;
    }
    void reducePrefix() {
      countPrefix--;
    }
    void setEnd() {
      flag = true;
    }
    boolean isEnd() {
      return flag;
    }
  }
  private Node root;
  Trie() {
    root = new Node();
  }
  void insert(String word) {
    Node root = node;
    for (int i=0; i<word.length(); i++) {
      if (!node.containsKey(word.charAt(i))) {
        node.put(word.charAt(i), new Node());
      }
      node = node.get(word.charAt(i));
      node.increasePrefix();
    }
    node.increaseEnd();
    node.setEnd();
  }
  boolean search(String word) {
    Node node = root;
    for (int i=0; i<word.length(); i++) {
      if (!node.containsKey(word.charAt(i))) {
        return false;
      }
      node = node.get(word.charAt(i));
    }
    return node.isEnd();
  }
  boolean startsWith(String prefix) {
    Node node = root;
    for (int i=0; i<prefix.length(); i++) {
      if (!node.containsKey(word.charAt(i))) {
        return false;
      }
      node = node.get(prefix.charAt(i));
    }
    return true;
  }
  
  int countWordsEqualTo(String word) {
    Node node = root;
    for (int i=0; i<word.length(); i++) {
      if (node.containsKey(word.charAt(i))) {
        node = node.get(word.charAt(i));
      } else {
        return 0;
      }
    }
    return node.countEndsWith;
  }
  int countWordsStartingWith(String word) {
    Node node = root;
    for (int i=0; i<word.length(); i++) {
      if (node.containsKey(word.charAt(i))) {
        node = node.get(word.charAt(i));
      } else {
        return 0;
      }
    }
    return node.countPrefix;
  }
  void erase(String word) {
    Node node = root;
    for (int i=0; i<word.length(); i++) {
      if (node.containsKey(word.charAt(i))) {
        node = node.get(word.charAt(i));
        node.reducePrefix();
      } else {
        return;
      }
    }
    node.deleteEnd();
  }
}
