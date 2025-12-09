import java.util.*;

public class MinDaysToMakeBouquet {

    public static int[] findMinMax(int [] nums){
        int min = nums[0];
        int max = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }else if(nums[i] > max){
                max = nums[i];
            }
        }

        int [] result = {min, max};

        return result;
    }

    public static int bouquetLeft(int [] bloomDays, int m, int k, int min){
        int bouquetLeft = m;
        int fc = 0;

        for(int i = 0; i<bloomDays.length; i++){
           if(bloomDays[i] <= min){
            fc++;
            if(fc == k){ 
                bouquetLeft--;
                fc = 0;
            }
          }else{
            fc = 0;
          }

          if(bouquetLeft == 0){
             return bouquetLeft;
          }
        }

        return bouquetLeft;
    }
    
    // Time Complexity: O(n log(maxDays - minDays + 1))
    public static int minDays(int [] bloomDays, int m, int k){
        long mkp = (long)m * (long)k;
        int n = bloomDays.length;
        if(mkp > n) return -1; 


        int [] maxMin = findMinMax(bloomDays);

        int low = maxMin[0];
        int high = maxMin[1];

        while(low <= high){
           int mid = (low + high)/2;

           int bouquetLeft = bouquetLeft(bloomDays, m, k, mid);
           
           if(bouquetLeft > 0){
              low = mid + 1;
           }else{
              high = mid - 1;
           }
        }


        return low;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of flowers you want in garden: ");
        int flowers = input.nextInt();

        int [] bloomDays = new int[flowers];
        
        for(int i = 0; i<flowers; i++){
            System.out.println("Enter how many days " + (i+1) + " flower will take to bloom: ");
            bloomDays[i] = input.nextInt();
        }

        System.out.println("Enter number of bouquets needed: ");
        int m = input.nextInt();

        System.out.println("Enter number of flowers needed for each bouquet: ");
        int k = input.nextInt();

        System.out.println("Enter the number of minimum days required to make " + m + " bouquets: " + minDays(bloomDays, m, k));

        input.close();
    }
}