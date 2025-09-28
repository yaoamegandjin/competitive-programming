// Problem link: https://codeforces.com/contest/2039/problem/A
#include <iostream>

void solve() {
    int n {};
    std::cin >> n;
    for (int i {1}; i <= n; i++) {
        std::cout << 2 * i - 1 << " ";
    }
    std::cout << '\n';
}

int main() {
    int t {};
    std::cin >> t;

    while(t--) {
        solve();
    }
}
