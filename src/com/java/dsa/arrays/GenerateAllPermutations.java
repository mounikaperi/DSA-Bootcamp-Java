public class GenerateAllPermutations {
    static void nextPermutation(int[] arr) {
        List<int[]> res = new ArrayList<>();
        permutations(res, arr, 0);
        Collections.sort(res, Arrays::compare);
        for (int i=0;i<res.size(); i++) {
            if (Arrays.equals(res.get(i), arr)) { // if match found
                // give the next permutation
                if (i < res.size()- 1) {
                    int[] nextPermutation = res.get(i+1);
                    for (int j=0; j<arr.length; j++) {
                        arr[j] = nextPermutation[j];
                    }
                }
                // If the given permutation is at the last
                if (i == res.size() - 1) {
                    int[] nextPermutation = res.get(0);
                    for (int j=0;j<arr.length; j++) {
                        arr[j] = nextPermutation[j];
                    }
                }
                break;
            }
        }
    }
    static void permutations(List<int[]> res, int[] arr, int index) {
        // Base case: if index reaches to the length of the array stop it
        if (index == arr.length-1) {
            res.add(arr.clone());
            return;
        }
        for (int i=index;i<arr.length; i++) {
            swap(arr, index,i);
            permutations(res, arr, index+1);
            swap(arr, index, i);
        }
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7, 5, 0};  
        nextPermutation(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
}