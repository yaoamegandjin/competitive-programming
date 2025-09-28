// Problem link: https://open.kattis.com/problems/coast
#include <iostream>
#include <vector>
#include <queue>
#include <utility>

int main() {
    int dx[4] = {0, 0, 1, -1};
    int dy[4] = {1, -1, 0, 0};
    int N {}, M {}, length {};
    std::string row {};
    std::cin >> N >> M;
    std::vector<std::vector<char>> grid(N + 2, std::vector<char>(M + 2));
    
    for (int i { 0 }; i < N + 2; i++) {
        for (int j { 0 }; j < M + 2; j++) {
            grid[i][j] = '0';
        }
    }
    for (int i { 0 }; i < N; i++) {
        std::cin >> row;
        for (int j { 0 }; j < M; j++) {
            grid[i + 1][j + 1] = row[j];
        }
    }

    std::queue<std::pair<int, int>> q;
    q.push({0, 0});
    grid[0][0] = '#';
    while(!q.empty()) {
        std::pair<int, int> p = q.front();
        q.pop();
        int x = p.first;
        int y = p.second;
        for (int k { 0 }; k < 4; k++) {
            int s = x + dx[k];
            int t = y + dy[k];
            if (s < 0 || s >= N + 2 || t < 0 || t >= M + 2) {
                continue;
            }
            if (grid[s][t] == '1') {
                length++;
            } else if (grid[s][t] == '0') {
                grid[s][t] = '#';
                q.push({s, t});
            }
        }
    }
    std::cout << length << '\n';
}

