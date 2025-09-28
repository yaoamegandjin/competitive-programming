// Problem link: https://open.kattis.com/problems/marswindow
#include <iostream>

int main() {
    int y {};
    std::cin >> y;
    int launchYear { 2018 };
    int launchMonth { 3 };
    while (launchYear < y) {
        launchMonth += 26;
        while(launchMonth >= 12) {
            launchYear++;
            launchMonth -= 12;
        }
    }
    if (launchYear == y) {
        std::cout << "yes\n";
    } else {
        std::cout << "no\n";
    }
}
