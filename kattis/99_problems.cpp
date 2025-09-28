// Problem link: https://open.kattis.com/problems/99problems
#include <iostream>

const int MAXN = 10000;
int main() {
    int N {}, ans {} , diff {100 * MAXN};
    std::cin >> N;
    for (int c { 1 }; c < MAXN; c++) {
        if (c % 100 == 99) {
            int d = std::abs(c - N);
            if (d <= diff) {
                diff = d;
                ans = c;
            }
        }
    } 

    std::cout << ans << '\n';

}
