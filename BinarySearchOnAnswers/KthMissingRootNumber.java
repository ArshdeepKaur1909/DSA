import java.util.*;

public class KthMissingRootNumber {
    
    // Time Complexity: O(N) and Space Complexity: O(1)
    public static int kthMissingNumber(int [] arr, int k){
        int ans = k;

        for(int i = 0; i<arr.length; i++){
            if(arr[i] <= ans) ans++;
        }

        return ans;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = input.nextInt();

        int [] arr = new int[n];
        System.out.println("Enter elements of array between 1 to 1000: ");
        for(int i = 0; i<n; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Enter that position where you want to see who is present as some number from 1 to 1000 are present in array: ");
        int k = input.nextInt();

        System.out.println("The number now present at that position is from 1 to 1000: " + kthMissingNumber(arr, k));

        input.close();
    }
}
