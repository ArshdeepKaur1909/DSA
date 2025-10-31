import java.util.HashMap;
import java.util.Scanner;

/* */

public class appearsOnce {
    
    // Better Approach => Time Complexity => O(2n) and Space Complexity => O(n) because of HashMap
    public static int singleNumber(int[] nums) {
      HashMap <Integer, Integer> map = new HashMap<>();

      for(int num: nums){
         map.put(num, map.getOrDefault(num, 0) + 1);
      }

      for(int key: map.keySet()){
        if(map.get(key) == 1) return key;
      }

      return -1;
    }

    // Optimal Approach => Time Complexity => O(n) and Space Complexity => O(1)
    /* public static int singleNumber(int[] nums) {
        int XOR = 0;

        for(int i = 0; i<nums.length; i++){
            XOR = XOR^nums[i];
        }

        return XOR;
    } */
    public static void main(String [] main){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }
        
        System.out.println("Element appearing once: " + singleNumber(nums));

        input.close();
    }
}
