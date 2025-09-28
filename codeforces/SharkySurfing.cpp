// Problem link: https://codeforces.com/contest/2037/problem/D
#include <iostream>
#include <utility>
#include <vector>
#include <queue>

void solve() {
   long long int n{}, m{}, L{}, l{}, r{}, x{}, v{}, k{1};

   std::cin >> n >> m >> L;
   std::vector<std::pair<long long int, long long int>> path(n), power_ups(m);
   std::priority_queue<long long int> q;
   for (int i{0}; i < n; i++) {
        std::cin >> path[i].first >> path[i].second;
   }
   for (int i{0}; i < m; i++) {
    std::cin >> power_ups[i].first >> power_ups[i].second;
   }
   
   int j {0};
   for (int i {0}; i < n; i++) {
        while (j < m && power_ups[j].first < path[i].first) {
            q.push(power_ups[j].second);
            j++;
        }

        while (!q.empty() &&  k < path[i].second - path[i].first + 2) {
            k += q.top();
            q.pop();
        }

        if (k < path[i].second - path[i].first + 2) {
            std::cout << -1 << '\n';
            return;
        }
        
    }   
    while (j < m) {
        q.push(power_ups[j].second);
        j++;
    }
    std::cout << m - q.size() << '\n';
}

int main() {
    int t{};
    std::cin >> t;
    while(t--) {
        solve();
    }
}
