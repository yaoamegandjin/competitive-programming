// Problem link: https://cses.fi/problemset/task/2183/
#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    int n{};
    long long int smallestCoin {1};
    std::cin >> n;
    std::vector<int> coins(n);

    for (int i{0}; i < n; i++) {
        std::cin >> coins[i];
    }

    std::sort(coins.begin(), coins.end());

    for (int i {0}; i < n; i++) {
        if (coins[i] > smallestCoin) {
            std::cout << smallestCoin << '\n';
            return 0;
        }

        smallestCoin += coins[i];

    }
    std::cout << smallestCoin << '\n';
}
