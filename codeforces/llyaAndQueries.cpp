// Problem link: https://codeforces.com/contest/313/problem/B
#include <iostream>
#include <vector>
#include <string>

int main() {
    std::string s {};
    std::cin >> s;
    std::vector<int> A(s.size());
    std::vector<int> prefixOfA(s.size() + 1);

    for (int i{0}; i + 1 < s.size(); i++) {
        if (s[i] == s[i + 1]) {
            A[i] = 1;
        } else {
            A[i] = 0;
        }
    }

    for (int i{0}; i < std::size(A); i++) {
        prefixOfA[i + 1] += prefixOfA[i] + A[i];
    }

    int m {}, l {}, r {};
    std::cin >> m;

    for (int i{0}; i < m; i++) {
        std::cin >> l >> r;
        std::cout << prefixOfA[r - 1] - prefixOfA[l - 1] << '\n';
    }

}
