// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=965
import java.io.*;
import java.util.*;

public class LivestockLineup {
    static final String[] COWS = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter pw = new PrintWriter("lineup.out");
        HashMap<String, Integer> cowNum = new HashMap<String, Integer>();
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] neighbors = new ArrayList[COWS.length];
        Arrays.sort(COWS);
        for (int i = 0; i < COWS.length; i++) {
            cowNum.put(COWS[i], i);
        }
        for (int c = 0; c < COWS.length; c++) {
            neighbors[c] = new ArrayList<Integer>();
        }
        
        int reqNum = Integer.parseInt(br.readLine());

        for (int r = 0; r < reqNum; r++) {
            String[] words = br.readLine().split(" ");
            int cow1 = cowNum.get(words[0]);
            int cow2 = cowNum.get(words[words.length - 1]);
            neighbors[cow1].add(cow2);
            neighbors[cow2].add(cow1);
        }
        ArrayList<Integer> order = new ArrayList<Integer>();
        boolean[] added = new boolean[COWS.length];
        for (int c = 0; c < COWS.length; c++) {
            if (!added[c] && neighbors[c].size() <= 1) {
                added[c] = true;
                order.add(c);
                if (neighbors[c].size() == 1) {
                    int prev = c;
                    int at = neighbors[c].get(0);
                    while (neighbors[at].size() == 2) {
                        added[at] = true;
                        order.add(at);
                        int a = neighbors[at].get(0);
                        int b = neighbors[at].get(1);
                        int temp_at;
                        if (a == prev) {
                            temp_at = b;
                        }
                        else {
                            temp_at = a;
                        }
                        prev = at;
                        at = temp_at;                        
                    }
                    added[at] = true;
                    order.add(at);
                }
            }
        }
        for (int c : order) {
            pw.println(COWS[c]);
        }
        pw.close();
        pw.flush();
        br.close();     
    }
        
}
