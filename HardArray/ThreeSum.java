import java.util.*;

public class ThreeSum {
    // Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    
    // Optimal Approach 

    // Better Approach => Time Complexity: O(N^2) and Space Complexity: O(N)
    /* public static List<List<Integer>> threeSum(int [] nums){
       List<List<Integer>> main = new Vector<>();

       for(int i = 0; i<nums.length-2; i++){
        HashSet<Integer> third = new HashSet<>();
         for(int j = i+1; j<nums.length; j++){
            int num = -(nums[i] + nums[j]);
            if(third.contains(num) == true){
                List<Integer> ans = new Vector<>(3);
                ans.add(nums[i]);
                ans.add(nums[j]);
                ans.add(num);
                Collections.sort(ans);
                if(main.contains(ans) == false) main.add(ans);
            }
            third.add(nums[j]);
        }
       }

       return main;

    } */

    // Brute Force Approach => O(N^3) time complexity and O(1) space complexity
    /* public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> main = new Vector<>();

        for(int i = 0; i<nums.length-2; i++){
            for(int j = i+1; j<nums.length-1; j++){
                for(int k = j+1; k<nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                       List<Integer> ans = new Vector<>(3);
                       ans.add(nums[i]);
                       ans.add(nums[j]);
                       ans.add(nums[k]);
                       Collections.sort(ans);
                       if(main.contains(ans) == false) main.add(ans);
                    }
                }
            }
        }

        return main;
    } */

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();

        int [] arr = new int[size];
        System.out.println("Enter elements for array with any values: ");
        for(int i = 0; i<size; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("The triplets with sum 0 are:  " + threeSum(arr));
        input.close();
    }
}
