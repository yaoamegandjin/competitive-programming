// Problem link: https://open.kattis.com/problems/batterup
#include <iostream>

int main() {
    int n {};
    double bases {}, walks {}, atBat {};

    std::cin >> n;

    for (int i {0}; i < n; i++) {
        std::cin >> atBat;
        if (atBat == -1) {
            walks++;
        } else {
            bases += atBat;
        }
    }
    std::cout << (bases / (n - walks)) << '\n';


}
