import java.util.*;

public class StringPallindrome {
    public static boolean isPallindrome(String S, int start, int end){
        if(start >= end) return true;
        if(S.charAt(start) == S.charAt(end)){
            return isPallindrome(S, start+1, end-1);
        }

        return false;
    }

    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

       System.out.println("Enter a string: ");
       String S = input.nextLine();

       input.close();

       System.out.println( "The string is Pallindrome: " + isPallindrome(S, 0, S.length()-1) );
    }
}
