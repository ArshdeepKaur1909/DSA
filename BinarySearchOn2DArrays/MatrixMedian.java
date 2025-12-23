import java.util.*;

public class MatrixMedian {

    public static int min(int [][] matrix){
    // Matrix have sorted rows so its clear minimum element will be in first column
       int min = matrix[0][0];
       for(int i = 1; i<matrix.length; i++){
           if(matrix[i][0] < min) min = matrix[i][0];
       }

       return min;
    }

    public static int max(int [][] matrix){
    // Matrix have sorted rows so its clear minimum element will be in first column
       int max = matrix[0][matrix[0].length-1];
       for(int i = 1; i<matrix.length; i++){
           if(matrix[i][matrix[0].length-1] > max) max = matrix[i][matrix[0].length-1];
       }

       return max;
    }

    public static int upperbound(int [] nums, int val){
      // return the index of first occuring greater element from val
      int low = 0;
      int high = nums.length-1;

      while(low <= high){
        int mid = (low + high)/2;

        if(nums[mid] <= val){
            low = mid + 1;
        }else {
            high = mid - 1;
        }    
      }

      return low;
    }

    public static int smallandequal(int [][] matrix, int value){
       int count = 0;
       for(int i = 0; i<matrix.length; i++){
           count += upperbound(matrix[i], value);
       }

       return count;
    }

    public static int matrixMedian(int [][] matrix){
       int low = min(matrix); //O(rows)
       int high = max(matrix); //O(rows)

       int rows = matrix.length;
       int cols = matrix[0].length;

       while(low <= high){
          int mid = (low + high)/2; // For this value => which we consider as median, we will check whether it has smaller and equal elements > (rows*col)/2
          int checkEle = smallandequal(matrix, mid);

          if(checkEle > (rows*cols)/2){
            high = mid - 1;
          }else{
            low = mid + 1;
          }
       }

       return low;
    }
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);
       // even*even = even, odd*odd = odd, odd*even = even

       System.out.println("Enter odd no. of rows: ");
       int rows = input.nextInt();

       System.out.println("Enter odd no. of columns: ");
       int columns = input.nextInt();

       int [][] matrix = new int[rows][columns];
       for(int i = 0; i<rows; i++){
        System.out.println("Enter " + (columns) + " elements for row " + (i+1) + " in sorted fashion: ");
        for(int j = 0; j<columns; j++){
            matrix[i][j] = input.nextInt();     
        }
       }

       System.out.println("The Median of matrix: " + matrixMedian(matrix));
       input.close();
    }
}