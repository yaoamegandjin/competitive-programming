// Problem link: https://codeforces.com/problemset/problem/2036/B
#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
void solve() {
    int n{}, k{}, b{}, c{};
    std::cin >> n >> k;
    std::vector<int> brand_cost(k);
    for (int i{0}; i < k; i++) {
        std::cin >> b >> c;
        brand_cost[b - 1] += c;
    } 

    std::sort(brand_cost.rbegin(), brand_cost.rend());
    int max{};
    for (int i{0}; i < std::min(n, k); i++) {
        max += brand_cost[i];
    }
    std::cout << max << '\n';
}
int main() {
    int t{};
    std::cin >> t;
    while(t--) {
        solve();
    }
    return 0;

}
