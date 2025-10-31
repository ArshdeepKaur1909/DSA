import java.util.*;

public class TwoSum {
    
    // Optimal Approach 2 => This approach is only optimal when in return is asked for boolean value whether such a pair exists or not => This is optimal in case when we don't want to use any extra data structure for solving the problem.
    public static boolean twoSum(int [] nums, int target){
        Arrays.sort(nums); // Sorting the array => Time Complexity => O(n log n)

        int left = 0, right = nums.length-1;

        while(left < right){
            int sum = nums[left] + nums[right];

            if(sum == target){
                return true;
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }

    // Optimal Approach 1 => Time Complexity => O(n) Space Complexity => O(n) => Time Complexity is O(n) because HashMap operations (put and get) take O(1) time on average.
    /* public static int[] twoSum(int [] nums, int target){
        HashMap <Integer, Integer> map = new HashMap<>();

        int [] array = new int[2];
        
        for(int i = 0; i<nums.length; i++){

            if(map.get(target - nums[i]) != null){
                array[0] = map.get(target - nums[i]);
                array[1] = i;
                return array;
            }

            map.put(nums[i], i);
        }

        return array;

    } */

    // Brute Force Approach => Time Complexity => O(n^2) Space Complexity => O(1)
    /* public static int[] twoSum(int [] nums, int target){
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
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

        // System.out.println("Enter target sum: ");
        // int target = input.nextInt();


        // System.out.println("Indices of the two numbers that add up to target: " + Arrays.toString(twoSum(nums, target)));
        input.close();
    }
}