//Problem link: https://codeforces.com/contest/2037/problem/C
#include <iostream>
void solve() {
    int n{};
    std::cin >> n;
    if (n < 5) {
        std::cout << -1 << '\n';
        return;
    }
    for (int i {2}; i <= n; i+=2) {
        if (i != 4) {
            std::cout << i << " ";
        }
    }
    std::cout << "4 5";
    for (int i {1}; i <= n; i +=2) {
        if (i != 5) {
            std::cout << " " << i;
        }
    }
    std::cout << '\n';
}

int main() {
    int t{};
    std::cin >> t;
    while(t--) {
        solve();
    }
}

