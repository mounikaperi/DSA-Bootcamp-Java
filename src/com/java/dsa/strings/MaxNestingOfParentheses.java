class MaxNestingOfParentheses {
    private static int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                currentDepth++;
                maxDepth = Math.max(currentDepth, maxDepth);
            } else if (ch == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }
    public static void main(String[] args) {
      String s = "(1+(2*3)+((8)/4))+1";
      int result = maxDepth(s);
      System.out.println("The maximum nested parentheses is: " + result);
    }
}
