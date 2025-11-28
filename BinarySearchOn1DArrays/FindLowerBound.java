import java.util.*;

public class FindLowerBound {
    
    // The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.
    public static int lowerBound(int [] nums, int target){
        
        int n = nums.length;

        if(nums[0] >= target) return 0;

        if(nums[n - 1] < target) return -1;

        int low = 0;
        int high = n - 1;
        int ans = -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] >= target){
              ans = mid;
              high = mid - 1;  
            }else{
                low = mid + 1;
            }
        }

        return ans;
    
    }
    
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = input.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements of the array in sorted order:");
        for(int i = 0; i < size; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Enter the target value for whom we have to search lower bound:");
        int target = input.nextInt();

        System.out.println("The lower bound for the target " + target + " is at index: " + lowerBound(arr, target));

        input.close();
    }
}
