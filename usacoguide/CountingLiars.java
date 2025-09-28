// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=1228
package usacoguide;
import java.io.*;
import java.util.*;

class Cow implements Comparable<Cow> {
    private char statement;
    private int position;
    public Cow(char statement, int position) {
        this.statement = statement;
        this.position = position;
    }

    public int getPositon() {
        return position;
    }

    public char getStatement() {
        return statement;
    }


    @Override
    public int compareTo(Cow c) {
        if (position != c.getPositon()) {
            return position - c.getPositon();
        }
        return statement - c.getStatement();
    }
}
public class CountingLiars {

    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n  = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer cow = new StringTokenizer(br.readLine());
            cows[i] = new Cow(cow.nextToken().charAt(0), Integer.parseInt(cow.nextToken()));
        }
        br.close();

        Arrays.sort(cows);

        int[] lyingLeft = new int[n];

        for (int i = 1; i < n; i++) {
            lyingLeft[i] += lyingLeft[i - 1];
            if (cows[i - 1].getStatement() == 'L' && cows[i].getPositon() >= cows[i - 1].getPositon()) {
                lyingLeft[i]++;
            }
        }

       int[] lyingRight = new int[n];
       for(int i = n - 2; i >= 0; i--) {
            lyingRight[i] += lyingRight[i + 1];
            if (cows[i + 1].getStatement() == 'G' && cows[i].getPositon() <= cows[i + 1].getPositon()) {
                lyingRight[i]++;
            }
       }

       int minLiars = n;
       for (int i = 0; i < n; i++) {
            int x = lyingLeft[i] + lyingRight[i];
           minLiars = Math.min(minLiars, x);
       }
       System.out.println(minLiars);
        
    }
    
}
