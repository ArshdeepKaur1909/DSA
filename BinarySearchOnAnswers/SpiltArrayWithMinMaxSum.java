import java.util.*;

public class SpiltArrayWithMinMaxSum {
    public static int[] maxAndSum(int [] nums){
        int max = nums[0];
        int sum = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(nums[i] > max) max = nums[i];
            sum += nums[i];
        }

        return new int[]{max, sum};
    }

    public static int kCount(int [] nums, int minSum){
       int parts = 1;
       int sum = 0;
       for(int i = 0; i<nums.length; i++){
           if(sum + nums[i] <= minSum){
             sum += nums[i];
           }else{
            parts++;
            sum = nums[i];
           }
       }

       return parts;
    }

    public static int splitArray(int [] nums, int k){
        int [] maxAndSum = maxAndSum(nums);

        if(k == 1) return maxAndSum[0];
        if(k == nums.length) return maxAndSum[1];

        int low = maxAndSum[0];
        int high = maxAndSum[1];

        while(low <= high){
           int mid = (low + high)/2;

           int parts = kCount(nums, mid);
           if(parts > k) low = mid + 1;
           else high = mid - 1;
        }

        return low;
    }

    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

       System.out.println("Enter elements: ");
       int size = input.nextInt();

       int [] nums = new int[size];
       for(int i = 0; i<size; i++){
          System.out.print("Enter " + (i+1) + " num: ");
          nums[i] = input.nextInt();
       }

       System.out.print("\nEnter no. of parts you have to divide array: ");
       int k = input.nextInt();

       System.out.println("The minimum sum possible such that array gets divided into inputed parts: " + splitArray(nums, k));

       input.close();
    }
}
