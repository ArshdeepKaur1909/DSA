import java.util.Scanner;

public class LongestConsecutiveArray{
    
    // Brute Force Approach => Time Complexity: O(n^2) and Space Complexity: O(1)
    public static int longestConsecutive(int[] nums) {
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

        input.close();
    }
}