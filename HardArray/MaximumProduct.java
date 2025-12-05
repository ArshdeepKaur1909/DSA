import java.util.*;

public class MaximumProduct {

    // Optimal Approach => O(n) Time Complexity & O(1) Space Complexity
    public static long maxProduct(int [] nums){
        long maxProduct = Integer.MIN_VALUE;
        int n = nums.length;

        long prefix = 1;
        long suffix = 1;

        for(int i = 0; i<nums.length; i++){

           if(prefix == 0) prefix = 1;
           if(suffix == 0) suffix = 1;

            prefix = prefix*nums[i];
            suffix = suffix*nums[n - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        int [] nums = new int[size];
        System.out.println("Enter the elements of array either positive, negative or zeroes: ");
        for(int i = 0; i < nums.length; i++){
            nums[i] = input.nextInt();
        }

        System.out.println("Maximum Product possible is: " + maxProduct(nums));

        input.close();
    }
}
