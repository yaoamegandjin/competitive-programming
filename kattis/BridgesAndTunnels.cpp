#include <iostream>
#include <map>
#include <string>

int main() {
    int n {}, count {};
    std::cin >> n;
    std::string building1 {}, building2 {};
    std::map<std::string, int> buildings;
    for (int i {0}; i < n; i++) {
        std::cin >> building1 >> building2;
        if (!buildings.contains(building1)) {
            buildings.insert({building1, 1});
        }
        buildings[building1]++;
        if (!buildings.contains(building2)) {
            buildings.insert({building2, 1});
        } 
        
        buildings[building2]++;
        count = (buildings[building1] + buildings[building2]);
       
        std::cout << count << '\n';
    }
}
