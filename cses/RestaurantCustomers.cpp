//Problem link: https://cses.fi/problemset/task/1619/
#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#include <iomanip>
int main() {
    int numOfCustomers {}, arrival {}, leave {};
    std::vector<std::pair<int, int>> times(numOfCustomers);
    std::cin >> numOfCustomers;
    for (int i {0}; i < numOfCustomers; i++) {
        std::cin >> arrival >> leave;
        times.push_back({arrival, 1});
        times.push_back({leave, -1});
    }
    std::sort(times.begin(), times.end());
    int max_ppl {};
    int curr_ppl {};

    for (auto t: times) {
        curr_ppl += t.second;
        max_ppl = std::max(max_ppl, curr_ppl);
    }
    std::cout << max_ppl << '\n';
}
