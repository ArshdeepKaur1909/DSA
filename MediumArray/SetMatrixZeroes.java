import java.util.*;

public class SetMatrixZeroes {
    
    // Optimal Approach Time complexity: O(m*n) where m is number of rows and n is number of columns and Space complexity: O(1)
     public static void setMatrixZeroes(int[][] matrix) {
        int col0 = 1;

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;

                    if(j != 0) matrix[0][j] = 0;
                    else col0 = 0;
                }
            }
        }

        for(int i = 1; i<matrix.length; i++){
            for(int j = 1; j<matrix[i].length; j++){
                if(matrix[i][0]  == 0 || matrix[0][j] == 0){ 
                    matrix[i][j] = 0;
                }    
            }
        }

        if(matrix[0][0] == 0){
            for(int j = 1; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0){
            for(int i = 0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
    
    
    // Better Approach
    // Time complexity: O(2(m*n)) where m is number of rows and n is number of columns
    // Space complexity: O(m + n)
    /* public static void setMatrixZeroes(int [][] matrix){
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> column = new HashSet<>();

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for(int i = 0; i<matrix.length; i++){
            if(row.contains(i) == true ){
                for(int j = 0; j<matrix[i].length; j++){
                    matrix[i][j] = 0;
                }
            }else{
            for(int j = 0; j<matrix[i].length; j++){
                if(column.contains(j) == true){
                    matrix[i][j] = 0;
                }
            }
         }
        }
    } */
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.println("Enter number of columns: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];

        for(int i = 0; i < matrix.length; i++){
            System.out.println("Enter elements for row " + (i+1) + ": ");
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = input.nextInt();
            }
        }

        setMatrixZeroes(matrix);
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        input.close();
    }
}