import java.util.*;

public class PaintersPartition{

    public static int[] maxandsum(int [] nums){
       int max = nums[0];
       int sum = nums[0];

       for(int i = 1; i<nums.length; i++){
           if(nums[i] > max) max = nums[i];
           sum += nums[i];
       }

       return new int[]{max, sum};
    }

    public static int countPainters(int [] boards, int min){
        int painters = 1;
        int time = 0;
        
        for(int i = 0; i<boards.length; i++){
            if(time + boards[i] <= min){
                time += boards[i];
            }else{
                painters++;
                time = boards[i];
            }
        }

        return painters;
    }

    public static int minTimeByPainters(int [] boards, int painters){
        int [] maxAndSum = maxandsum(boards);

        if(painters == 1) return maxAndSum[1];
        if(painters == boards.length) return maxAndSum[0];

        int low = maxAndSum[0];
        int high = maxAndSum[1];

        while(low <= high){
           int mid = (low + high)/2;

           int count = countPainters(boards, mid);

           if(count > painters) low = mid + 1;
           else high = mid - 1;
        }

        return low;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter no. of boards: ");
        int num = input.nextInt();

        int [] boards = new int[num];
        for(int i = 0; i<num; i++){
            System.out.print("Enter length for " + (i+1) + " board: ");
            boards[i] = input.nextInt();
        }

        System.out.println("Enter no. of painters you have in order to paint all boards: ");
        int painters = input.nextInt();

        System.out.println("The minimum time required by " + painters + " painters is: " + minTimeByPainters(boards, painters));

        input.close();
    }
}