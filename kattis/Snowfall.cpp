// Problem link: https://open.kattis.com/problems/snowfall
#include <iostream>
#include <iomanip>

int main() {
    int n {}, t{}, a{}, depthOfSnow {};
    std::cin >> n;
    for (int i {0}; i < n; i++) {
        std::cin >> t >> a;
        if (t == 0) {
            depthOfSnow += a;
        } else {
            depthOfSnow = std::max(0, depthOfSnow - a);
        }
    }

    std::cout << depthOfSnow << '\n';

}
