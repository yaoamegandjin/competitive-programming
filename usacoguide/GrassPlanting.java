// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=894
package usacoguide;
import java.io.*;
public class GrassPlanting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("planting.in"));
        PrintWriter pw = new PrintWriter("planting.out");
        int numOfFields = Integer.parseInt(br.readLine());
        int[] degree = new int[numOfFields];
        for (int i = 1; i < numOfFields; i++) {
            String[] pathways = br.readLine().split(" ");
            degree[Integer.parseInt(pathways[0]) - 1]++;
            degree[Integer.parseInt(pathways[1]) - 1]++;
        }
        int max = 0;
        for (int j = 0; j < numOfFields; j++) {

            max = Math.max(max, degree[j]);
        }
        pw.println(max + 1);
        pw.close();
        pw.flush(); 
        br.close();
        
    }
}
