// Problem link: https://open.kattis.com/problems/secondopinion?tab=submissions
#include <iostream>

int main() {
    int hrs, min, s {};
    std::cin >> s;

    hrs = s / 3600;
    min = (s % 3600) / 60;
    s = (s % 3600) % 60;

    std::cout << hrs << " : "  << min << " : " << s << '\n';



}
