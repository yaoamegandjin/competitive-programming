// Problem link: https://open.kattis.com/problems/pairingsocks?tab=submissions
#include <iostream>
#include <stack>

int main() {
    int n {}, a {}, moves {};
    std::cin >> n;
    std::stack<int> original, auxilary;
    for (int i { 0 }; i < 2 * n; i++) {
        std::cin >> a;
        original.push(a);
    }

    while (original.size() > 0) {
        auxilary.push(original.top());
        original.pop();
        moves++;
        while (original.size() > 0 && auxilary.size() > 0 && original.top() == auxilary.top()) {
            original.pop();
            auxilary.pop();
            moves++;
        }
    }
    if (auxilary.size() > 0) {
        std::cout << "impossible\n";
    } else {
        std::cout << moves << '\n';
    }
}
