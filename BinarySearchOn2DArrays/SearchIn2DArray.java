import java.util.*;
public class SearchIn2DArray {

    //Optimal Approach => Time Complexity => O(log(m*n)) and Space Complexity => O(1)
    // Approach => Converting 2D Matrix into 1D Matrix and searching for target as per Binary Search Approach 
    public static boolean searchMatrix(int [][] matrix, int target){
        int row = matrix.length;
        int column = matrix[0].length;

        int low = 0;
        int high = (row*column) - 1;

        while(low <= high){
            int mid = (low + high)/2;

            // Formula for converting 1D Array Index to Matrix Co-ordinates
            int r = mid/column;
            int c = mid%column;

            if(matrix[r][c] == target) return true;

            if(matrix[r][c] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return false;
    }

    // Better Approach => Time Complexity => O(n) + O(logm) and Space Complexity => O(1)
    /* public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        for(int i = 0; i<rows; i++){
            if(matrix[i][0] <= target && target <= matrix[i][columns - 1]){
                int low = 0;
                int high = columns - 1;

                while(low <= high){
                    int mid = (low + high)/2;

                    if(matrix[i][mid] == target) return true;

                    if(matrix[i][mid] > target){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }
            }
        }
        return false;
    } */
    public static void main(String [] args){
      Scanner input = new Scanner(System.in);

      System.out.println("Enter no. of rows in a matrix: ");
      int rows = input.nextInt();

      System.out.println("Enter no. of columns in a matrix: ");
      int columns = input.nextInt();

      int [][] matrix = new int[rows][columns];

      for(int i = 0; i<matrix.length; i++){
        System.out.println("Enter elements for " + (i+1) + " row in sorted fashion: ");
        for(int j = 0; j<matrix[i].length; j++){
            matrix[i][j] = input.nextInt();
        }
      }

      System.out.println("Enter a target: ");
      int target = input.nextInt();

      System.out.println("Inputed Target is there in matrix: " + searchMatrix(matrix, target));

      input.close();
    }
}