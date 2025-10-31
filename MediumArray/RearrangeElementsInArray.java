import java.util.*;

public class RearrangeElementsInArray {

    // Brute Force Approach => Time Complexity => O(n)+O(n) Space Complexity => O(n)
    public static int[] rearrangeArray(int[] nums) {
      int n = nums.length/2;

      Vector <Integer> pos = new Vector<>(n);
      Vector <Integer> neg = new Vector<>(n); 

      for(int i = 0; i<nums.length; i++){
        if(nums[i] < 0) neg.add(nums[i]);
        else pos.add(nums[i]);
      }

      for(int i = 0; i<n; i++){
         nums[2*i] = pos.get(i);
         nums[2*i + 1] = neg.get(i);
      }
      return nums;

    }
    
    // Optimal Approach => Time Complexity => O(n) Space Complexity => O(n)
    /* public static int[] rearrangeArray(int[] nums) {
      int [] nums2 = new int[nums.length];

      int pos = 0, neg = pos + 1;
      for(int i = 0; i<nums.length; i++){
        if(nums[i] > 0){
            nums2[pos] = nums[i];
            pos += 2;
        }else{
            nums2[neg] = nums[i];
            neg += 2;
        }
      }
      return nums2;
      
    } */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array only 0, 1 and 2: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }

        input.close();
    }
}
