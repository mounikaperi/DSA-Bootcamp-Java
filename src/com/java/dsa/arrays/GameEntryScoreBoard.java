package com.java.dsa.arrays;
public class GameEntryScoreBoard {
    public static void main(String[] args) {
      GameEntry gameEntry1 = new GameEntry("John", 89);
      GameEntry gameEntry2 = new GameEntry("Rahul", 90);
      GameEntry gameEntry3 = new GameEntry("Rohan", 81);
      GameEntry gameEntry4 = new GameEntry("Arun", 69);
      GameEntry gameEntry5 = new GameEntry("Vicky", 72);
      ScoreBoard sb = new ScoreBoard(10);
      sb.addScore(gameEntry1);
      sb.addScore(gameEntry2);
      sb.addScore(gameEntry3);
      sb.addScore(gameEntry4);
      sb.addScore(gameEntry5);
      sb.remove(0);
      sb.printGameEntries();
    }
}
class GameEntry {
  private String name;
  private int score;
  public GameEntry(String name, int score) {
    this.name = name;
    this.score = score;
  }
  public String getName() {
    return name;
  }
  public int getScore() {
    return score;
  }
  public String toString() {
    return "(" + name + ", " + score + ")";
  }
}
class ScoreBoard {
  private int numEntries = 0;
  private GameEntry[] board;
  public ScoreBoard(int capacity) {
    board = new GameEntry[capacity];
  }
  public void addScore(GameEntry gameEntry) {
    int newScore = gameEntry.getScore();
    if (numEntries < board.length || newScore > board[numEntries-1].getScore()) {
      // a new score can only be entered if it is strictly higher than the previous score
      if (numEntries < board.length) numEntries++;
      int j=numEntries-1;
      while (j>0 && board[j-1].getScore() < newScore) {
        board[j] = board[j-1];
        j--;
      }
      board[j] = gameEntry;
    }
  }
  public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= numEntries) {
      throw new IndexOutOfBoundsException("Invalid  index: " + i);
    }
    GameEntry temp = board[i];
    for (int j=i; j<numEntries-1; j++) { 
      // use numEntries instead of board.length because there is no use in moving the null entries that may be at the end of the array
      board[j] = board[j+1];
    }
    board[numEntries-1] = null;
    numEntries--;
    return temp;
  }
  public void printGameEntries() {
    for (int i=0; i<numEntries; i++) {
      System.out.println("Name: " + board[i].getName() + " and score is: " + board[i].getScore());
    }
  }
}