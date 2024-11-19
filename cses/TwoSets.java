//Link to problem: https://cses.fi/problemset/task/1092

import java.util.*;
import java.io.*;

public class TwoSets {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        long n = scnr.nextLong();
        ArrayList<Long> firstSet = new ArrayList<>();
        ArrayList<Long> secondSet = new ArrayList<>();
        PrintWriter pw = new PrintWriter(System.out);
        long sumOfNums = (n * (n + 1))/ 2;
        if (sumOfNums % 2 == 0) {
            pw.println("YES");
            if (n % 2 == 0) {
                for(long i = 0; i < n / 2; i++) {
                    if (i % 2 == 0) {
                        firstSet.add(i + 1);
                        firstSet.add(n - i);
                    } else {
                        secondSet.add(i + 1);
                        secondSet.add(n - i);
                    }
                }
            } else {
                for(long i = 0; i < (n - 1) / 2; i++) {
                    if (i % 2 == 0) {
                        firstSet.add(i + 1);
                        firstSet.add(n - i - 1);
                    } else {
                        secondSet.add(i + 1);
                        secondSet.add(n - i - 1);
                    }
                }
                if (firstSet.size() > secondSet.size()) {
                    secondSet.add(n);
                } else {
                    firstSet.add(n);
                }
            }
            pw.println(firstSet.size());
            for(int i = 0; i < firstSet.size(); i++) {
                pw.print(firstSet.get(i) + " ");
            }
            pw.println();
            pw.println(secondSet.size());
            for(int i = 0; i < secondSet.size(); i++) {
                pw.print(secondSet.get(i) + " ");
            }
            pw.println();
        } else {
            pw.println("NO");
        }
        pw.flush();
        pw.close();
        scnr.close();

    }
}
