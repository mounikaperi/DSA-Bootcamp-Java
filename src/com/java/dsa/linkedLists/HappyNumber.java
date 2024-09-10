// leetcode 202
public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        boolean isHappyNumber = isNumberHappy(n);
        System.out.println("Is number happy? " + isHappyNumber);
    }
    private static boolean isNumberHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow); // move by one step
            fast = findSquare(findSquare(fast)); // move by two steps
        } while ( fast != slow) // if slow == fast then there is a loop and it will never reach to 1
        if (slow == 1) return true;
        return false;
    }
    private static int findSquare(int num) {
        int ans = 0;
        while ( num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num / 10;
        }
        return ans;
    }
}