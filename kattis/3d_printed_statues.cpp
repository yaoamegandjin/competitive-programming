#include <iostream>
// Problem link: https://open.kattis.com/problems/3dprinter
int main() {
    int n {}, days {1}, printers {1};
    std::cin >> n;
    while (printers < n) {
        days++;
        printers *= 2;
    }
    std::cout << days << '\n';
}
