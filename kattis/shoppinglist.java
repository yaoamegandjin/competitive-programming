// Problem link: https://open.kattis.com/problems/shoppinglist

import java.io.*;
import java.util.*;

public class shoppinglist {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] numOfShoppingListAndItems = br.readLine().split(" ");
       int numOfShoppingList = Integer.parseInt(numOfShoppingListAndItems[0]);
       int numOfItems = Integer.parseInt(numOfShoppingListAndItems[1]);

       @SuppressWarnings("unchecked")
       HashSet<String>[] carts = new HashSet[numOfShoppingList];

       for(int i = 0; i < numOfShoppingList; ++i) {
            String[] shoppingList = br.readLine().split(" ");
            carts[i] = new HashSet<String>();
            for (int item = 0; item < numOfItems; item++) {
                carts[i].add(shoppingList[item]);
            }
       }

       HashSet<String> ans = new HashSet<>(carts[0]);
       for (int cart = 1; cart < carts.length; cart++) {
           ans.retainAll(carts[cart]);
       }
       TreeSet<String> orderedAns = new TreeSet<>(ans);
       System.out.println(orderedAns.size());
       for(String item: orderedAns) {
        System.out.println(item);
       }
    }
}
