// Problem link: https://open.kattis.com/problems/peasoup

#include <iostream>
#include <string>

int main() {
    int n {}, k {};
    std::cin >> n;
    for (int i {0}; i < n; i++) {
        std::cin >> k;
        std::cin.ignore();
        std::string name {};
        std::getline(std::cin, name);
        bool a { false }, b { false };
        std::string line {};
        for (int j { 0 }; j < k; j++) {
            std::getline(std::cin, line);
            if (line == "pea soup") {
                a = true;
            }
            if (line == "pancakes") {
                b = true;
            }
        }
        if (a && b) {
            std::cout << name << '\n';
            return 0;
        }
    }
    std::cout << "Anywhere is fine I guess\n";

}
