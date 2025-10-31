import java.util.*;

public class CountDigits {
    public static int countDigits(int num){
        if(num == 0) return 1;
        if(num < 0) num = -num; // Make num positive if it's negative
        return (int)(Math.log10(num)) + 1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        int digitCount = countDigits(num);
        System.out.println("Number of digits in " + num + " is: " + digitCount);
        sc.close();
    }
}