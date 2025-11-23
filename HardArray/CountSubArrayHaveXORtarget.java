import java.util.*;

public class CountSubArrayHaveXORtarget{
    
    // Optimal Approach => For each XOR(XR) such that XR = x*k and k = target only then x = XR*k
    public static int countSubArrayHaveTargetXOR(int [] nums, int target){
       // map's key storing each XOR as x with value as count how many times that x/XOR comes
       HashMap <Integer, Integer> map = new HashMap<>();
       map.put(0, 1);
       int xr = 0;
       int count = 0;

       for(int i = 0; i<nums.length; i++){
           xr = xr^nums[i];

           int x = xr^target;

           if(map.get(x) != null){
             count += map.get(x);
           }

           map.put(xr, map.getOrDefault(xr, 0)+1);
       }

       return count;
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

        System.out.println("Enter a target for which we want to see with subArray's XOR is matching: ");
        int target = input.nextInt();

        System.out.println("Total SubArrays having XOR equal to target: " + countSubArrayHaveTargetXOR(nums, target));
        
        input.close();
    }
}