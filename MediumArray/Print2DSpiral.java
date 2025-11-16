import java.util.*;

public class Print2DSpiral{
    
    //Only solution => Optimal Approach => Time Complexity = O(n*m) and Space Complexity = O(1)
    public static List<Integer> print2DSpiral(int [][] matrix){
       Vector<Integer> list = new Vector<>();
       
       int rows = matrix.length;
       int cols = matrix[0].length;

       int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
       
       while(left <= right && top <= bottom){
       for(int i = left; i<=right; i++){
           list.add(matrix[top][i]);
       }

       top++;

       for(int i = top; i<=bottom; i++){
          list.add(matrix[i][right]);
       }

       right--;

       for(int i = right; i>=left; i--){
          list.add(matrix[bottom][i]);
       }

       bottom--;

       for(int i = bottom; i>=top; i--){
            list.add(matrix[i][left]);
       }
       
       left++;

    }

    return list;

    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.println("Enter number of columns: ");
        int cols = input.nextInt();

        int [][] matrix = new int[rows][cols];

        for(int i = 0; i<rows; i++){
            System.out.println("Enter elements for row " + (i+1) + ": ");
            for(int j = 0; j<cols; j++){
                matrix[i][j] = input.nextInt();
            }
        }

        input.close();
    }
}