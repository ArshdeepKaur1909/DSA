import java.util.*;

public class stringHashingWithHashmap{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter any string: ");
        String str = input.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<str.length(); i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        System.out.println("Character frequencies: " + map);

        input.close();
    }
}