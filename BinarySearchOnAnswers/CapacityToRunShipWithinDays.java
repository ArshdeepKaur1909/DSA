import java.util.*;

public class CapacityToRunShipWithinDays {

   public static int[] findMaxAndSum(int [] nums){
        int max = nums[0];
        int sum = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(nums[i] > max) max = nums[i];
            sum += nums[i];
        }

        return new int[]{max, sum};
   }

   public static boolean canShipWithinDays(int [] weights, int days, int capacity){
        int daystaken = 0;
        int currentLoad = 0;

        for(int i = 0; i < weights.length; i++){
           currentLoad += weights[i];
           if(currentLoad >= capacity){
              daystaken++;
              if(currentLoad == capacity) currentLoad = 0;
              else currentLoad = weights[i];
           }

              if(daystaken >= days && currentLoad != 0) return false;
        }

        return true;
   }

   public static int shipWithinDays(int [] weights, int days){
       int [] minAndMax = findMaxAndSum(weights);

       int low = minAndMax[0];
       int high = minAndMax[1];

       if(days == 1) return high;
       if(days == weights.length) return low;

       while(low <= high){
        int mid = (low + high)/2;

        boolean isShipPossible = canShipWithinDays(weights, days, mid);

        if(isShipPossible){
            high = mid - 1;
        } else {
            low = mid + 1;
        }
       }

       return low;
    } 
   public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of packages present in conveyor belt: ");
        int packages = input.nextInt();

        int [] weights = new int[packages];
        for(int i  = 0; i<packages; i++){
           System.out.print("Enter weight of " + (i+1) + " package: ");
           weights[i] = input.nextInt();
        }

        System.out.println("The number of days within you want to ship all packages: ");
        int days = input.nextInt();

        System.out.println("The minimum capacity of ship required to ship all packages within " + days + " days is: " + shipWithinDays(weights, days));

        input.close();
   }
}