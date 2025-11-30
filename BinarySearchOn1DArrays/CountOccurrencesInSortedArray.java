import java.util.*;

public class CountOccurrencesInSortedArray {
    
    public static int countOccurences(int [] nums, int target){
        return (searchLast(nums, target) - searchFirst(nums, target) + 1);
    }

    public static int searchFirst(int [] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){
           int mid = (low + high)/2;

            if(nums[mid] >= target){
                if(nums[mid] == target) ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int searchLast(int [] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){
           int mid = (low + high)/2;

            if(nums[mid] <= target){
                if(nums[mid] == target) ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size of sorted array:");
        int size = input.nextInt();

        int [] nums = new int[size];

        System.out.println("Enter elements in sorted order for array: ");
        for(int i = 0; i<nums.length; i++){
            nums[i] = input.nextInt();
        }

        System.out.println("Enter target element to count occurences: ");
        int target = input.nextInt();

        System.out.println("The number of occurences of target in sorted array is: " + countOccurences(nums, target));

        input.close();
    }
}