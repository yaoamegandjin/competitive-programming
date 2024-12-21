// Problem link: https://codeforces.com/contest/2037/problem/A
#include <iostream>
#include <map>
#include <cmath>

void solve() {
    int n{}, a{};
    double sum {};
    std::map<int, int> frequency;
    std::cin >> n;
    for (int i {0}; i < n; i++) {
        std::cin >> a;
        if (frequency.contains(a)) {
            frequency[a]++;
        } else {
            frequency.insert({a, 1});
        }
    }

    for (const auto& f: frequency) {
        sum +=  std::floor(f.second / 2.0);
    }

    std::cout << sum << '\n';

}
int main() {
    int t{};
    std::cin  >> t;
    while(t--) {
        solve();
    }
}
