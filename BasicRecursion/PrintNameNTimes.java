import java.util.*;

public class PrintNameNTimes{
    public static void printname(String name, int n){
       if(n == 0){
        return;
       } 

         System.out.println(name);
         printname(name, n-1);
    }
    public static void main(String [] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your name and tell how many times want to print: ");
    String name = input.nextLine();
    int n  = input.nextInt();
    
    printname(name, n);
    
    input.close();
  }
}