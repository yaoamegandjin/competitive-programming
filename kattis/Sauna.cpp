//Problem link: https://open.kattis.com/problems/sauna
#include <iostream>
#include <iomanip>
#include <limits.h>

int main() {
    int N {}, a {}, b {};
    std::cin >> N;
    int low {-1};
    int high {INT_MAX};
    for (int i {0}; i < N; i++) {
        std::cin >> a >> b;
        low = std::max(low, a);
        high = std::min(high, b);
    }

    if (low > high) {
        std::cout << "bad news\n";
    } else {
        std::cout << (high - low + 1) << " " << low << '\n';
    }
}
