import java.util.*;

public class LongestSubstringwithoutRepeatingCharacters {
    
    
    // Brute Force Approach --> Time Complexity: O(n^2)
    public static int lengthOfLongestSubstring(String s){  
       HashSet<Character>  set = new HashSet<>();
       
       int longestLength = 0;
       for(int i = 0; i<s.length(); i++){
        for(int j = i; j<s.length(); j++){
            if(set.contains(s.charAt(j))){
                set.clear();
                break;
            }
            longestLength = Math.max(longestLength, j-i+1);
            set.add(s.charAt(j));
        }
       }

         return longestLength;
    }

    // Optimal Approach
    // public static int lengthOfLongestSubstring(String s){
    //    int l, r, longestLength;
    //    l = r = longestLength = 0;

       
    // }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter any string: ");
        String s = input.nextLine();

        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s));

        input.close();
    }
}
