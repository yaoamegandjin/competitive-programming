import java.io.*;
import java.util.*;

public class torntopieces {
    public static long compute_hash(String s) {
        int p = 31;
        int m = 1000000000 + 9;
        long hash_value = 0;
        long p_pow = 1;
        for (int i = 0; i < s.length(); i++) {
            hash_value = (hash_value + (s.charAt(i) - 'a' + 1) * p_pow) % m;
            p_pow = (p_pow * p) % m;
        }
        return hash_value;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        HashMap<Long, String> stations = new HashMap<>();
        HashMap<Long, ArrayList<Long>> adj = new HashMap<>();
        HashMap<Long, Boolean> visited = new HashMap<>();
        HashMap<Long, Long> p = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
       
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            long c = compute_hash(a);
            if (!stations.containsKey(c)) {
                adj.put(c, new ArrayList<>());
                stations.put(c, a);

            }
            while (st.hasMoreTokens()) {
                String b = st.nextToken();
                long d = compute_hash(b);
                if (!stations.containsKey(d)) {
                    adj.put(d, new ArrayList<>());
                    stations.put(d, b);
                }
                adj.get(c).add(d);
                adj.get(d).add(c);
            }
        }

        st = new StringTokenizer(br.readLine());
        long start = compute_hash(st.nextToken());
        long end = compute_hash(st.nextToken());

        ArrayDeque<Long> q = new ArrayDeque<>();
        q.push(start);
        visited.put(start, true);
        p.put(start, -1L);
        while(!q.isEmpty()) {
            long v = q.poll();
            if (adj.get(v) != null) {
                for (long u: adj.get(v)) {
                    if (!visited.containsKey(u)) {
                        visited.put(u, true);
                        q.push(u);
                        p.put(u, v);
                    }
                }
            }
        }

        if (!visited.containsKey(end)) {
            pw.println("no route found");
        } else {
            ArrayList<String> path = new ArrayList<>();
            for (long v = end; v != -1L; v = p.get(v)) {
                path.add(stations.get(v));
            }
            Collections.reverse(path);
            pw.println(String.join(" ", path));
        }
        pw.close();


    }
}
