// Problem link: https://codeforces.com/contest/433/problem/B
#include <iostream>
#include <algorithm>
#include <vector>
int main() {
    int n {}, m {}, l {}, r {}, type {};
    std::cin >> n;
    std::vector<long long> v(n);
    for(int i{ 0 }; i < n; i++) {
        std::cin >> v[i];
    }
    std::vector<long long> u(v);
    std::sort(u.begin(), u.end());
    std::vector<long long> vPrefix(n + 1);
    std::vector<long long> uPrefix(n + 1);
    for(int i{0}; i < n; i++) {
        vPrefix[i + 1] += vPrefix[i] + v[i];
        uPrefix[i + 1] += uPrefix[i] + u[i];
    }
    std::cin >> m;

    for(int i {0}; i < m; i++) {
        std::cin >> type;
        std::cin >> l;
        std::cin >> r;
        if (type == 1) {
            std::cout << vPrefix[r] - vPrefix[l - 1] << '\n';
        } else {
            std::cout << uPrefix[r] - uPrefix[l - 1] << '\n';
        }

    }

}
