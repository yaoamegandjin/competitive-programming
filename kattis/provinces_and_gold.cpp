//Problem link: https://open.kattis.com/problems/provincesandG
#include <iostream>

int main() {
    int G {}, S {}, C {};
    std::cin >> G >> S >> C;
    int value { 3 * G + 2 * S + C};
    if (value >= 8) {
        std::cout << "Province or ";
    } else if (value >= 5) {
        std::cout << "Duchy or ";
    } else if (value >= 2) {
        std::cout << "Estate or ";
    }

    if (value >= 6) {
        std::cout << "Gold\n";
    } else if (value >= 3) {
        std::cout << "Silver\n";
    } else {
        std::cout << "Copper\n";
    }
}
