// Problem link: https://open.kattis.com/problems/cornhusker
#include <iostream>

int main() {
    int A{}, L{}, KWF {}, N {}, total {};
    for (int i { 0 }; i < 5; i++) {
        std::cin >> A >> L;
        total += A * L;
    }
    std::cin >> N >> KWF;
    std::cout << (N * (total / 5)) / KWF << '\n';

}
