// Problem link: https://cses.fi/problemset/task/1084
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
int main() {
    int n {}, m {}, k {}, i {}, j {}, count {};
    std::cin >> n >> m >> k;
    std::vector<int> desiredSize(n);
    std::vector<int> apartmentSize(m);
    for (int i{ 0 }; i < n; i++) {
        std::cin >> desiredSize[i];
    }

    for (int i{ 0 }; i < m; i++) {
        std::cin >> apartmentSize[i];
    }
    std::sort(desiredSize.begin(), desiredSize.end());
    std::sort(apartmentSize.begin(), apartmentSize.end());

    while (i < n && j < m) {
        if (std::abs(desiredSize[i] - apartmentSize[j]) <= k) {
            i++;
            j++;
            count++;
        } else if (desiredSize[i] < apartmentSize[j]) {
            i++;
        } else {
            j++;
        }
    }

    std::cout << count << '\n';
}
