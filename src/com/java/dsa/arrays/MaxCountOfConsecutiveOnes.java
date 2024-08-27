public class MaxCountOfConsecutiveOnes {
	public static void main(String[] args) {
	    int[] arr = {1, 1, 0, 1, 1, 1};
	    System.out.println("Count of maximum consecutive ones: " + maxCountOfConsecutiveOnes(arr));
	}
	private static int maxCountOfConsecutiveOnes(int[] arr) {
	        int n = arr.length;
	        int max = 0;
	        int current = 0; 
	        for (int i = 0; i < n; i++) {
	            if (arr[i] == 1) {
	                current++;
	            } else {
	                max = Math.max(max, current);
	                current = 0;
	            }
	        }
	        max = Math.max(max, current);
	        return max;
	}
}
