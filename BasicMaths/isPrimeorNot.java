import java.util.*;

class isPrimeorNot {

    public static boolean isPrime(int number){
    for(int i = 2; i<=Math.sqrt(number); i++){
        if(number % i == 0){
            return false;
        }
    }
    return true;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        sc.close();
        
        if(number <= 1){
            System.out.println("Not a prime number");
            return;
        }
        boolean result = isPrime(number);
        if(result){
            System.out.println("Prime number");
        } else {
            System.out.println("Not a prime number");
        }
    }
}