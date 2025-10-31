import java.util.*;

public class PrintAllDivisors {
    
    // Approach 1
    public static HashSet<Integer> allDivisors(int n){
        HashSet<Integer> set = new HashSet<>();
        
        set.add(1);
        if (n != 1) set.add(n);

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                set.add(i);
                if(n%i != i){
                    set.add(n/i);
                }
            }
        }
        return set;
    }

    // Approach 2
    // public static HashSet<Integer> allDivisors(int n){
    //     HashSet<Integer> set = new HashSet<>();
    //     if (n <= 0) return set;

    //     set.add(1);
    //     if (n != 1) set.add(n);

    //     for(int i = 2; i <= n/2; i++){
    //         if(n % i == 0){
    //             set.add(i);
    //         }
    //     }
    //     return set;
    // }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
        } else {
            HashSet<Integer> divisors = allDivisors(n);
            System.out.println("Divisors of " + n + ": " + divisors);
        }

        sc.close();
    }
}
