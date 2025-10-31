import java.util.*;

class GCD {

// Euclidean Algorithm --> O(log(min(a, b)))
  public static int gcd(int a, int b){
    if(b > a){
        return gcd(b, a);
    }
    if(b == 0){
        return a;
    }
    return gcd(b, a%b);
  }

// Brute Force Approach --> O(min(a, b))
//   public static int gcd(int a, int b){
//     int n = Math.min(a, b);
//     int gcd = 1;
//     for(int i = n; i>1; i--){
//         if(a%i == 0 && b%i == 0){
//             return i;
//         }
//     }
//     return gcd;
//   }
  public static void main(String [] args){
    Scanner input  = new Scanner (System.in);

    System.out.print("Enter first number: ");
    int a = input.nextInt();

    System.out.print("Enter second number: ");
    int b = input.nextInt();
    
    input.close();

    System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
  }  
}
