import java.util.*;

// Its Time Complexity = Brute Force Approach => NlogN + N => Better Approach => 2N
public class secondLargestElement {
    
    // This Approach is Optimal Approach => Time Complexity = N
    public static int smax(int [] arr){
        if (arr.length < 2) {
            System.out.println("Array must contain at least two elements.");
            return -1;
        }
       
       int max = arr[0], smax = arr[0];
       for(int i = 1; i<arr.length; i++){
        if(arr[i] > max){
            smax = max;
            max =  arr[i];
        }else{
            if(arr[i] > smax && arr[i] != max){
                smax = arr[i];
            }
        }
       }

        return smax;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }
        
        System.out.println("Second Largest Element in Array: " + smax(nums));

        input.close();
    }
}