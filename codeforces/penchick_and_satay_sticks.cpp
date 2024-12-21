#include <iostream>
#include <vector>

void swap(int i, int j, std::vector<int> a) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}
void solve() {
    int n{}, p{}; 
    bool is_sorted{true};
    std::cin >> n;
    std::vector<int> satay_sticks(n);
    for (int i{0}; i < n; i++) {
        std::cin >> p;
        satay_sticks[i] = p--;
    }

    for (int i{0}; i < n; i++) {

        if (satay_sticks[i] == i) {
            continue;
        }
        if (satay_sticks[i] == i + 1 && satay_sticks[i + 1] == i) {
            swap(i, i + 1, satay_sticks);
        } else {
            is_sorted = false;
        }
    }
    std::cout << is_sorted ? "YES" : "NO";
}

int main() {
    int t{};
    std::cin >> t;
    while(t--) {
        solve();
    }

}
