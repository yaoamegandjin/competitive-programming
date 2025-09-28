#include <iostream>
#include <vector>
#include <string>

int main() {
    int n { 1000 }, guesses { 10 };
    std::string response {};
    std::vector<int> numbers(n);
    for (int i { 0 }; i < n; i++) {
        numbers[i] = i + 1;
    }
    int left { 0 }, right { n - 1 },mid {};
    while (guesses > 0) {
        mid = (left + right) / 2;
        std::cout << numbers[mid] << '\n';
        guesses--;
        std::cin >> response;
        if (response == "lower") {
            right = mid - 1;
        } else if (response == "higher") {
            left = mid + 1;
        } else {
            break;
        }
    }
}
