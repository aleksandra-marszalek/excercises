import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

        static int B;
        static int H;
        static boolean flag;


        static{
            Scanner scan = new Scanner(System.in);
            B = scan.nextInt();
            scan.nextLine();
            H = scan.nextInt();
            scan.close();
            if (B <= 0 || H <= 0){
                flag = false;
                System.out.println("java.lang.Exception: Breadth and height must be positive");
            } else {
                flag = true;
            }
        }


        public static void main(String[] args){
            if(flag){
                int area=B*H;
                System.out.println("I'm here'");
                System.out.print(area);
            }

        }//end of main
    //end of class
}
