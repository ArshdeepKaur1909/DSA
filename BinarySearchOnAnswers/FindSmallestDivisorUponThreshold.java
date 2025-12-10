import java.util.*;

public class FindSmallestDivisorUponThreshold {

    // Time Complexity: O(N log(Max))
    public static int max(int [] nums){
        int max = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(nums[i] > max){
               max = nums[i];
            }
        }

        return max;
    }

    public static boolean checkDivisorSum(int [] nums, int mid, int threshold){
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
           int dividedValue = Math.ceilDiv(nums[i], mid);
           sum += dividedValue;

           if(sum > threshold) return false;
       }

       return true;
    }
    
    public static int smallestDivisor(int [] nums, int threshold){
        if(threshold == nums.length) return max(nums); 

        int low = 1;
        int high = max(nums);

        while(low <= high){
            int mid = (low + high)/2;

            boolean result = checkDivisorSum(nums, mid, threshold);

            if(result){
               high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = input.nextInt();

        int [] nums = new int[size];
        for(int i = 0; i<size; i++){
            System.out.print("Enter " + (i+1) + " element: ");
            nums[i] = input.nextInt();
        }

        System.out.print("Enter a threshold: ");
        int threshold = input.nextInt();

        System.out.println("The smallest divisor which divides array's elements and sums them less than or equal to threshold is: " + smallestDivisor(nums, threshold));

        input.close();
    }
}