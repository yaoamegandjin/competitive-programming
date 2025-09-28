//Problem link: https://codeforces.com/contest/2031/problem/A

#include <iostream>
#include <map>
#include <algorithm>
#include <vector>
#include <utility>

void solve() {
    int n{}, h{}, count{};
    std::cin >> n;
    std::map<int, int> heightFrequency;
    std::vector<std::pair<int, int>> v(n);
    for(int i {0}; i < n; i++) {
        std::cin >> h;
        if (heightFrequency.contains(h)) {
            heightFrequency[h]++;
        } else {
            heightFrequency.insert({h, 1});
        }
    }

    for (const auto& h: heightFrequency) {
        v.push_back({h.first, h.second});
    }
    std::sort(v.begin(), v.end(), [] (std::pair<int, int> a, std::pair<int, int> b) {
        return a.second > b.second;
    });

    std::cout << n - v[0].second << '\n';
}

int main() {
    int t {};
    std::cin >> t;
    while(t--) {
        solve();
    }
}
