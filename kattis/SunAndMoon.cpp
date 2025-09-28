// Problem link: https://open.kattis.com/problems/sunandmoon
#include <iostream>

const int ECLIPSE_CYCLE {5000};

int main() {
    int d_s{}, y_s{}, d_m{}, y_m{};
    std::cin >> d_s >> y_s >> d_m >> y_m;

    for (int i {1}; i <= ECLIPSE_CYCLE; i++) {
        if (((d_s + i) % y_s) == 0 && ((d_m + i) % y_m) == 0) {
            std::cout << i << '\n';
            return 0;
        }
    }
}
