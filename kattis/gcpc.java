// Problem link: https://open.kattis.com/problems/gcpc
//Status: unsolved
package kattis;
import java.io.*;
import java.util.*;
class Team implements Comparable<Team> {
    private int teamNumber;
    private int problemsSolved;
    private int totalPenalty;
    public Team(int teamNumber) {
        this.teamNumber = teamNumber;
        problemsSolved = 0;
        totalPenalty = 0;

    }
    public void updateScore(int penalty) {
        problemsSolved++;
        totalPenalty += penalty;
    }
    @Override
    public int compareTo(Team other) {
        if (this.problemsSolved != other.problemsSolved) {
            return this.problemsSolved - other.problemsSolved;
        }
        return other.totalPenalty - this.totalPenalty;
    }

    public int getTeamNum() {
        return teamNumber;
    }

    public String toString() {
        return "(" + teamNumber + ", "  + problemsSolved + ", " + totalPenalty + ")";
    }
    
}

public class gcpc {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfTeams = Integer.parseInt(st.nextToken());
        int numOfEvents = Integer.parseInt(st.nextToken());
        Team[] listOfTeams = new Team[numOfTeams];
        boolean[] in = new boolean[numOfEvents];
        int rank = 0;
        TreeSet<Team> teamsBetter = new TreeSet<Team>();
        
        for (int i = 0; i < numOfTeams; i++) {
            listOfTeams[i] = new Team(i);
        }

        for (int j = 0; j < numOfEvents; j++) {
           st = new StringTokenizer(br.readLine());
           int teamNum = Integer.parseInt(st.nextToken()) - 1;
           int penalty = Integer.parseInt(st.nextToken());
           if (in[teamNum]) {
                teamsBetter.remove(listOfTeams[teamNum]);
           }
           listOfTeams[teamNum].updateScore(penalty);
           
           if (teamNum != 0 && listOfTeams[teamNum].compareTo(listOfTeams[0]) > 0) {
                if (!in[teamNum]) {
                    rank++;
                }
                in[teamNum] = true; 
                teamsBetter.add(listOfTeams[teamNum]);
            }
            else if (teamNum == 0) {
                while(teamsBetter.size() > 0 && teamsBetter.first().compareTo(listOfTeams[0]) <= 0) {
                    rank--;
                    in[teamsBetter.pollFirst().getTeamNum()] = false;
                }
            }
            System.out.println(rank + 1);

        }
        

    }
    
}
