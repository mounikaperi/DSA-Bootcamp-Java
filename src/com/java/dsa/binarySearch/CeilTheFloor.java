public class CeilTheFloor {
	public static void main(String[] args) {
    // https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401
		int[] arr = {3, 4, 7, 8, 8, 10};
        int target = 5;
        int floor = findFloor(arr, target);
        int ceil = findCeil(arr, target);
        System.out.println("The floor of the element " +target+ " is " + floor);
        System.out.println("The ceil of the element " +target+ " is " + ceil);
	}
    private static int findFloor(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int ans = arr[arr.length-1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    private static int findCeil(int[] arr, int target) {
        int low = 0; int high = arr.length-1;
        int ans = arr[arr.length-1];
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
