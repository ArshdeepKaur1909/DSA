import java.util.*;

// A Matrix of zeroes and ones is given and in each row zeroes and ones are placed in sorted manner and we have to find that row with smallest index with maximum number of ones.
public class CountOneInMatrixOfOneZeroes{

    // Optimal Approach => Time Complexity => O(rows.log(columns)) and Space Complexity => O(1)
    public static int RowWithMaximumOne(int [][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int maxCount = 0;
        int row = -1;

        for(int i = 0; i<rows; i++){
            int low = 0;
            int high = columns-1;
            int count = 0;

            while(low <= high){
               int mid = (low+high)/2;

               if(matrix[i][mid] == 1){
                  count += high - mid + 1;
                  high = mid - 1;
               }else{
                  low = mid + 1;
               }
            }

            if(count == columns) return i;
            if(count > maxCount){
              maxCount = Math.max(maxCount, count);
              row = i;
            }
        } 

        return row;
    }
    public static void main(String [] args){
      Scanner input = new Scanner(System.in);

      System.out.println("Enter no. of rows in a matrix: ");
      int rows = input.nextInt();

      System.out.println("Enter no. of columns in a matrix: ");
      int columns = input.nextInt();

      int [][] matrix = new int[rows][columns];

      for(int i = 0; i<matrix.length; i++){
        System.out.println("Enter elements for " + (i+1) + " row, only 0's and 1's: ");
        for(int j = 0; j<matrix[i].length; j++){
            matrix[i][j] = input.nextInt();
        }
      }

      System.out.println("The smallest index of row having maximum number of one's: " + RowWithMaximumOne(matrix));

      input.close();
    }
}