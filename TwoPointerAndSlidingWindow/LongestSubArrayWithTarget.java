import java.util.*;

class LongestSubArrayWithTarget{
    public static void main(String [] args){
        //input object creation from scanner class
        Scanner input = new Scanner(System.in);

        //inputing size for array 
        System.out.print("Enter size of Array: ");
        int size = input.nextInt();

        //Memory allocation of array w.r.t. input size
        int [] nums = new int[size];

        //inputing array elements
        System.out.println("Enter " + size + " elements: ");
        for(int i = 0; i < size; i++){
           nums[i] = input.nextInt();
        }
        
        //inputing target for whom have to find maximum subarray 
        System.out.println("Enter a target: ");
        int target = input.nextInt();
        
        input.close();

        int l, r, maxSubArrayLength;
        l = r = maxSubArrayLength = 0;
        
        int sum = 0;
        
        //Brute Force Approach --> Time Complexity = O(n^2) and Space Complexity = O(1)
        // for (int i = 0; i < arr.length; i++) {
        // int sum = 0;
        // for (int j = i; j < arr.length; j++) {
        // sum += arr[j];
        // if (sum == target) {
        //     maxSubArrayLength = Math.max(maxSubArrayLength, j - i + 1);
        // }
        // }
        // }


        // Better Approach than Brute Force --> Time Complexity = O(2n) and Space Complexity = O(1)
        // while( r < size ){
        //   sum += nums[r];

        //   while(sum > target){
        //     sum -= nums[l];
        //     l++;
        //   }
          
        //   if(sum <= target){
        //     maxSubArrayLength = Math.max(maxSubArrayLength, r-l+1);
        //   }

        //   r++;
        // }

        //Optimized Solution --> Time Complexity = O(n) and Space Complexity = O(1)
        while( r < size ){
          sum += nums[r];

          if(sum > target){
            sum -= nums[l];
            l++;
          }
          
          if(sum <= target){
            maxSubArrayLength = Math.max(maxSubArrayLength, r-l+1);
          }

          r++;
        }

        System.out.println("Maximum Subarray Length having sum = target: " + maxSubArrayLength);
    }
}