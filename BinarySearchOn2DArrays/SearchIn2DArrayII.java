import java.util.*;

//Matrix has the following properties: Integers in each row are sorted in ascending from left to right and Integers in each column are sorted in ascending from top to bottom.
public class SearchIn2DArrayII {

    // Optimal Approach: Time Complexity: O(n + m) and Space Complexity: O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(row < matrix.length && col >= 0){
        if(matrix[row][col] == target) return true;

        if(matrix[row][col] > target){
            col--;
        }else{
            row++;
        }
      }

      return false;
    }
    
    //Better Approach: Time Complexity: O(n*log(m)) and Space Complexity: O(1)
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
