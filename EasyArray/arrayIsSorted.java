import java.util.*;

public class arrayIsSorted{
    
    public static boolean isSorted(int [] nums){
       for(int i = 0; i<nums.length-1; i++){
        if(nums[i] > nums[i+1]) return false;
       }

       return true;
    }
    public static void main(String [] main){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }
        
        System.out.println("Is Array sorted or not: " + isSorted(nums));

        input.close();
    }
}
