import java.util.*;

class ArmstrongNumber{
    
    public static boolean isArmstrong(int num){
        if (num <= 0) return false;
        
        int originalNum = num;
        int sum = 0;
        int digits = (int) Math.log10(num) + 1; // Calculate number of digits

        while(num > 0){
            int digit = num % 10;
            sum += Math.pow(digit, digits); // Raise digit to the power of number of digits
            num /= 10;
        }

        return sum == originalNum;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        sc.close();

        System.out.println("The number is " + (isArmstrong(num) ? "" : "not ") + "an Armstrong number.");
    }
}