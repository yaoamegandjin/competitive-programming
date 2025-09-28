// Problem link: https://open.kattis.com/problems/zoo
import java.util.TreeMap;
import java.util.Scanner;

public class zoo {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        TreeMap<String, Integer> animalsAndCount = new TreeMap<>();
        int list = 1;
        int i;
        int numberOfAnimals = Integer.parseInt(scnr.nextLine());
        while (scnr.hasNextLine()) {
            for (i = 0; i < numberOfAnimals; ++i) {
                String fullAnimalName = scnr.nextLine().toLowerCase();
                String animal = fullAnimalName.substring(fullAnimalName.lastIndexOf(" ") + 1);
                if (!animalsAndCount.containsKey(animal)) {
                    animalsAndCount.put(animal, 1);
                }
                else {
                    animalsAndCount.put(animal, animalsAndCount.get(animal) + 1);
                }
            }
            System.out.println("List " + list + ":");
            for (String key: animalsAndCount.keySet()) {
                System.out.println(key + " | " + animalsAndCount.get(key));

            }
            numberOfAnimals = Integer.parseInt(scnr.nextLine());
            animalsAndCount.clear();
            list += 1;
        }
    }
}
