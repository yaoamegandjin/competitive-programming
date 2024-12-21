// Problem link: https://cses.fi/problemset/task/1640/
#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>

int main() {
    int n{}, target{}, a{};
    std::cin >> n >> target;
    std::vector<std::pair<int, int>> A(n);

    for (int i {0}; i < n; i++) {
        std::cin >> a;
        A[i] = {a, i + 1};
    }
    std::sort(A.begin(), A.end());
    int left {0};
    int right {n - 1};

    while (left < right) {
        if (A[left].first + A[right].first > target) {
            right--;
        } else if (A[left].first + A[right].first < target) {
            left++;
        } else {
            std::cout << A[left].second << " " << A[right].second << '\n';
            return 0;

        }
    }

    std::cout << "IMPOSSIBLE\n";
}
