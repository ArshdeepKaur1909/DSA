// We have to find the maximum sum of a contiguous subarray in a given array of integers.

import java.util.Scanner;

public class MaxSumInArray {
   
    // Optimal Approach => Time Complexity => O(n) Space Complexity => O(1) => We are using Kadane's Algorithm here.
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        int i = 0;
        while(i < nums.length){
           sum += nums[i];
           maxSum = Math.max(maxSum, sum);

           if(sum < 0){
            sum = 0;
            i++;
           }
           else i++;
        }

        return maxSum;
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

        int result = maxSubArray(nums);
        System.out.println("Maximum Sum of Contiguous Subarray is: " + result);

        input.close();
    } 
}
