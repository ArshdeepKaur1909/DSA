import java.util.*;

public class ReverseArray{
    public static void reverseArray(int [] arr, int start, int end){
        if(start == end || start > end) return;
        int temp =  arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArray(arr, start+1, end-1);
    }

    public static void main(String [] args){
       Scanner input = new Scanner(System.in); 

       System.out.print("Enter the size of the array: ");
       int n = input.nextInt();
       int [] arr = new int[n];

       System.out.println("Enter the elements of the array: ");
       for(int i = 0; i < n; i++){
              arr[i] = input.nextInt();
       }
       
       reverseArray(arr, 0, n-1);
       
       //Arrays Object method i.e. Arrays.toString() returns the string representation of the array

       System.out.println("Reversed array: " + Arrays.toString(arr));
       input.close();
    }
}