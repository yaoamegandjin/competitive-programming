// Problem link: https://open.kattis.com/contests/kdfshe/problems/judging
#include <iostream>
#include <set>
#include <algorithm>
#include <string>

int main() {
    int n {}, res {0};
    std::string s{};
    std::cin >> n;
    std::multiset<std::string> judges;
    for (int i { 0 }; i < n; i++) {
        std::cin >> s;
        judges.insert(s);
    }

    for (int i { 0 }; i < n; i++) {
        std::cin >> s;
        std::multiset<std::string>::iterator pos = judges.find(s);
        if (pos != judges.end()) {
            res++;
            judges.erase(pos);
        }
    }
    std::cout << res << '\n';
  
}
