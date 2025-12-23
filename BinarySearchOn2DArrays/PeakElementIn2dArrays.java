import java.util.*;

public class PeakElementIn2dArrays {

    //A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom
    public static int maxElement(int [][] grid, int col){
       int maxRow = 0;
       int max = grid[maxRow][col];

       for(int i = 1; i<grid.length; i++){
           if(grid[i][col] > max){
            maxRow = i;
            max = grid[maxRow][col];
           }
       }

       return maxRow;
    }
    
    public static int[] findPeakGrid(int [][] grid){
        int columns = grid[0].length;

        int low = 0;
        int high = columns - 1;

        while(low <= high){
           int midCol = (low + high)/2;
           int maxRow = maxElement(grid, midCol);

           int left = midCol > 0 ? grid[maxRow][midCol - 1] : -1;
           int right = midCol < columns-1 ? grid[maxRow][midCol + 1] : -1;

           if(left < grid[maxRow][midCol] && grid[maxRow][midCol] > right){
              return new int[]{maxRow, midCol};
           }else if(left > grid[maxRow][midCol]){
            high = midCol - 1;
           }else{
            low = midCol + 1;
           }
        }

        return new int[]{-1, -1};
    }
    public static void main(String [] args){
      Scanner input = new Scanner(System.in);

      System.out.println("Enter no. of rows in a matrix: ");
      int rows = input.nextInt();

      System.out.println("Enter no. of columns in a matrix: ");
      int columns = input.nextInt();

      int [][] matrix = new int[rows][columns];

      for(int i = 0; i<matrix.length; i++){
        System.out.println("Enter elements for " + (i+1) + " row: ");
        for(int j = 0; j<matrix[i].length; j++){
            matrix[i][j] = input.nextInt();
        }
      }

      System.out.println("The index of peak element is: " + Arrays.toString(findPeakGrid(matrix)));

      input.close();
    }
}
