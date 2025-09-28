// Problem link: https://codeforces.com/contest/2041/problem/A
#include <iostream>
#include <set>

void solve() {
    int n {};
    std::set<int> restaurants;
    for (int i = 0; i < 4; i++) {
        std::cin >> n;
        restaurants.insert(n);
    }
    for (int i{ 1 }; i <= 5; i++) {
        if(!restaurants.contains(i)) {
            std::cout << i << '\n';
            return;
        }
    }
}
int main() {
    solve();
}
