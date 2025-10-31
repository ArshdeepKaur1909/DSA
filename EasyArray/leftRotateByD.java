import java.util.*;

public class leftRotateByD{
    
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
    
    // Better Approach => Time Complexity = O(N+d) and Space Complexity = O(d)
    // public static void LeftRotateByD(int [] nums, int d){
    //     int n = nums.length;
    //     d = d%n;

    //     if(d == 0 || n == 1) return;

    //     int [] arr = new int[d];
    //     for(int i = 0; i<d; i++){
    //         arr[i] = nums[i];
    //     }

    //     for(int i = d; i<n; i++){
    //         nums[i-d] = nums[i];
    //     }

    //     for(int i = 0; i<d; i++){
    //         nums[n-d+i] = arr[i];
    //     }
    // }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size for array: ");
        int size = input.nextInt();
        
        int [] nums = new int[size];

        System.out.println("Enter elements for Array: ");
        for(int i = 0; i<size; i++){ 
           nums[i] = input.nextInt();
        }

        LeftRotateByD(nums, 10);
        System.out.println("Array after rotating left by 10 places: " + Arrays.toString(nums));

        input.close();
    }
}
