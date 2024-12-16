import java.util.*;

public class CountInversions {
  public static void main(String[] args) {
    int[] a = {5, 4, 3, 2, 1};
    int n = 5;
    int cnt = numberOfInversions(a, n);
    cnt = numberOfInversionsOptimal(a, 0, n-1);
    System.out.println("The number of inversions is: " + cnt);
  }
  private static int numberOfInversions(int[] a, int n) {
    // Count the number of pairs:
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (a[i] > a[j]) cnt++;
      }
    }
    return cnt;
  }
  private static int numberOfInversionsOptimal(int[] a, int low, int high) {
    int count = 0;
    if (low >= high) return count;
    int mid = (low + high) / 2;
    count += numberOfInversionsOptimal(a, low, mid);
    count += numberOfInversionsOptimal(a, mid+1, high);
    count += merge(a, low, mid, high);
    return count;
  }
  private static int merge(int[] arr, int low, int mid, int high) {
    ArrayList<Integer> temp = new ArrayList<>();
    int left = low;
    int right = mid + 1;
    int count = 0;
    while (left <= mid && right <= high) {
      if (arr[left] <= arr[right]) {
        temp.add(arr[left]);
        left++;
      } else {
        count += (mid - left + 1);
        temp.add(arr[right]);
        right++;
      }
    }
    while (left <= mid) {
      temp.add(arr[left]);
      left++;
    }
    while (right <= high) {
      temp.add(arr[right]);
      right++;
    }
    for (int i = low; i <= high; i++) {
      arr[i] = temp.get(i - low);
    }
    return count; 
  }
}
