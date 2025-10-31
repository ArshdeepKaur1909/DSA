import java.util.*;

// We have to tell frquency of each inputed character in string
class hashingOfstring{
  public static void main(String [] args){
    Scanner input = new Scanner(System.in);

    System.out.println("Enter a string: ");
    String str = input.nextLine();
     
    //initiating a hash array assuming all characters in inputed string will be lowercase
    int [] hash = new int[26];
    for(int i = 0; i<str.length(); i++){
        hash[str.charAt(i) - 'a']++;
    }

    System.out.println("Enter number of charaters you want to check frequency of: ");
    int q = input.nextInt();
    while(q-- > 0){
        System.out.println("Enter a character: ");
        char ch = input.next().charAt(0);
        System.out.println("Frequency of " + ch + " is: " + hash[ch - 'a']);
    }
    input.close();
  }  
}