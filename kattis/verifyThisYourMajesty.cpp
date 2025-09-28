//Problem link: https://open.kattis.com/problems/queens
#include <iostream>
#include <vector>

int main() {
    int N {}, x {}, y {};
    std::cin >> N;
    std::vector<std::vector<bool>> board(N, std::vector<bool>(N));
    std::vector<bool> rowTaken(N);
    std::vector<bool> diag1(N * 2 - 1);
    std::vector<bool> diag2(N * 2 - 1);

    for (int i {0}; i < N; i++) {
        std::cin >> x >> y;
        if(rowTaken[x] || diag1[x + y] || diag2[x - y + N - 1]) {
            std::cout << "INCORRECT" << '\n';
            return 0;
        }
        rowTaken[x] = diag1[x + y] = diag2[x - y + N - 1] = true;
    }
    std::cout << "CORRECT" << '\n';
    

}
