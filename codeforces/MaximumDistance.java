// Problem link: https://codeforces.com/gym/102951/problem/A
package codeforces;
import java.io.*;
import java.util.*;
public class MaximumDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfIntPoints = Integer.parseInt(br.readLine());
        int[] x = new int[numOfIntPoints];
        int[] y = new int[numOfIntPoints];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfIntPoints; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < numOfIntPoints; j++) {
            y[j] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int n = 0; n < numOfIntPoints; n++) {
            for (int m = n + 1; m < numOfIntPoints; m++) {
                int dx = x[m] - x[n];
                int dy = y[m] - y[n];
                int square = dx * dx + dy * dy;
                max = Math.max(max, square);
            }
        }
        System.out.println(max);
        br.close();


    }
}
