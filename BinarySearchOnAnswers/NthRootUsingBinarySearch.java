import java.util.*;

public class NthRootUsingBinarySearch {
    // function for calculating value for mid raise to power n
    public static int power(int mid, int m, int n){
        int ans = 1;
        for(int i = 1; i<=n; i++){
            ans = ans*mid;
            if(ans > m){
              return -1;
            }
        }

        if(ans == m) return 0;
        return 1;
    }  
    
    // The nth root of a number M is defined as a number X when raised to the power N equals M.
    public static int NthRoot(int m, int n){
        if(n == 1) return m;
        if(m == 0 || m == 1) return m;

        int low = 1;
        int high = m;
        while(low <= high){
           int mid = (low + high)/2;

           if(power(mid, m, n) == 0){
            return mid;
           }else{
                if(power(mid, m, n) == -1){
                  high = mid - 1; 
                }else{
                  low = mid + 1;  
                }
           }
        }

        return -1;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter any number whom you want to find the nth root of: ");
        int m = input.nextInt();

        System.out.println("Enter the value of n: ");
        int n = input.nextInt();

        System.out.println("The Nth root of inputed number: " + NthRoot(m, n));
        input.close();
    }
}
