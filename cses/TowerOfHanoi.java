// Problem link: https://cses.fi/problemset/task/2165
import java.util.*;
public class TowerOfHanoi {
    public static void hanoi(ArrayList<int[]> moves, int numOfDisks, int start, int end) {
        if (numOfDisks == 1) {
            moves.add(new int[]{start, end});
            return;
        } else {
            int auxiliary = 6 - (start + end);
            hanoi(moves, numOfDisks - 1, start, auxiliary);
            moves.add(new int[]{start, end});
            hanoi(moves, numOfDisks - 1, auxiliary, end);
        }
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numOfDisks = scnr.nextInt();
        ArrayList<int[]> moves = new ArrayList<>();
        hanoi(moves, numOfDisks, 1, 3);
        System.out.println(moves.size());
        for(int[] move : moves) {
            System.out.println(move[0] + " " + move[1]);
        }
        scnr.close();
    }
}
