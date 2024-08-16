public class TransitionPoint {

    public static int findTransitionPoint(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        
        // If the array is empty or contains only 0s, return -1
        if (n == 0 || arr[high] == 0) {
            return -1;
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if the mid element is the transition point
            if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)) {
                return mid;
            } else if (arr[mid] == 0) {
                // Move right if mid element is 0
                low = mid + 1;
            } else {
                // Move left if mid element is 1 but not the transition point
                high = mid - 1;
            }
        }
        
        // If no 1 is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 0, 0, 1, 1};
        int[] arr2 = {0, 0, 0, 0};
        
        System.out.println(findTransitionPoint(arr1)); // Output: 3
        System.out.println(findTransitionPoint(arr2)); // Output: -1
    }
}
