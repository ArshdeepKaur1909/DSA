import java.util.*;

public class FloorAndCeil{
    
    // Time Complexity: O(log n)
    public static int[] floorAndCeil(int [] nums, int target){
        int n = nums.length;
        int [] floorAndCeil = {-1, -1};

        if(nums[n-1] <= target){
            floorAndCeil[0] = nums[n-1];
            return floorAndCeil;
        }

        if(nums[0] >= target){
            floorAndCeil[1] = nums[0];
            return floorAndCeil;
        }

        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                floorAndCeil[0] = nums[mid];
                floorAndCeil[1] = nums[mid];
                return floorAndCeil;
            }

            else if(nums[mid] > target){
                floorAndCeil[1] = nums[mid];
                high = mid - 1;
            }

            else{
                floorAndCeil[0] = nums[mid];
                low = mid + 1;
            }
        }

        return floorAndCeil;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        int [] nums = new int[size];

        System.out.println("Enter the elements of array in sorted order: ");
        for(int i = 0; i < size; i++){
            nums[i] = input.nextInt();
        }

        System.out.println("Enter the target value: ");
        int target = input.nextInt();

        System.out.println("Floor and Ceil values for target are: " + Arrays.toString(floorAndCeil(nums, target)));

        input.close();
    }
}