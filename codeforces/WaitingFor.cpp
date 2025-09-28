// Problem link: https://codeforces.com/contest/2038/problem/J
#include <iostream>
#include <string>
#include <cmath>
int main() {
    int n {};
    std::string event {};
    long long int k {}, freeSeats {}, numOfPeople {};
    std::cin >> n;

    for (int i {0}; i < n; i++) {
        std::cin >> event >> k;
        if (event == "B") {
            freeSeats = k;
            if (freeSeats > numOfPeople) {
                std::cout << "YES" << '\n';
            } else {
                std::cout << "NO" << '\n';
            }
            numOfPeople -= std::min(freeSeats, numOfPeople);
        } else {
            numOfPeople += k;
        }
    }

}
