import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    //all prime numbers square.and that will help to find square free number 
//upto 19 square according to input
    static int array[] = {4, 9, 25, 49, 121, 169, 289, 361, 529, 841, 961, 1369, 1681, 1849, 4879681, 7890481, 12117361, 13845841, 25411681};

      // function which will return 1 if factors of number is square free and 0 if they are not.
   static int perfectsquare(int n) {
        for (int i = 0; i < array.length; i++) {
            if (n % array[i] == 0) {
                return 0;
            }
            if (n < array[i]) {
                break;
            }
        }
        return 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int count = 0;
        if (num == 1)    //base case . 
       {
            System.out.println(0);
            System.exit(0);
        }





//finding the facotrs of a given numbers
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    count += perfectsquare(i);
                } else {
                    count += perfectsquare(i);
                    count += perfectsquare(num / i);
                }
            }        }
        count += perfectsquare(num);
        System.out.print(count); //printing number 
    }
}
