import java.util.*;

public class SearchInsertPosition {
    
    // Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    // Optimal Approach: Time Complexity: O(log n)  
    public static int searchInsertPosition(int [] nums, int target){
       int n = nums.length;
        
        if(target < nums[0]) return 0;

        if(target > nums[n-1]) return n;
        
        int low = 0;
        int high = n-1;

        int ans = 0;

        while(low <= high){

        int mid = (low + high)/2;
        ans = mid;

        if(nums[mid] == target) return ans;

        else if(nums[mid] > target){
            ans = mid;
            high = mid - 1;
        }

        else{
            ans = mid + 1;
            low = mid + 1;
        }

        }

        return ans;
    }
    
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size for array: ");
        int size = input.nextInt();

        int [] arr = new int[size];

        System.out.println("Enter the elements for array in sorted order: ");
        for(int i = 0; i<size; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Enter the target element for which we have to search insert position: ");
        int target = input.nextInt();

        System.out.println("The index where the target element is found or can be inserted is: " + searchInsertPosition(arr, target));

        input.close();
    }
}
