import java.util.*;

public class longestSubArrayWithSum {
    
    //Optimal Approach using Sliding Window => Best Case Time Complexity: O(n), Worst Case Time Complexity: O(2n), Space Complexity: O(1) => Works only for Positive Numbers
    public static int LongestSubArrayWithSum(int [] nums, int target){
        int left = 0, right = 0;
        long sum = nums[0];
        int maxLen = 0;

        while(right < nums.length){
            while(sum > target && left <= right){
                sum -= nums[left];
                left++;
            }

            if(sum == target){
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
            if(right < nums.length) sum += nums[right];
        }

        return maxLen;
    }

    //Better Approach using Hashmap => Time Complexity: O(n), Space Complexity: O(n) => Can work for all arrays including negative, positive and zeroes
    /* public static int LongestSubArrayWithSum(int [] nums, int target){
        HashMap <Long, Integer> map = new HashMap<>();

        long sum = 0, maxLen = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];

            if(sum == target){
                maxLen = Math.max(maxLen, i+1);
            }

            if(map.get(sum - target) != null){
                maxLen = Math.max(maxLen, i-map.get(sum - target));
            }
            
            if(map.get(sum) == null){ // This condition is basically when Zeroes are present in array
                map.put(sum, i);
            }
        }

        return (int)maxLen;
}  

    //Brute Force Approach => Time Complexity: O(n^2), Space Complexity: O(1) => Can work for all arrays including negative, positive amd zeroes
    /*  public static int LongestSubArrayWithSum(int [] nums, int target){
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            long sum = 0; // storing sum in long datatype to avoid integer overflow
            for(int j = i; j < nums.length; j++){
                    sum += nums[j];

                    if(sum == target){
                        maxLen = Math.max(maxLen, j-i+1);
                    }
            }
        }

        return maxLen;
    } */
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }
        
        System.out.println("Enter a target: ");
        int targetSum = input.nextInt();

        System.out.println("Longest SubArray having sum = " + targetSum + " : " + LongestSubArrayWithSum(nums, targetSum));

        input.close();
    }
}
