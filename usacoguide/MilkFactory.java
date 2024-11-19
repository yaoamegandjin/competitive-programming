//Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=940
package usacoguide;
import java.io.*;
import java.util.*;

public class MilkFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("factory.in"));
        PrintWriter pw = new PrintWriter("factory.out");
        int numOfStations = Integer.parseInt(br.readLine());
        int[] outdegree = new int[numOfStations];

        for (int j = 1; j < numOfStations; j++) {
            String[] stations = br.readLine().split(" ");
            int startStation = Integer.parseInt(stations[0]) - 1;
            outdegree[startStation]++;
        }

        ArrayList<Integer> noOutDegree = new ArrayList<Integer>();
        for (int s = 0; s < numOfStations; s++) {
            if (outdegree[s] == 0) {
                noOutDegree.add(s + 1);
            }
        }

        int root = noOutDegree.size() == 1 ? noOutDegree.get(0) : -1;
        pw.println(root);
        pw.flush();
        pw.close();
        br.close();

        
    }
}
