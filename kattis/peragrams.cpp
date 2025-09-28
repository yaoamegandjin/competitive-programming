// Problem link: https://open.kattis.com/problems/peragrams
#include <iostream>
#include <string>
#include <vector>

int main() {
    std::string s {};
    std::vector<int> counts(26);
    std::cin >> s;
    for (int i {0}; i < s.size(); i++) {
        counts[s[i] - 'a']++;
    }
    int ans {0};
    for (int i {0}; i < 26; i++) {
        if (counts[i] % 2 == 1) {
            ans++;
        }
    }
    --ans;
    if (ans < 0) {
        std::cout << "0\n";
    } else {
        std::cout << ans << '\n';
    }

}
