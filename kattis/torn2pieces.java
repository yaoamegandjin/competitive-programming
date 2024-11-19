// Problem link: https://open.kattis.com/problems/torn2pieces
// Status: unsolved
package kattis;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class torn2pieces {
    static HashMap<String, Integer> station = new HashMap<>();
    static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static ArrayList<String> path  = new ArrayList<>();
    static boolean dfs(int start, int end) {
        if (start == end) {
            visited[end] = true;
            return true;
        }
        visited[start] = true;
        for (Entry<String, Integer> entry: station.entrySet()) {
            if (entry.getValue() == start) {
                path.add(entry.getKey());
            }
        }
        for(int station: graph.get(start)) {
            if(!visited[station]) {
                if (dfs(station, end)) {
                    return true;
                }
            }
        }
        return false;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 16384);
        int numOfStations = Integer.parseInt(br.readLine());
        visited = new boolean[numOfStations];
        int ID = 0;

        for (int i = 0; i < numOfStations; i++) {
            String stations = br.readLine();
            String[] adjStations = stations.split(" ");
            for (int j = 0; j < adjStations.length; j++) {
                if (!station.containsKey(adjStations[j])) {
                    station.put(adjStations[j], ID);
                    graph.put(ID, new HashSet<>());
                    ID++;
                }
            }
            for ( int n = 1; n < adjStations.length; n++) {
                    graph.get(station.get(adjStations[0])).add(station.get(adjStations[n]));
                    graph.get(station.get(adjStations[n])).add(station.get(adjStations[0]));
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startingStation = station.get(st.nextToken());
        String end = st.nextToken();
        int endingStation = station.get(end);
        if (dfs(startingStation, endingStation)) {
            System.out.println(String.join(" ", path) + " " + end);
        }
        else {
            System.out.println("no route found");
        }
    }
}
