import java.util.*;
import java.io.*;

public class gcpc {

    public static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(stdin.readLine());
        n = Integer.parseInt(tok.nextToken());
        int events = Integer.parseInt(tok.nextToken());
        team[] list = new team[n];
        boolean[] in = new boolean[n];
        int res = 0;
        for (int i=0; i<n; i++) list[i] = new team(i);

        TreeSet<team> better = new TreeSet<team>();

        StringBuffer sb = new StringBuffer();

        for (int i=0; i<events; i++) {

            tok = new StringTokenizer(stdin.readLine());
            int team = Integer.parseInt(tok.nextToken()) - 1;
            int pen = Integer.parseInt(tok.nextToken());

            if (in[team]) better.remove(list[team]);
            list[team].add(pen);

            if (team != 0 && list[team].compareTo(list[0]) > 0) {
                if (!in[team]) res++;
                in[team] = true;
                better.add(list[team]);
            }
            else if (team == 0) {
                while (better.size() > 0 && better.first().compareTo(list[0]) <= 0) {
                    res--;
                    in[better.pollFirst().ID] = false;
                }
            }

            sb.append((res+1)+"\n");
        }
        System.out.print(sb);
    }
}

class team implements Comparable<team> {

    public int ID;
    public int score;
    public int penalty;

    public team(int i) {
        ID = i;
        score = 0;
        penalty = 0;
    }

    public void add(int pen) {
        score++;
        penalty += pen;
    }
    public int compareTo(team other) {
        if (this.score != other.score) return this.score - other.score;
        if (this.penalty != other.penalty) return other.penalty - this.penalty;
        return other.ID - this.ID;
    }
}
