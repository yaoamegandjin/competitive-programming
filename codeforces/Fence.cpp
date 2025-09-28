// Problem link: https://codeforces.com/contest/363/problem/B

#include <iostream>
#include <vector>
#include <limits.h>
int main() {
    int n {}, k {};
    std::cin >> n >> k;
    std::vector<int> h(n);
    std::vector<int> hPrefix(n + 1); 
    int sumOfHeights {};
    for (int i{ 0 }; i < n; i++) {
        std::cin >> h[i];
        sumOfHeights += h[i];
    }

    for (int i{ 0 }; i < n; i++) {
        hPrefix[i + 1] += hPrefix[i] + h[i];
    }

    int min {INT_MAX};
    int index {};
    for (int i{1}; i <= std::size(hPrefix) - k; i++) {
        if (hPrefix[i + k - 1] - hPrefix[i - 1] < min) {
            min = hPrefix[i + k - 1] - hPrefix[i - 1];
            index = i;
        }

    }
    std::cout << index << '\n';
}
