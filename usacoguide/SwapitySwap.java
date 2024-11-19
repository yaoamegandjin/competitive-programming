// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=1013
package usacoguide;
import java.io.*;
import java.util.*;

public class SwapitySwap {
    public static void reverseSegment(ArrayList<Integer> c, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = c.get(startIndex);
            c.set(startIndex, c.get(endIndex));
            c.set(endIndex, temp);
            startIndex++;
            endIndex--;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("swap.in"));
        PrintWriter pw = new PrintWriter("swap.out");
        String[] st = br.readLine().split(" ");
        int numOfCows = Integer.parseInt(st[0]);
        int k = Integer.parseInt(st[1]);
        st = br.readLine().split(" ");
        int a1 = Integer.parseInt(st[0]) - 1;
        int a2 = Integer.parseInt(st[1]) - 1;
        st = br.readLine().split(" ");
        int b1 = Integer.parseInt(st[0]) - 1;
        int b2 = Integer.parseInt(st[1]) - 1;

        ArrayList<Integer> cows = new ArrayList<>();
        for (int c = 1; c <= numOfCows; c++) {
            cows.add(c);
        }

        HashSet<ArrayList<Integer>> visited = new HashSet<>();
        visited.add(new ArrayList<>(cows));
        while (true) {
            reverseSegment(cows, a1, a2);
            reverseSegment(cows, b1, b2);
            if (visited.contains(cows)) {
                break;
            }
            visited.add(new ArrayList<>(cows));
        }

        int cycleLen = visited.size();
        int swapsLeft = k % cycleLen;
        for (int s = 0; s < swapsLeft; s++) {
            reverseSegment(cows, a1, a2);
            reverseSegment(cows, b1, b2);
        }

        for(Integer c : cows) {
            pw.println(c);
        }
        pw.close();
        pw.flush();
        br.close();






    }
}



