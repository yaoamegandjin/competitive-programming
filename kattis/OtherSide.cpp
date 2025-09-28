// Problem link: https://open.kattis.com/problems/otherside?tab=metadata
#include <iostream>
#include <iomanip>

int main() {
    int W{}, S{}, C{}, K{};
    std::cin >> W >> S >> C >> K;

    if (std::min(S, W + C) < K) {
        std::cout << "YES" << '\n';
    } else if (std::min(S, W + C) == K && std::max(S, W + C) <= 2 * K) {
        std::cout << "YES" << '\n';
    } else {
        std::cout << "NO" << '\n';
    }

}
