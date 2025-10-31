import java.util.Scanner;

public class findMaxConsecutiveOnes {
    
    // Optimal Approach => Time Complexity => O(n) and Space Complexity => O(1)s
    public static int FindMaxConsecutiveOnes(int[] nums) {
        int count = 0, i = 0, maxCount = 0;
        
        while(i < nums.length){
            if(nums[i] == 0){
                count = nums[i];
                i++;
            }else{
                count += nums[i];
                i++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    // Brute Force Approach => Worst Case Time Complexity => O(N^2) and Best and Average Case Time Complexity => O(N)
    // public static int FindMaxConsecutiveOnes(int [] nums){
    //    int maxCount = 0, i = 0, j= 0;
        
    //     while(i < nums.length){
    //         if(nums[i] == 0){
    //             i++;
    //         }else{
    //             int count = 1;
    //             j = i+1;
                
    //             while(j < nums.length){
    //             if(nums[j] == 0){
    //                 i = i+2;
    //                 break;
    //             }
    //             else{
    //                 count++;
    //                 j++;
    //             }
    //           }

    //           maxCount = Math.max(maxCount, count);

    //           if( j == nums.length ) break;
    //         }
    //     }

    //     return maxCount;
    // }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter binary digits for Array: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }


        System.out.println("Maximum Consecutive One's in Array is: " + FindMaxConsecutiveOnes(nums));
        input.close();
    }
}
