// Problem link https://open.kattis.com/contests/ayw3h9/problems/emergencyexit
#include <iostream>
#include <vector>
#include <utility>
#include <queue>
#include <cmath>
#include <algorithm>


int dx[5] = {1, 0, -1, 0, 0};
int dy[5] = {0, 1, 0, -1, 0};
std::string dir = "DRUL.";
std::vector<std::vector<bool>> grid;
std::vector<std::vector<int>> next;
std::vector<std::vector<int>> dist;
int N {}, M {}, door_x {}, door_y {};
std::vector<std::pair<int, int>> person;
std::vector<int> order;

bool inbounds(int i, int j) {
    return i >= 0 && j >= 0 && i < N && j < M;
}

bool comp(int i, int j) {
    return dist[person[i].first][person[i].second] < dist[person[j].first][person[j].second];
}
void bfs() {
    for (int c1 { 0 };  c1 < N; c1++) {
        for (int c2 { 0 }; c2 < M; c2++) {
            dist[c1][c2] = -1;
        }
    }
    std::queue<std::pair<int, int>> q;
    q.push({door_x, door_y});
    dist[door_x][door_y] = 1;
    for (int c1 { 0 }; c1 < 4; c1++) {
        int x = door_x + dx[c1];
        int y = door_y + dy[c1];
        if (!inbounds(x, y)) {
            next[door_x][door_y] = c1;
        }
    }

    while(!q.empty()) {
        std::pair<int, int> p = q.front();
        q.pop();
        int x = p.first;
        int y = p.second;
        for (int c1 { 0 }; c1 < 4; c1++) {
            int x2 = x + dx[c1];
            int y2 = y + dy[c1];
            if (inbounds(x2, y2) && dist[x2][y2] == -1 && !grid[x2][y2]) {
                next[x2][y2] = (c1 + 2) % 4;
                dist[x2][y2] = dist[x][y] + 1;
                q.push({x2, y2});
            }
        }

    }

}

int main() {
    std::cin >> N >> M;
    grid = std::vector<std::vector<bool>>(N, std::vector<bool>(M));
    next = std::vector<std::vector<int>>(N, std::vector<int>(M));
    dist = std::vector<std::vector<int>>(N, std::vector<int>(M));
    int k {0};
    for (int c1 { 0 }; c1 < N; c1++) {
        std::string row {};
        std::cin >> row;
        for (int c2 { 0 }; c2 < M; c2++) {
            if (row[c2] == '#') {
                grid[c1][c2] = 1;
            }
            if (row[c2] == 'P') {
                order.push_back(k);
                k++;
                person.push_back({c1, c2});
            }
            if ((c1 == 0 || c2 == 0 || c1 == N - 1 || c2 == M - 1) && !grid[c1][c2]) {
                door_x = c1;
                door_y = c2;
            }
        }
    }
    bfs();
    std::sort(order.begin(), order.end(), comp);
    std::vector<int> D;
    bool fail = 0;
    for (int c1 { 0 }; c1 < k; c1++) {
        D.push_back(dist[person[c1].first][person[c1].second]);
        if (D.back() == -1) {
            fail = 1;
        }
    }
    if (fail) {
        std::cout << "-1\n";
        return 0;
    }

    std::sort(D.begin(), D.end());
    for (int c1 { 1 }; c1 < k; c1++) {
        D[c1] = std::max(D[c1], D[c1 - 1] + 1);
    }
    int total {D.back()};
    std::vector<std::string> ANS(k, "");
    for (int c1 { 0 }; c1 < k; c1++) {
        int i = order[c1];
        int d = D[c1];
        int x = person[i].first;
        int y = person[i].second;
        for (int c2 { 0 }; c2 < d - dist[x][y]; c2++) {
            ANS[i] += dir[4];
        }
        while(inbounds(x, y)) {
            int j = next[x][y];
            ANS[i] += dir[j];
            x += dx[j];
            y += dy[j];
        }
        while(ANS[i].size() < total) {
            ANS[i] += dir[4];
        }
    }
    std::cout << total << "\n";
    for (int c1 { 0 }; c1 < k; c1++) {
        std::cout << ANS[c1] << '\n';
    }
    return 0;
}
