import java.util.*;


public class RepeatingAndMissingNumber{
    
    // Optimal Approach => Time Complexity => O(n) and Space Complexity => O(1)
    public static int[] findRepeatingAndMissingNumber(int [] nums){
       int [] arr = new int[2];
       int n = nums.length;

       int sumn = n*(n+1)/2; 
       int sumn2 = n*(n+1)*(2*n+1)/6;

       int totalSum = 0;
       int totalSquareSum = 0;

       for(int i = 0; i<nums.length; i++){
           totalSum += nums[i];
           totalSquareSum += (nums[i]*nums[i]);
       }

       int one = sumn - totalSum;  // missing - double
       int two = sumn2 - totalSquareSum;          // missing^2 - double^2

       two = two/one; // missing + double

       arr[1] = (one + two)/2;
       
       arr[0] = arr[1] - one;

       return arr;
    }


    // Better Approach => Time Complexity => O(n) and Space Complexity => O(n)
    /* public static int[] findRepeatingAndMissingNumber(int [] nums){
        int n = nums.length;
        int missing = n*(n+1)/2;
        
        int [] arr = new int[2];
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i<n; i++){
           if(set.contains(nums[i]) == true){
             arr[0] = nums[i];
             continue;
           }
           missing -= nums[i];
           set.add(nums[i]);
        }

        arr[1] = missing;

        return arr;
    } */
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

       System.out.println("Enter size for an array: ");
       int size = input.nextInt();

       int [] nums = new int[size];

       System.out.println("Enter elements for array from 1 to " + size + " with one missing and one double entity: ");
       for(int i = 0; i<size; i++){
          nums[i] = input.nextInt();
       }

       System.out.println("Repeating and Missing Numbers in inputed Array: " + Arrays.toString(findRepeatingAndMissingNumber(nums)));

       input.close();
    }
}