//Problem link: https://open.kattis.com/contests/kdfshe/problems/grandpabernie
#include <iostream>
#include <map>
#include <vector>

int main() {
    int n {}, y {}, q {}, k {};
    std::cin >> n;
    std::string s{};
    std::map<std::string, std::vector<int>> trips;
    for(int i {0}; i < n; i++) {
        std::cin >> s >> y;
        if (!trips.contains(s)) {
            trips.insert({s, {y}});
        } else {
            trips[s].push_back(y);
        }
    }
    for (auto& t: trips) {
        std::sort(t.second.begin(), t.second.end());
    }
    std::cin >> q;
    for (int i {0}; i < q; i++) {
        std::cin >> s >> k;
        std::cout << trips[s][k - 1] << '\n';
    }
}
