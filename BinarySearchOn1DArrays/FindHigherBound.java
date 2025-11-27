import java.util.Scanner;

public class FindHigherBound {
    
    public static int higherBound(int [] nums, int target){
        int n = nums.length;

        if(nums[0] >= target) return 0;

        if(nums[n - 1] < target) return -1;

        int low = 0;
        int high = n - 1;
        int ans = -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] > target){
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

        System.out.println("Enter the target value for whom we have to search higher bound:");
        int target = input.nextInt();

        System.out.println("The higher bound for the target " + target + " is at index: " + higherBound(arr, target));
    }
}
