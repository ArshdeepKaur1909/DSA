import java.util.*;

public class PrintSumUptoN{
    public static int sum(int n){
       if(n == 1) return 1;
       return n + sum(n-1); // just replacing + with * will give factorial of initial passed number as n
    }
    public static void main(String [] args){
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter upto which you want sum of natural numbers: ");
      int n = input.nextInt();

      System.out.println("Sum upto n natural numbers: " + sum(n));

      input.close();
    }
}