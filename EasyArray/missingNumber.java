// We will be having an array of size = N and that will constituting of numbers in between 0 to N i.e. total N+1 numbers which means one number will be missing in given array

/* */

import java.util.Scanner;

public class missingNumber {
    
    // Optimal Approach1 => Time Complexity = O(n) and Space Complexity = O(1)
    // public static int MissingNumber(int[] nums) {
    //     int n = nums.length;

    //     int nsum = n*(n+1)/2;
        
    //     int sum = 0;
    //     for(int i = 0; i<nums.length; i++){
    //        sum += nums[i];
    //     }

    //     return nsum-sum;
    // }

    // Optimal Approach2 => Time Complexity = O(n) and Space Complexity = O(1) => Way more better than Optimal Approach1 for N = 10^5
    // XOR basically returns 0 when XOR is in between both same numbers and returns number when XOR is taken in between a number and zero.
    public static int MissingNumber(int [] nums){
       int n = nums.length;
       
       int XOR1 = 0, XOR2 = 0;
       for(int i = 0; i<n; i++){
           XOR1 = XOR1^nums[i];
           XOR2 = XOR2^(i+1);
       }

       return XOR1^XOR2;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array in between 0 to " + size + ": ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }

        System.out.println("Missing number in input array between 0 to " + size + ": " + MissingNumber(nums));

        input.close();
    }
}
