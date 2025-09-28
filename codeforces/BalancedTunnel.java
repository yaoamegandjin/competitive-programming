// Problem link: https://codeforces.com/problemset/problem/1237/B

package codeforces;

import java.io.*;
import java.util.*;
public class BalancedTunnel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfCars = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> enterOrder = new ArrayList<>();
        ArrayList<Integer> exitOrder = new ArrayList<>();
        ArrayList<Integer> exitTimes = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < numOfCars; i++) {
            enterOrder.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < numOfCars; j++) {
            exitOrder.add(Integer.parseInt(st.nextToken()));
        }
        for(int j = 0; j < numOfCars; j++) {
            exitTimes.add(0);
        }

        for (int i = 0; i < numOfCars; i++) {
            for (int j = 0; j < numOfCars; j++) {
                if (enterOrder.get(i) == exitOrder.get(j)) {
                    exitTimes.set(i, j);
                }
            }
        }

        for (int i = numOfCars - 1; i >= 0; i--) {
            if (i > 0) {
            ArrayList<Integer> list = new ArrayList<>(exitTimes.subList(0, i));
            if (exitTimes.get(i) < Collections.max(list)) {
                count += 1;
            }
            }
        }
        System.out.println(count);
    }
}
