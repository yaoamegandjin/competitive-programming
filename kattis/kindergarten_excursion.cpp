// Problem link: https://open.kattis.com/problems/excursion
#include <iostream>
#include <string>

int main() {
    std::string s {}; long long ans {0};
    int freq[3] = {0, 0, 0};
    std::cin >> s;
    for (int i { 0 }; i < s.size(); i++) {
        for (int j {s[i] - '0' + 1}; j <= 2; j++) {
            ans += freq[j];
        }
        freq[s[i] - '0']++;
    }
    std::cout << ans << '\n';
}
