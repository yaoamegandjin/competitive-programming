// Problem link: https://cses.fi/problemset/task/1091
#include <iostream>
#include <algorithm>
#include <vector>

int main() {
    int n {}, x {}, count {};
    std::cin >> n >> x;
    std::vector<int> weightsOfChildren(n);
    for (int i {0}; i < n; i++) {
        std::cin >> weightsOfChildren[i];
    }
    int i {0};
    int j {n - 1};

    std::sort(weightsOfChildren.begin(), weightsOfChildren.end());
    while (i <= j) {
        count++;
        if (weightsOfChildren[i] + weightsOfChildren[j] > x) {
            j--;
        } else {
            i++;
            j--;
        }
    }
    std::cout << count << '\n';
}
