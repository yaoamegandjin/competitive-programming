// Problem link: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=614
package onlinejudge;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception{
        Scanner scnr = new Scanner(System.in);
        int numOfLines = scnr.nextInt();
        for (int i = 0; i < numOfLines; i++) {
            Stack<Character> stack = new Stack<>();
            String parentheses = scnr.next();
            for (int j = 0; j < parentheses.length(); j++) {
                char n = parentheses.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(n);
                }
                else if (stack.peek() == '(' && n == ')' || stack.peek() == '[' && n == ']') {
                    stack.pop();
                }
                else {
                    stack.push(n);
                }
            }
            if (stack.isEmpty()) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
           
        }
        scnr.close();

    }
}
