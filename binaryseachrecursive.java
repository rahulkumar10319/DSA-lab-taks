
public class binaryseachrecursive {

    // Recursive binary search
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2; // midpoint

        if (arr[mid] == target) return mid;
        else if (target > arr[mid]) return binarySearchRecursive(arr, target, mid + 1, high);
        else return binarySearchRecursive(arr, target, low, mid - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;

        int index = binarySearchRecursive(arr, target, 0, arr.length - 1);

        if (index != -1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found");
    }
}
