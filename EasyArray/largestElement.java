import java.util.*;


// Array can store maximum elements in an array = 10^6 if declared locally else it can store 10^7 elements if declared globally.
public class largestElement{
    
    public static int LargestElement(int [] arr){
        if (arr.length < 2) {
            System.out.println("Array must contain at least two elements.");
            return arr[0];
        }
        
        int max = arr[0];
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        return max;
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
        
        System.out.println("Largest Element in Array: " + LargestElement(nums));

        input.close();
    }
}