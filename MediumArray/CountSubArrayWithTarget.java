import java.util.HashMap;
import java.util.Scanner;

public class CountSubArrayWithTarget {
    
    // Optimal Approach - Using HashMap => O(n) time complexity and O(n) space complexity
    public static int subarraySum(int[] nums, int k) {
        HashMap <Long, Integer> map = new HashMap<>();
        map.put(0l, 1);

        long sum = 0;
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            
            if(map.get(sum - k) != null) count += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
     return count;
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
        
        System.out.println("Enter a target: ");
        int targetSum = input.nextInt();

        System.out.println("Total SubArray having sum = " + targetSum + " : " + subarraySum(nums, targetSum));

        input.close();
    }
}
