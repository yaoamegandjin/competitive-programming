// Problem link: https://cses.fi/problemset/task/1629/
#include <iostream>
#include <algorithm>
#include <utility>


int main() {
    int n{}, a{}, b{};
    std::vector<std::pair<int, int>> movie_times;
    std::cin >> n;
    for (int i {0}; i < n; i++) {
        std::cin >> a >> b;
        movie_times.push_back({a, b});
    }
    std::sort(movie_times.begin(), movie_times.end(), [](std::pair<int, int> a, std::pair<int, int> b) {
        return a.second < b.second;
    });

    int endTime{}, i {}, count{};
    while (i < n) {
        if (endTime <= movie_times[i].first) {
            endTime = movie_times[i].second;
            count++;
            i++;
        } else {
            i++;
        }
    }
    std::cout << count << '\n';

}
