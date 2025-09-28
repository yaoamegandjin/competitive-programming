//Problem link: https://open.kattis.com/problems/apaxianparent

#include <iostream>
#include <string>

int main() {
    std::string Y {}, P {}, v {"aiou"};

    std::cin >> Y >> P;

    if (Y[Y.size() - 1] == 'e') {
        std::cout << Y << "x" << P << '\n'; 
    } else if (v.find(Y.substr(Y.size() - 1)) != std::string::npos) {
        Y = Y.substr(0, Y.size() - 1);
        std::cout << Y << "ex" << P << '\n';
    } else if (Y.substr(Y.size() - 2) == "ex") {
        std::cout << Y << P << '\n';
    } else {
        std::cout << Y << "ex" << P << '\n';
    }

    
}
