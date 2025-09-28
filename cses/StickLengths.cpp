// Problem link: https://cses.fi/problemset/result/11262774/
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

int main() {
    long long int n{}, p{}, mid{}, min_cost{};
    std::cin >> n;
    std::vector<long long int> sticks(n);
    for (int i {0}; i < n; i++) {
        std::cin >> p;
        sticks[i] = p;
    }
    std::sort(sticks.begin(), sticks.end());
    mid = sticks[n /2];
    for (int i {0}; i < n; i++) {
        min_cost += std::abs(sticks[i] - mid);
    }
    std::cout << min_cost << '\n';
}
