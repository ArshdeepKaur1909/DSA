import java.util.*;

public class KokoEatingBananas{

    // Time Complexity: O(n log(max - avg)) where n is the number of piles and m is the maximum number of bananas in a pile
    public static int[] maxAndAvg(int [] piles, int h){
        int [] maxAvg = new int[2];

        maxAvg[0] = piles[0];
        long sum = 0;

        for(int i = 0; i<piles.length; i++){
            if(piles[i] > maxAvg[0]) maxAvg[0] = piles[i];
            sum += piles[i];
        }

        maxAvg[1] = (int)Math.ceilDiv(sum, (long)h);

        return maxAvg;
    }

    public static int findHours(int [] piles, int mid){
        int totalHours = 0;

        for(int i = 0; i<piles.length; i++){
            totalHours += Math.ceilDiv(piles[i], mid);
        }

        return totalHours;
    }
    
    public static int minEatingSpeed(int [] piles, int h){
        int [] maxAvg = maxAndAvg(piles, h);
        
        int max = maxAvg[0];
        int avg = maxAvg[1];

        int low = Math.max(1, avg);
        int high = max;

        while(low <= high){
            int mid = (low + high) / 2;
            int totalHours = findHours(piles, mid);

            if(totalHours <= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of piles: ");
        int pilesTotal = input.nextInt();

        int [] piles = new int[pilesTotal];
        for(int i = 0; i<pilesTotal; i++){
            System.out.print("Enter number of bananas you want in " + (i+1) + " pile: ");
            piles[i] = input.nextInt();
            System.out.println();
        }

        System.out.println("Enter number of hours you want Koko to finish all bananas: ");
        int h = input.nextInt();

        System.out.println("The Minimum Bananas Koko must eat per hour to finish all: " + minEatingSpeed(piles, h));

        input.close();
    }
}