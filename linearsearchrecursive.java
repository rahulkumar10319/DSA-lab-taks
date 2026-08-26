
public class linearsearchrecursive {


    public static int linearsearchrecursive(int[] arr, int target, int index) {
        if(index == arr.length) {
            return -1;
        }
        if(arr[index] == target) {
            return index;
        }
        return linearsearchrecursive(arr, target, index + 1);
    }

    // Main
    public static void main(String[] args) {

        int[] arr = {5, 12, 7, 25, 3};
        int target = 25;

        int result = linearsearchrecursive(arr, target, 0);

        if(result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Found at index: " + result);
    }
}