import java.util.*;

public class BinarySearch {
    
    // Time Complexity: O(log n) and Space Complexity: O(1)
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } 
            else if (arr[mid] < target) {
                low = mid + 1; // Search in the high half
            } 
            else {
                high = mid - 1; // Search in the low half
            }
        }
        return -1; // Target not found
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = input.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements of the array in sorted order:");
        for(int i = 0; i < size; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Enter the target value to search for:");
        int target = input.nextInt();   

        int result = binarySearch(arr, target);
        if(result == -1){
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }

        input.close();
    }
}