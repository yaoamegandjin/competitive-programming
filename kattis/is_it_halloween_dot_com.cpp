// Problem link: https://open.kattis.com/contests/kdfshe/problems/isithalloween
#include <iostream>
#include <string>

int main() {
    std::string month {}, day {};
    std::cin >> month >> day;
    if (((month + " " + day ) == "DEC 25") || (month + " " + day) == "OCT 31") {
        std::cout << "yup\n";
    } else {
        std::cout << "nope\n";
    }
}
