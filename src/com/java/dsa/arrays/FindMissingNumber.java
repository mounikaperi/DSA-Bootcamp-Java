public class FindMissingNumber {
	public static void main(String[] args) {
		// https://leetcode.com/problems/missing-number/description/
		int[] arr = {1, 2, 4, 5};
		int n = 5;
		System.out.println("Missing number via brute force approach: " + findMissingNumberViaBruteForce(arr));
		System.out.println("Missing number via hashing approach: " + findMissingNumberViaHashing(arr, n));
		System.out.println("Missing number via summation approach: " + findMissingNumberViaSummation(arr, n));
		System.out.println("Missing number via summation approach: " + findMissingNumberViaXor(arr, n));
		System.out.println("Missing number via summation approach: " + findMissingNumberViaCycleSort(arr));
	}
	private static int findMissingNumberViaBruteForce(int[] arr) {
	    for (int i=1; i<=arr.length; i++) {
	        int flag = 0;
	        for (int j=0; j<arr.length-1; j++) {
	            if (arr[j] == i) {
	                flag = 1;
	                break;
	            }
	        }
	        if (flag == 0) return i;
	    }
	    return -1;
	}
	private static int findMissingNumberViaHashing(int[] arr, int n) {
	    int[] hash = new int[n+1];
	    for (int i=0; i<n-1; i++) {
	        hash[arr[i]]++;
	    }
	    for (int i=1; i<=n; i++) {
	        if (hash[i] == 0) return i;
	    }
	    return -1;
	}
	private static int findMissingNumberViaSummation(int[] arr, int n) {
	    int expectedSum = (n*(n+1))/2;
	    int calculatedSum = 0;
	    for (int i=0; i<n-1; i++) {
	        calculatedSum += arr[i];
	    }
	    return expectedSum - calculatedSum;
	}
	private static int findMissingNumberViaXor(int[] arr, int n) {
	    int arrayXor = 0;
	    int numbersXor = 0;
	    for (int i=0; i<n-1; i++) {
	        arrayXor = arrayXor ^ arr[i];
	        numbersXor = numbersXor ^ (i+1);
	    }
	    numbersXor = numbersXor ^ n;
	    return (numbersXor ^ arrayXor);
	}
	private static int findMissingNumberViaCycleSort(int[] arr) {
	    int i=0;
	    while (i<arr.length) {
	        int correctIndex = arr[i]-1;
	        if (arr[i] < arr.length && arr[i] != arr[correctIndex]) swap(arr, i, correctIndex);
	        else i++;
	    }
	    for (i=0; i<arr.length; i++) {
	        if (arr[i] != (i+1)) return (i+1);
	    }
	    return arr.length;
	}
	private static void swap(int[] arr, int start, int end) {
	    int temp = arr[start];
	    arr[start] = arr[end];
	    arr[end] = temp;
	}
}
