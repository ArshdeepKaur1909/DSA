import java.util.*;

// It has Best Case Time Complexity of O(n) and Average and Worst Case Time Complexity of O(n^2).
public class InsertionSort {
    public static void insertionSort(int [] arr){
        for(int i = 1; i<arr.length; i++){
            for(int j = i; j>0; j--){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int size = input.nextInt();

        System.out.println("Enter elements of array: ");
        int [] arr = new int[size];
        for(int i = 0; i<size; i++){
            arr[i] = input.nextInt();
        }

        System.out.println("Array after sorting: ");
        insertionSort(arr);
        for(int i = 0; i<size; i++){
            System.out.print(arr[i] + " ");
        }

        input.close();
    }
}
