import java.util.*;

public class FindSqrt{
    
    public static int sqrt(int num){
        if(num == 0 || num == 1){
            return num;
        }

        int low = 1;
        int high = num;

        while(low <= high){
            int mid = (low + high)/2;

            if(mid*mid == num) return mid;

            else if((low == mid || mid == high) && mid*mid > num) return mid - 1;

            else if((low == mid || mid == high) && mid*mid < num) return mid;

            else{
                if(mid*mid > num){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a non-negative integer to find its square root");
        int n = input.nextInt();

        System.out.println("The square root of inputed number: " + sqrt(n));

        input.close();
    }
}