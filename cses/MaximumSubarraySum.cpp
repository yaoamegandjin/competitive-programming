// Problem link: https://cses.fi/problemset/task/1643/
#include <iostream>
#include <vector>
#include <cmath>

int main() {
    long long int n{}, sum{}, x {}, max {-9000000000000000000};
    std::cin >> n;
    for (int i {0}; i < n; i++) {
        std::cin >> x;
        sum = std::max(sum + x, x);
        max = std::max(max, sum);
    }
    std::cout << max << '\n';
}
