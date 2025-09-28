//Problem link: https://codeforces.com/contest/2038/problem/L
#include <iostream>
#include <cmath>

int main() {
    int n {};
    std::cin >> n;
    std::cout << n + std::ceil(n / 6.0) << '\n';
}
