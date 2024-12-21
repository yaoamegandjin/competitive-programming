// Problem link: https://codeforces.com/contest/2039/problem/B
#include <iostream>
#include <string>

void solve() {
    std::string s{};
    std::cin >> s;
    long unsigned int n {s.size()};

    for (int i{ 0 }; i + 1 < n; i++) {
        if (s[i] == s[i + 1]) {
            std::cout << s.substr(i, 2) << '\n';
            return;
        }
    }

    for (int i { 0 }; i + 2 < n; i++) {
        if (s[i] != s[i + 1] && s[i] != s[i + 2] && s[i + 2] != s[i + 1]) {
            std::cout << s.substr(i, 3) << '\n';
            return;
        }
    }

    std::cout << -1 << '\n';
}

int main() {
    int t{};
    std::cin >> t;
    while(t--) {
        solve();
    }

}
