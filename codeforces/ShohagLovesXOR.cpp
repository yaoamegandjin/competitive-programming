// Problem link: https://codeforces.com/contest/2039/problem/C1
#include <bits/stdc++.h>
void solve() {
    int x {}, count {};
    long long m {};
    std::cin >> x >> m;
    for (int y {1}; y <= std::min(2LL * x, m); y++) {
        if (x != y && ((x % (x ^ y)) == 0 || (y % (x ^ y)) == 0)){
            count++;
        }

    }
    std::cout << count << '\n';
}

int main() {
    int t {};
    std::cin >> t;
    while(t--) {
        solve();
    }
}
