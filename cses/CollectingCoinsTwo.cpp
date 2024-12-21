#include<iostream>
#include<vector>

void swap(std::vector<long> n, int i, int j) {
    long temp = n[i];
    n[i] = n[j];
    n[j] = temp;
}
int main() {
    int n{}, m{}, a{}, b{}, rounds{1};
    std::cin >> n >> m;
    std::vector<int> N(n);
    std::vector<long> indices(n + 1);
    for (int i{0}; i < n; i++) {
        std::cin >> N[i];
    }
    for (int i{1}; i <= n; i++) {
        indices[N[i]] = i;
    }
    for (int i{0}; i < m; i++) {
        std::cin >> a >> b;
        swap(indices, a, b);
        for(int num{1}; num < n; num++) {
            if (indices[num + 1] < indices[num]) {
                rounds++;
            }
        }
        std::cout << rounds << '\n';
        rounds = 1;
    }


}
