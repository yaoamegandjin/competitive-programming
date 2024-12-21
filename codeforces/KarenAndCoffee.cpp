// Problem link: https://codeforces.com/contest/816/problem/B
#include <iostream>
#include <vector>
const int maxTemp {200000};
int main() {
    int n {}, k {}, q {}, low {}, high {};
    std::cin >> n >> k >> q;
    std::vector<int> A(maxTemp);
    for (int i{ 0 }; i < n; i++) {
        std::cin >> low >> high;
        A[low]++;
        A[high + 1]--;

    }

    for (int i{ 1 }; i <= maxTemp; i++) {
        A[i] += A[i - 1];
    }

    for (int i{ 1 }; i <= maxTemp; i++) {
        A[i] = A[i - 1] + (A[i] >= k ? 1 : 0);
    }
    while (q--) {
        std::cin >> low >> high;
        std::cout << A[high] - A[low - 1] << '\n';
    }

}
