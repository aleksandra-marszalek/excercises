import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //get n
        int[] A = new int[n]; //create A

        for (int x = 0; x < n; x++) {
            A[x] = scanner.nextInt(); //fill A
        }

        int negCount = 0; //Negative Array count
        int arrLen; //Array Length
        int sum; //Array Sum

        for (int i = 0; i < n; i++){ //i is starting pos in array
            sum = 0;
            for (int j = i; j < n; j++){
                sum += A[j];


                if (sum < 0) {
                    negCount++;
                }
            }
        }

        System.out.println(negCount);

    }
}

