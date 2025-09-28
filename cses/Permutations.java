//Link to problem: https://cses.fi/problemset/task/1070
// package cses;
import java.io.*;
import java.util.*;

public class Permutations {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> ans = new ArrayList<String>();
        // if n is 2 or 3, the difference will always be 1;
        if (n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
        } else {
            // if all the even number are printed before the odd number, the difference will always be 2
            int value = 2;
            while(value <= n) {
                ans.add(value + "");
                value += 2;
            }

            value = 1;
            while(value <= n) {
                ans.add(value + "");
                value += 2;
            }
            System.out.println(String.join(" ", ans));
        }
    }
}
