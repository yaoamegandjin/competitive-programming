// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=739
package usacoguide;
import java.io.*;
import java.util.*;

public class BovineGenomicsSilver {
    static final Map<Character, Integer> GENOME_ID = Map.ofEntries(Map.entry('A', 0), Map.entry('T', 1), Map.entry('C', 2), Map.entry('G', 3));
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter("cownomics.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] spottyCows = new int[N][M];
        int[][] plainCows = new int[N][M];

        for (int i = 0; i < N; i++) {
            String genome = br.readLine();
            for (int j = 0; j < M; j++) {
                spottyCows[i][j] = GENOME_ID.get(genome.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            String genome = br.readLine();
            for (int j = 0; j < M; j++) {
                plainCows[i][j] = GENOME_ID.get(genome.charAt(j));
            }
        }

        int validSets = 0;

        for (int a = 0; a < M; a++) {
            for (int b = a + 1; b < M; b++) {
                for (int c = b + 1 ; c < M; c++) {
                    boolean[] spottedIDs = new boolean[64];
                    for (int sc = 0; sc < N; sc++) {
                        int total = (spottyCows[sc][a] * 16 + spottyCows[sc][b] * 4 + spottyCows[sc][c]);
                        spottedIDs[total] = true;
                    }
                    
                    boolean valid = true;
                    for (int pc = 0; pc < N; pc++) {
                        int total = (plainCows[pc][a] * 16 + plainCows[pc][b] * 4 + plainCows[pc][c]);
                        if (spottedIDs[total]) {
                            valid = false;
                            break;
                        }
                    }

                    validSets += valid ? 1 : 0;

                }
            }
        }
        pw.println(validSets);
        br.close();
        pw.flush();
        pw.close();
    }
}
