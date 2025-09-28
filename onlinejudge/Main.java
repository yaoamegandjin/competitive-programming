// Problem link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=455
package onlinejudge;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int numOfCoaches = Integer.parseInt(br.readLine());
            if (numOfCoaches == 0) {
                break;
            }
            boolean running = true;
            while (running) {
                Stack<Integer> stack = new Stack<>();
                int j = 0;
                String[] coaches = br.readLine().split(" ");
                for (int i = 0; i < coaches.length; ++i) {
                    int coach = Integer.parseInt(coaches[i]);
                    if (coach == 0) {
                        running = false;
                        break;
                    }
                    while (j < numOfCoaches && j != coach) {
                        if (stack.size() > 0 && stack.peek() == coach) {
                            break;
                        }
                        j++;
                        stack.push(j);
                    }
                    if (stack.peek() != coach) {
                        break;
                    }
                    stack.pop();
                
                }
                if (running) {
                    if (stack.isEmpty()) {
                        System.out.println("Yes");
                    }
                    else {
                        System.out.println("No");
                    }
                }
            }
            System.out.println();
        }
    }
}
    