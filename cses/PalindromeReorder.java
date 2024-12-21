// Problem link: https://cses.fi/problemset/task/1755
import java.io.PrintWriter;
import java.util.*;


public class PalindromeReorder {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[] chars = new int[26];
        PrintWriter pw = new PrintWriter(System.out);
        int oddInt = 91;
        String n = scnr.next();
        int count = 0;
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            chars[c - 'A']++;
            
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i] % 2 == 1) {
                count++;
                oddInt = i;
            }
        }
        if (count > 1) {
            System.out.println("NO SOLUTION");
        } else {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < chars[i] / 2; j++) {
                    if(chars[i] % 2 == 0) {
                        pw.print((char) (i + 'A'));
                    }
                }
            }
            if (oddInt != 91) {
                for (int j = 0; j < chars[oddInt]; j++) {
                    pw.print((char) (oddInt + 'A'));
                }
                
            }
        
            for (int i = 25; i >= 0; i--) {
                for (int j = 0; j < chars[i] / 2; j++) {
                    if(chars[i] % 2 == 0) {
                        pw.print((char) (i + 'A'));
                    }
                }
            }
        }
        pw.flush();
        pw.close();
        scnr.close();

    }
    
}


