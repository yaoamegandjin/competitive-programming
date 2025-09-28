// Problem link: https://open.kattis.com/problems/simpleaddition

import java.math.BigInteger;
import java.util.Scanner;

public class simpleaddition {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        BigInteger A = new BigInteger(scnr.nextLine());
        System.out.println(A.add(new BigInteger(scnr.nextLine())));
        scnr.close();
    }
}
