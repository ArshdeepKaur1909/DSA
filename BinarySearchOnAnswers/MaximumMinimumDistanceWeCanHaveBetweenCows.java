import java.util.*;

public class MaximumMinimumDistanceWeCanHaveBetweenCows {
    
    public static boolean isMaxAdjacent(int [] stalls, int cows, int distance){
       int last = stalls[0];
       int cowsCount = 1;

       for(int i = 1; i<stalls.length; i++){
          if(stalls[i]-last >= distance){
            last = stalls[i];
            cowsCount++;
        }

        if(cowsCount == cows) return true;
       }
       
       return false;
    }

    public static int MaxAdjacentDistanceIs(int [] stalls, int cows){
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        if(cows == 2) return high;

        while(low <= high){
           int mid = (low + high)/2;

           boolean MaxAdjacent = isMaxAdjacent(stalls, cows, mid);

           if(MaxAdjacent){
            low = mid + 1;
           }else{
            high = mid - 1;
           }
        }

        return high;
    }
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

       System.out.println("Enter number of stalls you want: ");
       int stalls = input.nextInt();

       int [] stallPositions = new int[stalls];
       for(int i = 0; i<stalls; i++){
          System.out.print("Enter position of stall " + (i+1) + " : "); 
          stallPositions[i] = input.nextInt();
       }

       System.out.print("Enter number of cows want to place: ");
       int cows = input.nextInt();

       System.out.println("Maximum Distance possible in between two cows is : " + MaxAdjacentDistanceIs(stallPositions, cows));

       input.close();
    }
}
