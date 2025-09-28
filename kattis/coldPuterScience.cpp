// Problem link: https://open.kattis.com/problems/cold?tab=submissions
#include <iostream>
#include <iomanip>
int main() {
    int n {}, t {}, count {};
    std::cin >> n;
    for (int i {0}; i < n; i++){
        std::cin >> t;
        if (t < 0) {
            count++;
        }
    }
    std::cout << count << '\n';
}
