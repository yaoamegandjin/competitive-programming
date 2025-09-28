// Problem link: https://open.kattis.com/problems/bestrelayteam?tab=submissions
import java.util.*;
class Runner {
    private String name;
    private double firstLegTime;
    private double otherLegTime;
    public Runner(String name, double firstLegTime, double otherLegTime) {
        this.name = name;
        this.firstLegTime = firstLegTime;
        this.otherLegTime = otherLegTime;
    }

    public String toString() {
        return name + " " + firstLegTime + " " + otherLegTime;
    }

    public String getName() {
        return name;
    }

    public double getFirstLegTime()
    {
        return firstLegTime;
    }

    public double getOtherLegTime()
    {
        return otherLegTime;
    }
    
}
class SortByFirstLegTime implements Comparator<Runner> {
    public int compare(Runner a, Runner b) {
        if (a.getFirstLegTime() < b.getFirstLegTime()) {
            return -1;
        } else if (a.getFirstLegTime() > b.getFirstLegTime()) {
            return 1;
        } else {
            return 0;
        }
    }
    
}

class SortByOtherLegTime implements Comparator<Runner> {
    public int compare(Runner a, Runner b) {
        if (a.getOtherLegTime() < b.getOtherLegTime()) {
            return -1;
        } else if (a.getOtherLegTime() > b.getOtherLegTime()) {
            return 1;
        } else {
            return 0;
        }
    }
    
}

public class bestrelayteam {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<Runner> runnersByFirstLeg = new ArrayList<>();
        ArrayList<Runner> runnersByOtherLeg = new ArrayList<>();
        ArrayDeque<String> topFourRunner = new ArrayDeque<>();
        int numOfRunners = Integer.parseInt(scnr.nextLine());
        double totalTime = Double.MAX_VALUE;
        while (numOfRunners != 0) {
            String runnerName = scnr.next();
            double firstLegTime = scnr.nextDouble();
            double secondLegTime = scnr.nextDouble();
            runnersByFirstLeg.add(new Runner(runnerName, firstLegTime, secondLegTime));
            runnersByOtherLeg.add(new Runner(runnerName, firstLegTime, secondLegTime));
            numOfRunners -= 1;
        }
        scnr.close();
        Collections.sort(runnersByFirstLeg, new SortByFirstLegTime());
        Collections.sort(runnersByOtherLeg, new SortByOtherLegTime());
        for (int i = 0; i < runnersByFirstLeg.size(); ++i) {
            int count = 0;
            double sumOfTime = runnersByFirstLeg.get(i).getFirstLegTime();
            Deque<String> potentialTopFour = new ArrayDeque<>();
            potentialTopFour.add(runnersByFirstLeg.get(i).getName());
            for (int j = 0; j < 4; ++j) {
                if (!runnersByFirstLeg.get(i).getName().equals(runnersByOtherLeg.get(j).getName())) {
                    sumOfTime += runnersByOtherLeg.get(j).getOtherLegTime();
                    potentialTopFour.add(runnersByOtherLeg.get(j).getName());
                    count += 1;
                    if (count == 3) {
                        break;
                    }
                
                }
            }
            if (sumOfTime < totalTime) {
                totalTime = sumOfTime;
                sumOfTime = 0;
                topFourRunner.clear();
                for (String name: potentialTopFour) {
                    topFourRunner.add(new String(name));
                }
            }
        }
        topFourRunner.addFirst(Double.toString(totalTime));

        while(topFourRunner.isEmpty() == false) {
            System.out.println(topFourRunner.pop());
        }
    }
}
