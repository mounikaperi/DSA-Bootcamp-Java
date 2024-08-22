import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class AllocateBooks {
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
		int n = 4;
		int m = 2;
		int minNoOfPages = findPages(arrList, n, m);
		System.out.println("The minNoOfPages is: "+ minNoOfPages);
	}
	private static int findPages(ArrayList<Integer> arrList, int n, int m) {
	    if (m > n) return -1;
	    int low = Collections.max(arrList);
	    int high = arrList.stream().mapToInt(Integer::intValue).sum();
	    while (low <= high) {
	        int mid = low + (high - low) / 2;
	        int students = countStudents(arrList, mid);
	        if (students > m) low = mid + 1;
	        else high = mid - 1;
	    }
	    return low;
	}
	private static int countStudents(ArrayList<Integer> arrList, int pages) {
	    int students = 1;
	    long pagesPerStudent = 0;
	    for (int i=0; i<arrList.size(); i++) {
	        if (pagesPerStudent + arrList.get(i) <= pages) {
	            pagesPerStudent += arrList.get(i);
	        } else {
	            students++;
	            pagesPerStudent = arrList.get(i);
	        }
	    }
	    return students;
	}
}
