import java.util.*;

public class MaxAdjacentWhenKStationsFit{

    // Time Compexity => O((max + min/2 - 0.5 + 1)*n) => Better Approach
    public static float Max(int [] nums){
       int max = nums[0];
       int min = nums[0];

       for(int i = 1; i<nums.length; i++){
           if(nums[i] > max) max = nums[i];
           if(nums[i] < min) min = nums[i];
       }

       return (max + min)/2;
    }

    public static float MaxAdjacentDistance(int [] positions, int k){
       float low = 0.5f;
       float high = Max(positions);

       while(low <= high){
        int sum = positions[0];
        int count = 0;
        for(int i = 1; i<positions.length; i++){
            if((float)sum + low < (float)positions[i]){
               count ++;
            }
            sum = positions[i];
        }

        if(count <= k) return low;

        low = low + 0.5f;
       }

       return -1f;
    }
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

       System.out.print("Enter no. of gas stations: ");
       int gasStations = input.nextInt();

       int [] positions = new int[gasStations];
       for(int i = 0; i<gasStations; i++){
           System.out.print("Enter position of " + (i+1) + " gas station: ");
           positions[i] = input.nextInt();
       }

       System.out.println("Enter extra gas stations you want to add in present stations: ");
       int k = input.nextInt();

       System.out.println("The Maximum Adjacent Distance in between Gas Stations: " + MaxAdjacentDistance(positions, k));

       input.close();
    }
}