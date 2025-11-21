import java.util.*;

public class FourSum{
    
    // Time Complexity: O(n^3) and Space Complexity: O(no. of quadruplets)
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> main = new Vector<>();
        
        Arrays.sort(nums);

        for(int i = 0; i<nums.length-3; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            for(int j = i+1; j<nums.length-2; j++){
                if(j > i+1 && nums[j-1] == nums[j]) continue;
                int k = j+1;
                int l = nums.length-1;

                while(k < l){
                   long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];

                   if(sum < target){
                    k++;
                   }
                   else if(sum > target){
                    l--;
                   }
                   else{
                    main.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                    k++;
                    l--;

                    while(k<l && nums[k-1] == nums[k]) k++;
                    while(k<l && nums[l] == nums[l+1]) l--;
                   }
                }
            }
        }

        return main;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter size for array: ");
        int size = input.nextInt();

        int [] nums = new int[size];

        System.out.println("Enter elements for array: ");
        for(int i = 0; i<size; i++){
            nums[i] = input.nextInt();
        }
         
        System.out.println("Enter a target whom want to check 4 sum: ");
        int target = input.nextInt();

        System.out.println("Array contains following quadruplets whose sum = target: " + fourSum(nums, target));

        input.close();
    }
}