import java.util.Scanner;

// It has Best Case Time Complexity of O(n) and Average and Worst Case Time Complexity of O(n^2).
class BubbleSort {

    public static void bubbleSort(int [] nums){
        for(int i = 0; i<nums.length - 1; i++){
            int swap = 0;
            for(int j = 0; j<nums.length - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swap++;
                }
            }
            if(swap == 0){
                break;
            }
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
        bubbleSort(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
