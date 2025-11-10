import java.util.Arrays;
import java.util.Scanner;

public class LongestConsecutiveArray{
    
    //Optimized Approach Using HashSet => Time Complexity: O(n) and Space Complexity: O(n)
    /* public static int longestConsecutive(int[] nums) {
        if(nums.length == 1) return 1;
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longest = 0;

        for(int num : nums){
            if(!set.contains(num - 1)){
                int currentNum = num;
                int count = 1;

                while(set.contains(currentNum + 1)){
                    currentNum = currentNum + 1;
                    count = count + 1;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    } */
    
    // Better Approach => Time Complexity: O(nlogn + n) and Space Complexity: O(n)
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 1) return 1;
        
        Arrays.sort(nums);

        int count = 0, lm = Integer.MIN_VALUE, longest = 0; 

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == lm) continue;

            if(nums[i]-1 == lm){
                count = count + 1;
                lm = nums[i];
            }else{
                count = 1;
                lm = nums[i];
            }

            longest = Math.max(count, longest);
        }

        return longest;
    }
    
    // Brute Force Approach => Time Complexity: O(n^2) and Space Complexity: O(1)
    /* public static int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    
    int maxCount = 1;
    for (int i = 0; i < nums.length; i++) {
        int current = nums[i];
        int count = 1;
        
        // Look for next consecutive number
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == current + 1) {
                current++;
                count++;
            }
        }
        maxCount = Math.max(maxCount, count);
    }
    return maxCount;
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

        input.close();
    }
}