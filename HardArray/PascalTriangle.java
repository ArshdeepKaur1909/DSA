import java.util.*;

public class PascalTriangle {
    
    // Only Solution Possible => Time Complexity: O(n^2) Space Complexity: O(1) ignoring output space
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> main = new Vector<>();

        if(numRows == 0){
          Vector<Integer> vec = new Vector<>(1);
          vec.add(1);
          main.add(vec);
          return main;
        }


        for(int i = 0; i<numRows; i++){
            Vector<Integer> vec = new Vector<>(i+1);  

            vec.add(1);

            if(i == 0){
                main.add(vec);
                continue;
            }

            int k = 1;
            while(k <= i-1){
               List<Integer> lastVec = main.get(main.size() - 1); 
               vec.add(lastVec.get(k-1) + lastVec.get(k));
               k++;
            }
            
            vec.add(1);

            main.add(vec);

        }

        return main;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of rows you want of pascal triangle: ");
        int rows = input.nextInt();

        List<List<Integer>> pascalList = generate(rows);

        System.out.println(pascalList);
    }
}
