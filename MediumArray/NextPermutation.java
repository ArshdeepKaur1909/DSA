import java.util.Scanner;

public class NextPermutation {
    
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: find first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: find element just larger than nums[i]
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }

        input.close();


    }    
}
