//Problem link: https://open.kattis.com/problems/espressobucks
#include <iostream>
#include <string>
#include <utility>
#include <vector>



int n {}, m {};
std::vector<std::string> grid(100);
std::vector<std::pair<int, int>> cells;
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};

bool inbounds(int i, int j) {
    return i >= 0 && j >= 0 && i < n && j < m;
}

int main() {
    std::cin >> n >> m;
    for (int r { 0 }; r < n; r++) {
        std::cin >> grid[r];
        for (int c { 0 }; c < m; c++) {
            cells.push_back({r, c});
        }
    }

    for (int i { 0 }; i < n * m; i++) {
        int x = cells[i].first;
        int y = cells[i].second;
        if (grid[x][y] == '.') {
            bool covered = false;
            for (int j { 0 }; j < 4; j++) {
                if (inbounds(x + dx[j], y + dy[j])) {
                    if (grid[x + dx[j]][y + dy[j]] == 'E') {
                        covered = true;
                    }
                }
            }
            if (!covered) {
                grid[x][y] = 'E';
            }
        }
    }
    for (int r { 0 }; r < n; r++) {
        std::cout << grid[r] << '\n';
    }
    return 0;
}
