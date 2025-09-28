// Problem link: https://open.kattis.com/problems/areal?tab=metadata
#include <iostream>
#include <cmath>
#include <iomanip>

int main() {
    double a {};
    std::cin >> a;
    std::cout << std::setprecision(16) << 4 * std::sqrt(a) << '\n';
}
