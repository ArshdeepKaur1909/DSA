import java.util.Scanner;

public class SingleElementInSortedArray {
    
    public static int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];


        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
           int mid = (low + high)/2;

           if(mid == low && mid == high) return nums[mid];

           if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
              return nums[mid];
           }

           else{
            if(nums[mid] == nums[mid - 1]){
               if((mid - low - 1)%2 == 0){
                  low = mid + 1; 
               }else{
                  high = mid - 2;
               }
            }else{
                if((high - mid - 1)%2 == 0){
                    high = mid - 1;
                }else{
                    low = mid + 2;
                }
            }
           }
        }

        return -1;
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

        System.out.println("The unique element in the array is: " + singleNonDuplicate(arr));

        input.close();
    }
}