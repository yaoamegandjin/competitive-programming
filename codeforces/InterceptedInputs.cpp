//Problem link: https://codeforces.com/contest/2037/problem/B
#include <iostream>
#include <vector>
#include <algorithm>

void solve() {
    int k{}, a{};
    std::cin >> k;
    std::vector<int> A(k);
    for (int i {0}; i < k; i++) {
        std::cin >> a;
        A[i] = a;
    }
    std::sort(A.begin(), A.end());
    int left {}, right{k - 1};

    while (left < right) {
        if (A[left] * A[right] + 2 > k) {
            right--;
        } else if (A[left] * A[right] + 2 < k) {
            left++;
        } else {
            std::cout << A[left] << " " << A[right] << '\n';
            return;
        }
    }
}

int main() {
    int t{};
    std::cin >> t;
    while(t--) {
        solve();
    }
}
