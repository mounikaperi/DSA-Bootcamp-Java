// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'g'};
        char target = 'a';
        System.out.println("Smallest letter that is greater than target " +target+ " is " + findLetter(arr, target));
    }
    static char findLetter(char[] arr, char target) {
        int low = 0; int high = arr.length-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (target > arr[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return  arr[low % arr.length];
    }
}
