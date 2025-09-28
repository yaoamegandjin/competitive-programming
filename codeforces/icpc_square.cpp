#include <iostream>

int main() {
    long long int N {}, max{};
    int D{}, S{};
    std::cin >> N >> D >> S;
    max = S;
    for (int y {S + 1}; y <= N; y++) {
        if (y % S == 0 && y - S <= D) {
            max = y;
        }
    }

    std::cout << max << '\n';
}
