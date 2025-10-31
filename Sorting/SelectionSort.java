import java.util.Scanner;

// It has Best, Average and Worst Case Time Complexity of O(n^2).
public class SelectionSort {
    public static void selectionSort(int [] nums){
        for(int i = 0; i<nums.length-1; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = i; j<nums.length; j++){
               if(nums[j] < min){
                  min = nums[j];
                  minIndex = j;
               }
            }

            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

        System.out.println("Enter number of elements to be sorted of array: ");
        int n = input.nextInt();

        int [] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i = 0; i<n; i++){
            arr[i] = input.nextInt();
        }
        
        input.close();

        System.out.println("Array after sorting: ");
        selectionSort(arr);
        
        for(int i = 0; i<n; i++){
          System.out.println(arr[i]);
        }  
   }
}