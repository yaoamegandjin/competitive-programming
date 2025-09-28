// Problem link: https://open.kattis.com/problems/outofsorts
#include <iostream>
#include <vector> 

bool binary_search(std::vector<long long>& v, int size, long long x) {
    int left {1}, right = size - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (v[mid] == x) {
            return true;
        }
        if (v[mid] > x) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return false;
}
int main() {
    int n{}; 
    long long m{}, a{}, c{}, x_0 {}, count {};
    std::cin >> n >> m >> a >> c >> x_0;
    std::vector<long long> sequence(n + 1);
    sequence[0] = x_0;

    for (int i {1}; i < n + 1; i++) {
        sequence[i] = (a * sequence[i - 1] + c) % m;
    }

    for (int i {1}; i < n + 1; i++) {
        count += binary_search(sequence, n + 1, sequence[i]);
    }
    std::cout << count << '\n';

}
