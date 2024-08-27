public class LargestSmallestElementsInArray {
	public static void main(String[] args) {
	    int[] arr = {100, 90, 80, 10, 20, 50, 70, 60, 30, 40};
	    int largestElement = getLargestElement(arr);
	    System.out.println("The largest element in array is: " + largestElement);
	    int smallestElement = getSmallestElement(arr);
	    System.out.println("The smallest element in array is: " + smallestElement);
	    int secondLargestElement = getSecondLargestElement(arr);
	    System.out.println("The second largest element in array is: " + secondLargestElement);
	    int secondSmallestElement = getSecondSmallestElement(arr);
	    System.out.println("The second smallest element in array is: " + secondSmallestElement);
	}
	private static int getLargestElement(int[] arr) {
	    int largestElement = arr[0];
	    for (int i=1; i<arr.length; i++) {
	        if (arr[i] > largestElement)
	            largestElement = arr[i];
	    }
	    return largestElement;
	}
	private static int getSmallestElement(int[] arr) {
	    int smallestElement = arr[0];
	    for (int i=1; i<arr.length; i++) {
	        if (arr[i] < smallestElement) {
	            smallestElement = arr[i];
	        }
	    }
	    return smallestElement;
	}
	private static int getSecondLargestElement(int[] arr) {
	    int largestElement = Integer.MIN_VALUE;
	    int secondLargestElement = Integer.MIN_VALUE;
	    for (int i=0; i<arr.length; i++) {
	        if (arr[i] > largestElement) {
	            secondLargestElement = largestElement;
	            largestElement = arr[i];
	        } else if (arr[i] > secondLargestElement && arr[i] != largestElement) {
	            secondLargestElement = arr[i];
	        }
	    }
	    return secondLargestElement;
	}
	private static int getSecondSmallestElement(int[] arr) {
	    int smallestElement = Integer.MAX_VALUE;
	    int secondSmallestElement = Integer.MAX_VALUE;
	    for (int i=0; i<arr.length; i++) {
	        if (arr[i] < smallestElement) {
	            secondSmallestElement = smallestElement;
	            smallestElement = arr[i];
	        } else if (arr[i] < secondSmallestElement && arr[i] != smallestElement) {
	            secondSmallestElement = arr[i];
	        }
	    }
	    return secondSmallestElement;
	}
}
