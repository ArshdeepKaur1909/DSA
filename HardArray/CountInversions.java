import java.util.*;

public class CountInversions{
    
    private static int merge(int [] nums, int low, int mid, int high){
        int [] mergeArray = new int[high - low + 1];
        int count = 0;
        int i = low;
        int j = mid + 1;
        int k = 0;

        while( i <= mid && j <= high){
            if(nums[i] <= nums[j]){
               mergeArray[k++] = nums[i++];
            }else{
               mergeArray[k++] = nums[j++];  
               count += mid - i + 1; 
            }
        }
        while(i <= mid){
           mergeArray[k++] = nums[i++];
        }
        while(j <= high){
           mergeArray[k++] = nums[j++];
        }

        for(int y = 0; y < mergeArray.length; y++){
            nums[low + y] = mergeArray[y];
        }

        return count;
    }

    private static int mergeSort(int [] nums, int low, int high){
        if(low >= high){
            return 0;
        } 
        int count = 0;

        int mid = (low + high)/2;
        int leftAns = mergeSort(nums, low, mid);
        int rightAns = mergeSort(nums, mid+1, high);
        int mainAns = merge(nums, low, mid, high);


        count += leftAns + rightAns + mainAns;
        
        return count;
    }
    
    // Inversion of an array: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i]
    // Time Complexity: O(NlogN) and Space Complexity: O(N)
    public static int countInversions(int [] nums){
         return mergeSort(nums, 0, nums.length-1);
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();

        int [] nums = new int[size];

        System.out.println("Enter elements for array: ");
        for(int i = 0; i<size; i++){
            nums[i] = input.nextInt();
        }

        System.out.println("The inversions present in array: " + countInversions(nums));

        input.close();
    }
}