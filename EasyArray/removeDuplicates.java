// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

// Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.

// The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

import java.util.Arrays;
import java.util.Scanner;

public class removeDuplicates{
    
    public static int RemoveDuplicatesFromSortedArray(int [] nums){
       int k = 0;

       for(int i = 0; i<nums.length-1; i++){
        if(nums[i] != nums[i+1]){
           k++;
           nums[k] = nums[i+1];
        }
       }

       return ++k;

    }

    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array in sorted form: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }
        
        int k = RemoveDuplicatesFromSortedArray(nums);
        System.out.println("Array after removing duplicated items till " + k + " elements: " + Arrays.toString(nums));

        input.close();
    }
}