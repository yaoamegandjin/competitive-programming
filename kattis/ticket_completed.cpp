// Problem link: https://open.kattis.com/contests/kdfshe/problems/ticketcompleted?tab=metadata
#include <iostream>
#include <vector>
#include <iomanip>

std::vector<std::vector<int>> adj;
std::vector<bool> visited;
std::vector<int> connected_comp;

double choose(int n, int k) {
    if (k == 0) {
        return 1;
    }
    return (n * choose(n - 1, k - 1)) / static_cast<double>(k);
}
void dfs(int v) {
    visited[v] = true;
    connected_comp.push_back(v);
    for (int u: adj[v]) {
        if (!visited[u]) {
            dfs(u);
        }
    }
}

int main() {
    int N {}, M {};
    int i {}, j {};
    std::cin >> N >> M;
    double satisfied_tickets {}, unique_tickets {choose(N, 2)};
    adj = std::vector<std::vector<int>>(N);
    visited = std::vector<bool>(N);
    for (int m { 0 }; m < M; m++) {
        std::cin >> i >> j;
        adj[--i].push_back(--j);
        adj[j].push_back(i);
    }
    for (int v { 0 }; v < N; v++) {
        if (!visited[v]) {
            connected_comp.clear();
            dfs(v);
            int n = std::size(connected_comp);
            satisfied_tickets += choose(n , 2);
        }
    }
    std::cout << std::setprecision(18) << satisfied_tickets / unique_tickets << '\n';



}
