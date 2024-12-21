// https://codeforces.com/contest/2034/problem/A
#include <iostream>
#include <cmath>
void solve() {
    int a{}, b{};
    std::cin >> a >> b;
    for (int i{a}; i < INFINITY; i++) {
        if (i % a == i % b) {
            std::cout << i << '\n';
            return;
        }
    }
}
int main(){
    int t{};
    std::cin >> t;
    while(t--) {
        solve();
    }
}
