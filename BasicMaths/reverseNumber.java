import java.util.*;

public class reverseNumber {
  public static int reverse(int number){
    int reverse = 0;
    while(number > 0){
        if((reverse == 0) && (number%10 == 0)){
            number = number/10;
            continue;
        }
        reverse = reverse*10 + number%10;
        number = number/10;
    }

    return reverse;
  }
  
  public static boolean isPallindrome(int number){
    return number == reverse(number);
  }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
    
        int reversedNumber = reverse(number);
        System.out.println("Reversed Number is: " + reversedNumber);
        System.out.println("Is Pallindrome: " + isPallindrome(number));
        
        input.close();
    }
}
