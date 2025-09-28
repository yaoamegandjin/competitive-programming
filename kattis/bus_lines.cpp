//Problem link: https://open.kattis.com/problems/buslines
#include <iostream>

int main() {
    int n {}, m {};
    std::cin >> n >> m;

    if(m < n-1 || m > 2*n-3){
        std::cout << "-1\n";
        return 0;
    }
    for(int c1 = 0; c1 < n-1; c1++){
        std::cout << c1+1 << " " << c1+2 << "\n";
    }
    for(int c1 = 0; c1 < m-n+1; c1++){
        std::cout << c1+1 << " " << c1+3 << "\n";
    }

    return 0;
}
