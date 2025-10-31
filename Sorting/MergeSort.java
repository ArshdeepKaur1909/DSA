import java.util.*;

// Timme Complexity at Best, Average and Worst Case: O(n log (with base 2) n)
// Space Complexity: O(n)
public class MergeSort {
  
    public static void merge(int [] arr, int low, int mid, int high){
        int [] merged = new int[(high - low + 1)];
        int i = low;
        int j = mid + 1;
        
        for(int k = 0; k<merged.length; k++){
            if(i<=mid && j<=high){
                if(arr[i] <= arr[j]){
                    merged[k] = arr[i];
                    i++;
                }else{
                    merged[k] = arr[j];
                    j++;    
                }
            }else{
                if(i == arr.length){
                    merged[k] = arr[j];
                    j++;   
            }else{
                    merged[k] = arr[i];
                    i++;    
                }
            }
        }

        // Copying elements of merged array to original array
        for(int k = 0; k<merged.length; k++){
            arr[low + k] = merged[k];
        }
    }

    // public static int[] merge(int [] arr, int low, int mid, int high){
    //     int [] merged = new int[(high - low + 1)];
    //     int i = 0;
    //     int j = mid + 1;
        
    //     for(int k = 0; k<merged.length; k++){
    //         if(i<=mid && j<=high){
    //             if(arr[i] <= arr[j]){
    //                 merged[k] = arr[i];
    //                 i++;
    //             }else{
    //                 merged[k] = arr[j];
    //                 j++;    
    //             }
    //         }else{
    //             if(i == arr.length){
    //                 merged[k] = arr[j];
    //                 j++;   
    //         }else{
    //                 merged[k] = arr[i];
    //                 i++;    
    //             }
    //         }
    //     }

    //     return merged; // will return created array memory reference
        
    // } 

    public static void mergeSort(int [] arr, int low, int high){
        if(low >= high){
            return;
        }
        
        int mid = (high + low)/2;
        mergeSort(arr, low, mid);       
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
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


        // System.out.println(merge(arr, arr2)); // will print address of merged array
        // System.out.println(Arrays.toString(merge(arr, arr2))); // By using Arrays.toString() we can print elements of array

        System.out.println("Array after sorting: ");
        
        mergeSort(arr, 0, size-1);
        for(int i = 0; i<size; i++){
            System.out.print(arr[i] + " ");
        }

        input.close();
    }
}