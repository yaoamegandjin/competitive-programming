// Problem link: https://open.kattis.com/problems/lightup
import java.util.*;
public class lightup {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        String row = "";
        for (int i = 0; i < n; i++) {
            row = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '?') {
                    int d;
                    for (d = i - 1; d >= 0 && (grid[d][j] == '.' || grid[d][j] == '#'); d--) {
                        grid[d][j] = '#';

                    }
                    if (d >= 0 && grid[d][j] == '?') {
                        ok = false;
                    }

                    for (d = i + 1; d < n && (grid[d][j] == '.' || grid[d][j] == '#'); d++) {
                        grid[d][j] = '#';

                    }
                    if (d < n  && grid[d][j] == '?') {
                        ok = false;
                    }

                    for (d = j - 1; d >= 0 && (grid[i][d] == '.' || grid[i][d] == '#'); d--) {
                        grid[i][d] = '#';

                    }
                    if (d >= n && grid[i][d] == '?') {
                        ok = false;
                    }

                    for (d = j + 1; d < n && (grid[i][d] == '.' || grid[i][d] == '#'); d++) {
                        grid[i][d] = '#';

                    }
                    if (d < n && grid[i][d] == '?') {
                        ok = false;
                    }
    
                } else if (Character.isDigit(grid[i][j])) {
                    int constraint = grid[i][j] - '0';
                    int count = 0;
                    if (i - 1 >= 0 && grid[i - 1][j] == '?') {
                        count++;
                    }
                    if (i + 1 < n && grid[i + 1][j] == '?') {
                        count++;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '?') {
                        count++;
                    }
                    if (j + 1 < n && grid[i][j + 1] == '?') {
                        count++;
                    }
                    if (count != constraint) {
                        ok = false;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '.') {
                    ok = false;
                }
            }
        }
        System.out.println(ok ? 1 : 0);
        sc.close();
    }
    
}
