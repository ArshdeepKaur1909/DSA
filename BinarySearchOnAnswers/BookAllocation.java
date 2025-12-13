import java.util.*;

public class BookAllocation {

    // Time Complexity:  O(log(sum-max+1)*n)
    public static int[] MaxAndSum(int [] nums){
       int max = nums[0];
       int sum = nums[0];
       for(int i = 1; i<nums.length; i++){
           if(max < nums[i]) max = nums[i];
           sum += nums[i];
       }

       return new int[]{max, sum};
    }

    public static int countStudents(int [] books, int maxPages){
        int students = 1; 
        int pagesCount = 0;

        for(int i = 0; i<books.length; i++){
            if(pagesCount + books[i] <= maxPages){
                pagesCount += books[i];
            }else{
                students++;
                pagesCount = books[i];
            }
        }

        return students;
    }

    public static int MinimumMaximumPages(int [] books, int students){
        int [] maxAndSum = MaxAndSum(books);

        int low = maxAndSum[0];
        int high = maxAndSum[1];

        while(low <= high){
            int mid = (low + high)/2;

            int student = countStudents(books, mid);
            if(student > students) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
    public static void main(String [] args){
       Scanner input = new Scanner(System.in);

       System.out.println("Enter no. of books you have: ");
       int books = input.nextInt();

       int [] pages = new int[books];
       for(int i = 0; i<books; i++){
          System.out.print("Enter no. of pages in " + (i+1) + " book: ");
          pages[i] = input.nextInt();
       }

       System.out.print("\nEnter no. of students you have to distribute books: ");
       int students = input.nextInt();

       System.out.println("The minimum number of maximum pages that can be allocated to any one student: " + MinimumMaximumPages(pages, students));

       input.close();
    }
}