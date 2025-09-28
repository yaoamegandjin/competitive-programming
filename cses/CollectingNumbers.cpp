//Problem link: https://cses.fi/problemset/task/2216/
#include <iostream>
#include <vector>

int main() {
    int n{}, rounds{1};
    std::cin >> n;
    std::vector<int> a(n);
    std::vector<long> indices(n + 1);

    for (int i{1}; i <= n; i++) {
        std::cin >> a[i];
    }

    for (int i{1}; i <= n; i++) {
        indices[a[i]] = i;
    }

    for (int num{1}; num < n; num++) {
        if (indices[num + 1] < indices[num]) {
            rounds++;
        }
    }

    std::cout << rounds << '\n';

}
