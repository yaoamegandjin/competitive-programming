// Problem link: https://open.kattis.com/problems/blackfriday

#include <iostream>
#include <map>
#include <vector>

int main() {
    int n {}, a {};
    std::map<int, std::vector<int>> G;
    std::cin >> n;
    for (int i { 1 }; i <= n; i++) {
        std::cin >> a;
        G[a].push_back(i);
    }

    for (int i { 6 }; i >= 1; i--) {
        if (G[i].size() == 1) {
            std::cout << G[i][0];
            return 0;
        }
    }
    std::cout << "none\n";
}
