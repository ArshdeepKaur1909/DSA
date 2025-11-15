import java.util.*;

public class RotateMatrixBy90{ 
    
    // Optimal Approach => In this we first take transpose of Matrix and then reverse each row of Matrix.
    public static void rotateMatrixBy90(int [][] matrix){
       
        for(int i = 0; i<matrix.length; i++){
              for(int j = i; j<matrix[0].length; j++){
                    // Taking Transpose of Matrix
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
              }
       }

       // Reversing each row of Matrix
       for(int i = 0; i<matrix.length; i++){
          for(int j = 0; j<=matrix[0].length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-j-1];
                matrix[i][matrix[0].length-j-1] = temp;
          }
       }
    }
    public static void main(String [] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter number of rows and columns for a square matrix: ");
        int n = input.nextInt();

        int [][] matrix = new int[n][n];

        for(int i = 0; i<n;  i++){
            System.out.println("Enter elements for " + (i+1) + " row: ");
            for(int j = 0; j<n; j++){
                matrix[i][j] = input.nextInt();
            }
        }

        input.close();
    }
}