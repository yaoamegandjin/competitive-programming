// Problem link: https://cses.fi/problemset/task/1624
import java.io.*;
public class ChessboardAndQueens {
    public static final int N = 8;
    public static boolean[][] blocked = new boolean[N][N];
    public static boolean[] rowsTaken = new boolean[N];
    public static boolean[] diag1 = new boolean[N * 2 - 1];
    public static boolean[] diag2 = new boolean[N * 2 - 1];
    public static int validNum = 0;
    public static void searchQueens(int c) {
        if (c == N) {
            validNum++;
            return;
        }
        for (int r = 0; r < N; r++) {
            boolean row_open = !rowsTaken[r];
            boolean diag_open = !diag1[r + c] && !diag2[r - c + N - 1];
            if (!blocked[r][c] && row_open && diag_open) {
                rowsTaken[r] = diag1[r + c] = diag2[r - c + N - 1] = true;
                searchQueens(c + 1);
                rowsTaken[r] = diag1[r + c] = diag2[r - c + N - 1] = false;
            } 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int r = 0; r < N; r++) {
            String row = br.readLine();
            for (int c = 0; c < N; c++) {
                if (row.charAt(c) == '*') {
                    blocked[r][c] = true;
                }
            }
        }
        searchQueens(0);
        System.out.println(validNum);
    }
}
