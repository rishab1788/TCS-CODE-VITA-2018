
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

   int n=scan.nextInt();
        System.out.print("{");

        for (int i=1;i<n;i++)
   {if ((i)*(i+1)/2==n) {
       for (int j=1;j<=i;j++)
       {
      if (j!=i) {
          System.out.print(j + ",");
      }
      else System.out.print(j);
       }

   }
    }
        System.out.print("}");

}
}

