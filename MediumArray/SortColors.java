import java.util.*;

public class SortColors {

    // Optimal Approach => Time Complexity => O(n) Space Complexity => O(1) => Approach used Dutch National Flag Algorithm
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low++] = nums[mid];
                nums[mid++] = temp;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                // Swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high--] = temp;
            }
        }
    }
    
    // Better Approach => Time Complexity => O(2n) Space Complexity => O(3) ~ O(1)
    /* public void sortColors(int[] nums) {
       HashMap <Integer, Integer> map = new HashMap<>();

       for(int i = 0; i<nums.length; i++){
           map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
       } 

       int red = map.getOrDefault(0, 0);
       for(int i = 0; i<red; i++){
         nums[i] = 0;
       }
        
       int blue = map.getOrDefault(1, 0); 
       for(int i = red; i<red+blue; i++){
         nums[i] = 1;
       }

       int white = map.getOrDefault(2, 0);
       for(int i = red+blue; i<red+blue+white; i++){
         nums[i] = 2;
       }
    } */
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array only 0, 1 and 2: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }

        sortColors(nums);
        System.out.println("Sorted Array is: " + Arrays.toString(nums));

        input.close();
    }
}
