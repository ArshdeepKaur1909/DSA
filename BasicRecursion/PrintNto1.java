import java.util.Scanner;

public class PrintNto1 {
    public static void printNto1(int n){
      if(n < 1) return;
      
      System.out.println(n);
      printNto1(n-1);
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter upto which you want natural numbers in reverse: ");
        int num = input.nextInt();
        
        printNto1(num);

        input.close();
    }
}
