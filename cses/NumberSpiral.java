// Problem link: https://cses.fi/problemset/task/1071
import java.io.*;

public class NumberSpiral {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTests = Integer.parseInt(br.readLine());
        long x;
        long y;
        String[] coords;
        PrintWriter pw = new PrintWriter(System.out);
        long num = 0;
        for (int t = 0; t < numOfTests; t++) {
            coords = br.readLine().split(" ");
            y = Integer.parseInt(coords[0]);
            x = Integer.parseInt(coords[1]);
            if (y == x) {
                // If y and x are the same, the number at (y, x) is (y * x) - (y - 1) 
                num = (y * x) - (y - 1);
            }
            else if (y > x) {
                if (y % 2 == 1) {
                    // If y is odd and y > x, the number at (y, x) is the number at (y, y) minus (y minus x)
                    num = ((y * y) - (y - 1)) - (y - x);
                }
                else {
                    // If y is even and y > x, the number at (y, x) is the number at (y, y) plus (y minus x)
                    num = ((y * y) - (y - 1)) + (y - x);
                }
            }
            else if (x > y) {
                // If x is odd and x > y, the number at (y, x) is the number at (x, x) plus (x minus y)
                if (x % 2 == 1) {
                    num = ((x * x) - (x - 1)) + (x - y);

                }
                // If x is even and x > y, the number at (y, x) is the number at (x, x) - (x minus y)
                else {
                    num = ((x * x) - (x - 1)) - (x - y);
                }
            }
            pw.println(num);

        }
        pw.flush();
        pw.close();
    }
}
