// Problem link: https://cses.fi/problemset/task/1091
#include <iostream>
#include <set>
#include <iterator>
int main() {
    int n {}, m {}, h {}, t {};
    std::cin >> n >> m;
    std::multiset<int> ticketPrice;
    for(int i{0}; i < n; i++) {
        std::cin >> h;
        ticketPrice.insert(h);
    }

    for (int i{0}; i < m; i++) {
        std::cin >> t;
        auto it = ticketPrice.upper_bound(t);
        if (it == ticketPrice.begin()) {
            std::cout << -1 << '\n';
        } else {
            std::cout << *(--it) << '\n';
            ticketPrice.erase(it);
        }
    }
}
