// Problem link: https://open.kattis.com/problems/cutthenegativity
#include <iostream>
#include <vector>
#include <tuple>
#include <algorithm>

int main() {
    int n {};
    std::cin >> n;
    std::vector<std::vector<int>> table(n, std::vector<int>(n));
    std::vector<std::tuple<int, int, int>> list;
    for (int r { 0 }; r < n; r++) {
        for (int c { 0 }; c < n; c++) {
            std::cin >> table[r][c];
        }
    }

    for (int r { 0 }; r < n; r++) {
        for (int c { 0 }; c < n; c++) {
            if (table[r][c] == -1) {
                continue;
            }
            list.push_back({r + 1, c + 1, table[r][c]});
        }
    }

    std::sort(list.begin(), list.end(), [](std::tuple<int, int, int> a, std::tuple<int, int, int> b) {
        if (std::get<0>(a) != std::get<0>(b)) {
            return std::get<0>(a) < std::get<0>(b);
        } else {
            return std::get<1>(a) < std::get<1>(b);
        }
    });

    std::cout << list.size() << '\n';
    int u {}, v {}, c {};
    for (auto f: list) {
        std::tie(u, v, c) = f;
        std::cout << u << " " << v << " " << c << "\n";

    }

}
