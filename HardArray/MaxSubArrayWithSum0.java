import java.util.*;

public class MaxSubArrayWithSum0 {
    // Optimal Approach => Time Complexity: O(n) , Space Complexity: O(n)
    public static int maxlen(int [] nums){
      HashMap<Integer, Integer> prefixSum = new HashMap<>();
      
      int maxlength = 0;

      int sum = 0;
      for(int i = 0; i<nums.length; i++){
        sum += nums[i];

        if(sum == 0){
          maxlength = i + 1;
        }

        if(prefixSum.containsKey(sum) == true){
          maxlength = Math.max(maxlength, i - prefixSum.get(sum));
        }else{
          prefixSum.put(sum, i);
        }
      }

      return maxlength;
      
    }
    
    // Better Approach => Time Complexity: O(n^2) , Space Complexity: O(1)
    /* public static int maxLen(int[] arr) {
      int maxLength = 0;
      int maxSum = 0;

      int i = 0;
      int j = arr.length - 1;

      for(int k = 0; k<=j; k++){
        maxSum += arr[k]; 
      }

      int sum = maxSum;

      while(i < j){
        if(sum == 0){
          maxLength = Math.max(maxLength, j-i+1);
          break;
        }else{
          while(sum != 0 && i<j){
            sum -= arr[j];
            j--;
          }
          
          if(sum == 0) continue;
          if(j == i){
            j = arr.length - 1;
            sum = maxSum - arr[i];
            i = i+1;
          }
        }
      }

      return maxLength;
    } */
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = input.nextInt();

        int [] arr = new int[size];

        System.out.println("Enter the elements for array in positives and negatives: ");
        for(int i = 0; i<size; i++){
            arr[i] = input.nextInt();
        }

        input.close();

        System.out.println("The maximum length of array with sum 0 is: " + maxlen(arr));
    }

}