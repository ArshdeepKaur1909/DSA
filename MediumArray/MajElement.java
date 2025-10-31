import java.util.*;

public class MajElement {
    
    // Optimal Approach => Time Complexity => O(n) Space Complexity => O(1) => Boyer-Moore Voting Algorithm
    public static int majorityElement(int[] nums) {
        int count = 0, majEl = 0;

        for(int i = 0; i<nums.length; i++){
            if(count == 0){
               majEl = nums[i];
               count++;
            }
            else if(nums[i] == majEl) count++;
            else count--;
        }

        int count1 = 0;
        for(int num: nums){
            if(num == majEl) count1++;
        }

        if(count1 > nums.length/2) return majEl;

        return -1;
    }

    // Better Approach => Time Complexity => O(n) Space Complexity => O(n)
   /* public static int majorityElement(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<>();
        
        int n = nums.length;
        int majEl = 0;
        
        if(n == 1) return nums[0];
        
        for(int i = 0; i<n; i++){
           map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(int key: map.keySet()){
            if(map.get(key) > n/2){
                majEl = key;
            }
        }

        return majEl;
    } */

    //Brute Force Approach => Time Complexity => O(n^2) Space Complexity => O(1)
    /* public int majorityElement(int[] nums) {
        int n = nums.length;
        int majEl = 0;
        
        if(n == 1) return nums[0];

        for(int i = 0; i<=(n/2 + 1); i++){
            int count = 1;
            for(int j = i+1; j<n; j++){
              if(nums[i] == nums[j]) count++;
            }

            if(count > n/2) majEl = nums[i];
        }

        return majEl;
    }*/
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }

        System.out.println("Majority Element in the Array is: " + majorityElement(nums));

        input.close();
    }
}
