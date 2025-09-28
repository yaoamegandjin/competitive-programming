// Problem link: https://open.kattis.com/problems/zoning
#include <iostream>
#include <queue>
#include <utility>
#include <string>

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int n {};
bool inbounds(int x, int y) {
    return x >= 0 && y >= 0 && x < n && y < n;
}

int main() {
    std::cin >> n;
    std::vector<std::vector<char>> town(n, std::vector<char>(n));
    int d[n][n];
    std::queue<std::pair<int, int>> q;
    std::string row {};
    for (int i { 0 }; i < n; i++) {
        std::cin >> row;
        for (int j { 0 }; j < n; j++) {
            town[i][j] = row[j];
            if (town[i][j] == '3') {
                d[i][j] = 0;
                q.push({i, j});
            } else {
                d[i][j] = -1;
            }
        }
    }
    int ans { 0 };
    while (!q.empty()) {
        std::pair<int, int> p = q.front();
        q.pop();
        int x = p.first;
        int y = p.second;
        if (town[x][y] == '1') {
            ans = std::max(ans, d[x][y]);
        }
        for (int k {0}; k < 4; k++) {
            int x2 = x + dx[k];
            int y2 = y + dy[k];
            if (inbounds(x2, y2) && d[x2][y2] == -1) {
                d[x2][y2] = d[x][y] + 1;
                q.push({x2, y2});
            }

        }

    }
    std::cout << ans << '\n';
}
