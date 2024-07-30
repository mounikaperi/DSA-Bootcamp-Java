// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class FindFirstLastPositionOfElement {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,8,10};
        int target = 8;
        int[] positions = searchRange(arr, target);
        System.out.println("Fist and last position of the target element " +target+ " is " + positions[0] + " and " + positions[1]);
    }
    static int[] searchRange(int[] arr, int target) {
        int ans[] = {-1, -1};
        int firstOccurrence = search(arr, target, true);
        if (firstOccurrence == -1) return ans;
        int lastOccurrence = search(arr, target, faalse);
        ans[0] = firstOccurrence; ans[1] = lastOccurrence;
        return ans;
    }
    static int search(int[] arr, int target, boolean findStartIndex) {
        int low =0, high = arr.length-1, ans = -1;
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                if (findStartIndex) high = mid - 1;
                else low = mid + 1;
            } else if (arr[mid] > target)  high = mid - 1;
            else low = mid + 1;
        }
        return ans;
    }
    
}
