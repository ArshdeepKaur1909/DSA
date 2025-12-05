import java.util.Scanner;

public class PeakElement{
    
    public static int findPeakElement(int [] nums) {
        if(nums.length == 1) return 0;
          // Consider before and after array to be -infinity present => so it is clear first       
         // element of array is greater than its left element and last element is greater than its 
        // right.
        if(nums[0] > nums[1]) return 0; // peak element = first element
         
        else if(nums[nums.length - 2] < nums[nums.length - 1]) return nums.length - 1;
        // peak element = last element

        int low = 1;
        int high = nums.length - 2;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]){
               return mid;
            }

            else if(nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }

            else{
                high = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        int [] nums = new int[size];

        System.out.println("Enter the elements of array: ");
        for(int i = 0; i < size; i++){
            nums[i] = input.nextInt();
        }

        System.out.println("The index of peak element is: " + findPeakElement(nums));

        input.close();
    }
}