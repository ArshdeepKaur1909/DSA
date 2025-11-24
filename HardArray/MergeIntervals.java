import java.util.*;

public class MergeIntervals{

    //Brute Approach => Time Complexity = O(2n) and Space Complexity = O(n)

    // Optimal Approach => Time Complexity = O(n) and Space Complexity = O(n)
    public static List<List<Integer>> mergeIntervals(int [][] intervals){
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int n = intervals.length;
        int i = 0;

        while(i < n){
            int start = intervals[i][0]; // start is new interval's first element
            int end = intervals[i][1];   // end is new intervals second element

            int j = i+1;
            while(j<n && end >= intervals[j][0]){
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            
            // As soon as next interval's start gets larger than last interval's end
            ans.add(Arrays.asList(start, end));
            
            // Assigning that j value to i for which jth loop gets break
            i = j;

        }

        return ans;
    }
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

       System.out.println("Enter size for Array which will be storing intervals as array: ");
       int size = input.nextInt();

       int [][] matrix = new int[size][2];

       for(int i = 0; i<size; i++){
        System.out.println("Enter 2 elements for " + (i+1) + " interval: ");
        for(int j = 0; j<2; j++){
            matrix[i][j] = input.nextInt();
        }
       }

       System.out.println("Interval Array after merging overlapping intervals: " + mergeIntervals(matrix));

       input.close();
    }
}