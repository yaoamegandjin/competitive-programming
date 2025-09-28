// Problem link: https://open.kattis.com/problems/cookieselection
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class MedianPriorityQueue {
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();
    
    public void balance() {
        if (left.size() - right.size() > 1) {
            right.add(left.remove());
        }
        else if (right.size() > left.size()) {
            left.add(right.remove());
        }

    }   

    public void add(int val) {
        if(left.size() == 0 ||val < left.peek()) {
            left.add(val);
        }
        else {
            right.add(val);
        }
        balance();
    }
    
    public  int remove() {
        if(left.size() == 0) {
            return -1;
        }
        else if (size() % 2 == 1){
            int val = left.remove();
            balance();
            return val;
        }
        else {
            int val = right.remove();
            balance();
            return val;
        }
    }

    public int peek() {
        if(left.size() == 0) {
            return -1;
        }
        else {
            return left.peek();
        }
    }

    public int size() {
        return left.size() + right.size();
    }
}
public class cookieselection {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        MedianPriorityQueue holdingArea = new MedianPriorityQueue();
        while (scnr.hasNextLine())  {
            String line = scnr.nextLine();
            if (!line.equals("#")) {
                if (Integer.parseInt(line) <= 300000000) {
                    holdingArea.add((Integer.parseInt(line)));
                }
            }
            else {
                System.out.println(holdingArea.remove());
            }
            
        }
        scnr.close();

    }
}
