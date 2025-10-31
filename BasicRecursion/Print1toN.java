import java.util.*;
public class Print1toN{
    public static void print1toN(int n){
      if(n < 1) return;

      print1toN(n-1);
      System.out.println(n);
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter upto which you want natural numbers: ");
        int num = input.nextInt();
        
        print1toN(num);

        input.close();
    }
}