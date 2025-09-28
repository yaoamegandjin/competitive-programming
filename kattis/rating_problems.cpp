// Problem link: https://open.kattis.com/problems/ratingproblems
#include <iostream>
#include <iomanip>

int main() {
    int n {}, k {}, r {}, rating {};
    std::cin >> n >> k;
    int other_judges {n - k};
    for (int i {0}; i < k; i++) {
        std::cin >> r;
        rating += r;
    }

    double min {(rating - 3.0 * other_judges) / n};
    double max {(rating + 3.0 * other_judges) / n};
    std::cout << std::setprecision(5) << min << " " << max << '\n';
}
