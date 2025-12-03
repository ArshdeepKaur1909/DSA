import java.util.Scanner;

public class FindHowManyTimeArrayIsRotated {
    
    public static void reverse(int [] nums, int start, int end){
        if (nums.length == 1) return;

        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    // Optimal Approach => Time Complexity = O(2n) and Space Complexity = O(1)
    public static void LeftRotateByD(int [] nums, int d){
        int n = nums.length;
        d = d%n;

        if(d == 0 || n == 1) return;

        reverse(nums, 0, d-1);
        reverse(nums, d, n-1);
        reverse(nums, 0, n-1);
    }
    
    public static int countRotations(int [] nums){
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        while(low <= high){
            int mid = (low + high)/2;
            
            // Left Part is sorted
            if(nums[low] <= nums[mid]){
               if(nums[low] < min){
                min = nums[low];
                minIndex = low;
               }
               low = mid + 1;
            }
            // Right Part is sorted
            else{
              if(nums[mid] < min){
                min = nums[mid];
                minIndex = mid;
               }
               high = mid - 1;
            }
        }


        return (nums.length - minIndex);
    }
    
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();

        int [] nums = new int[size];
        System.out.println("Enter elements for array in sorted manner: ");
        for(int i = 0; i<size; i++){
            nums[i] = input.nextInt();
        }

        System.out.println("Enter the places by which you want to left rotate the sorted array: ");
        int places = input.nextInt();

        LeftRotateByD(nums, places);

        System.out.println("The left rotated array is: ");
        for(int i = 0; i<size; i++){
            System.out.println(nums[i] + " ");
        }

        System.out.println("The array is rotated " + countRotations(nums) + " times.");

        input.close();
    }
}